
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.service.IExperienciaService;
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
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@CrossOrigin(origins = "https://frontendap-c120f.web.app")

public class ExperienciaController {
    
    private final IExperienciaService experienciaServ;

    public ExperienciaController(IExperienciaService experienciaServ) {
        this.experienciaServ = experienciaServ;
    }
      
    @PreAuthorize("hasRole('ADMIN')")     
    @PostMapping("/new")
    public void agregarExperiencia (@RequestBody Experiencia exp) {
        experienciaServ.crearExperiencia(exp); 
    }
        
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Experiencia> verExperiencias() {
        return experienciaServ.verExperiencias();
    }
                
    @GetMapping ("/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable Long id) {
        return experienciaServ.buscarExperiencia(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")    
    @PutMapping ("/edit")
    public void editarExperiencia (@RequestBody Experiencia exp) {
        experienciaServ.editarExperiencia(exp);
    }
    
    @PreAuthorize("hasRole('ADMIN')")   
    @DeleteMapping ("/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id) {
        experienciaServ.borrarExperiencia(id);
    }
    
    
    
}
