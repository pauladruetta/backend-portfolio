
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.service.IHabilidadService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class HabilidadController {

    private final IHabilidadService habilidadServ;

    public HabilidadController(IHabilidadService habilidadServ) {
        this.habilidadServ = habilidadServ;
    }
      
     
    @PostMapping("/new")
    public void agregarHabilidad (@RequestBody Habilidad hab) {
        habilidadServ.crearHabilidad(hab); 
    }
    
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<Habilidad> verHabilidades() {
        return habilidadServ.verHabilidades();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id) {
        habilidadServ.borrarHabilidad(id);
    }
    
}