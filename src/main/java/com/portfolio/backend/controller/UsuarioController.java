
package com.portfolio.backend.controller;

import com.portfolio.backend.dto.JwtDto;
import com.portfolio.backend.dto.LoginUsuario;
import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.dto.NuevoUsuario;
import com.portfolio.backend.enums.RolNombre;
import com.portfolio.backend.jwt.JwtProvider;
import com.portfolio.backend.model.Rol;
import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.service.RolService;
import com.portfolio.backend.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
//@CrossOrigin(origins = "https://frontendap-c120f.web.app")
@CrossOrigin(origins ={"http://localhost:4200", "https://frontendap-c120f.web.app"})
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
     
    @Autowired   
    UsuarioService usuarioService;
    
    @Autowired    
    RolService rolService;
    
    @Autowired        
    JwtProvider jwtProvider;

        
    //@PreAuthorize("hasRole('ADMIN')")
    //
    //para crear el primer usuario desabilitar
    @PostMapping("/newUser")
    public ResponseEntity<?> nuevo (@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        System.out.println("sin errores L69");
        Usuario usuario = 
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        System.out.println("usuario: " + usuario);
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin"))
            System.out.println("usuario admin");
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario Guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
//
//    @PostMapping("/logout")
//    public void finalizarSesion (@RequestBody Login user) {
//        loginServ.finalizarSesion(user);
//    }   
//    
//    @DeleteMapping("/deleteUser")
//    public void eliminarUsuario (@RequestBody Login user) {
//        loginServ.eliminarUsuario(user);
//    }   
//
