
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.service.IEducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@CrossOrigin(origins = "https://frontendap-c120f.web.app")

public class EducacionController {
  
    private final IEducacionService educacionServ;
    
    public EducacionController(IEducacionService educacionService) {
        this.educacionServ = educacionService;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void agregarEducacion (@RequestBody Educacion edu) {
        educacionServ.crearEducacion(edu); 
    }
    
    //@PreAuthorize("hasRole('ADMIN')")    
    @PutMapping ("/edit")
    public void editarEducacion (@RequestBody Educacion edu) {
        educacionServ.editarEducacion(edu);
    }
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educacionServ.verEducacion();
    }

    @GetMapping ("/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id) {
        return educacionServ.buscarEducacion(id);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/delete/{id}")
    public void borrarEducacion (@PathVariable Long id) {
        educacionServ.borrarEducacion(id);
    }

    
}
