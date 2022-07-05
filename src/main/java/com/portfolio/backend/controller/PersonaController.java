
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
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
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")

public class PersonaController {

    
    private final IPersonaService personaServ;

    public PersonaController(IPersonaService personaServ) {
        this.personaServ = personaServ;
    }        
   
    @PostMapping("/new")
    public void agregarPersona (@RequestBody Persona pers) {
        personaServ.crearPersona(pers);
    }
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return personaServ.verPersonas();
    }
    
    @PutMapping ("/edit")
    public void editarPersona (@RequestBody Persona pers) {
        personaServ.editarPersona(pers);
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
        personaServ.borrarPersona(id);
    }

    
}