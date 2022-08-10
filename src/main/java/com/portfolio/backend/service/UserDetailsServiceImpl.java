
package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.model.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioService usuarioService;
            
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        
        System.out.println(nombreUsuario);
        
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        
        System.out.println(usuario);
        
        return UsuarioPrincipal.build(usuario);
 // return new User (usuario.getNombreUsuario(),usuario.getPassword(),usuario.getRoles());
    }
    
}
