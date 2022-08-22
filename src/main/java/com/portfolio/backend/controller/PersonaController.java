
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import java.sql.Blob;
import java.util.List;
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
@RequestMapping("/persona")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@CrossOrigin(origins = "https://frontendap-c120f.web.app")
//@CrossOrigin(origins = "**")
//@CrossOrigin
public class PersonaController {

    
    private final IPersonaService personaServ;

    public PersonaController(IPersonaService personaServ) {
        this.personaServ = personaServ;
    }        
   
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void agregarPersona (@RequestBody Persona pers) {
        personaServ.crearPersona(pers);
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/image-upload")
    public void agregarImagen (@RequestBody Blob img) {
        personaServ.agregarImagen(img);
    }
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Persona> verPersonas() {
        System.out.println("com.portfolio.backend.controller.PersonaController.verPersonas()");
        return personaServ.verPersonas();
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/edit")
    public void editarPersona (@RequestBody Persona pers) {
        personaServ.editarPersona(pers);
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
        personaServ.borrarPersona(id);
    }

    
}