
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.service.IHabilidadService;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
//@CrossOrigin(origins = "https://frontendap-c120f.web.app")
@CrossOrigin(origins ={"http://localhost:4200", "https://frontendap-c120f.web.app"})
public class HabilidadController {

    private final IHabilidadService habilidadServ;

    public HabilidadController(IHabilidadService habilidadServ) {
        this.habilidadServ = habilidadServ;
    }
      
    @PreAuthorize("hasRole('ADMIN')")     
    @PostMapping("/new")
    public void agregarHabilidad (@RequestBody Habilidad hab) {
        habilidadServ.crearHabilidad(hab); 
//        try {
//            Habilidad habilidadGuardada = habilidadServ.crearHabilidad(hab); 
//            return ResponseEntity.created(new URI("/habilidad/"+habilidadGuardada.getId())).body(habilidadGuardada);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }

    }
    
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Habilidad> verHabilidades() {
        return habilidadServ.verHabilidades();
    }
    
                    
    @GetMapping ("/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad(@PathVariable Long id) {
        return habilidadServ.buscarHabilidad(id);
    }
    
    @GetMapping ("buscar/{nombre}")
    @ResponseBody
    public Habilidad buscarHabilidadNombre(@PathVariable String nombre) {
        return habilidadServ.buscarHabilidadNombre(nombre);
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping ("/edit")
    public void editarHabilidad (@RequestBody Habilidad hab) {
        habilidadServ.editarHabilidad(hab);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id) {
        habilidadServ.borrarHabilidad(id);
    }
    
}