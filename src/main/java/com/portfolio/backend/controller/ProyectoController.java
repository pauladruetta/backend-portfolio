
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.IProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class ProyectoController {
        
    private final IProyectoService proyectoServ;

    public ProyectoController(IProyectoService proyectoServ) {
        this.proyectoServ = proyectoServ;
    }        
   
    @PostMapping("/new")
    public void agregarProyecto(@RequestBody Proyecto proy) {
        proyectoServ.crearProyecto(proy);
    }
    
    @GetMapping ("/ver-todos")
    @ResponseBody
    public List<Proyecto> verProyectos() {
        return proyectoServ.verProyectos();
    }
    
    @PutMapping ("/edit")
    public void editarProyecto (@RequestBody Proyecto proy) {
        proyectoServ.editarProyecto(proy);
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarProyecto (@PathVariable Long id) {
        proyectoServ.borrarProyecto(id);
    }
}
