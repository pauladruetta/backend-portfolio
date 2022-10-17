
package com.portfolio.backend.controller;

import antlr.StringUtils;
import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadNueva;
import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.model.ProyectoNuevo;
import com.portfolio.backend.service.HabilidadService;
import com.portfolio.backend.service.IProyectoService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
//@CrossOrigin(origins = "https://frontendap-c120f.web.app")
@CrossOrigin(origins ={"http://localhost:4200", "https://frontendap-c120f.web.app"})
public class ProyectoController {
        
    private final IProyectoService proyectoServ;
    
    @Autowired    
    HabilidadService habServ;
    
        
    public ProyectoController(IProyectoService proyectoServ) {
        this.proyectoServ = proyectoServ;
    }        

   // @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/new")
//    public void agregarProyecto(@RequestBody Proyecto proy) {
//        proyectoServ.crearProyecto(proy);
//    }
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping("/new")
//    public void agregarProyecto(@RequestBody ProyectoNuevo proyecto) {
      public ResponseEntity<?> agregarProyecto (@Valid @RequestBody ProyectoNuevo proyecto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        System.out.println("Proyecto: "  + proyecto.getTitulo());
        System.out.println(proyecto.getHabilidades());
        
        Set<Habilidad> habProy = new HashSet<>();
        
        //List<Habilidad> habilidadesGuardadas = habServ.verHabilidades();
        if (proyecto.getHabilidades().isEmpty()) {
            System.out.println("el proyecto no tiene habilidades");
        } else {
            proyecto.getHabilidades().forEach((habNombre)-> {
                System.out.println(habNombre);
                Habilidad habNueva;            
                Habilidad hab;

                if (habServ.existsByHabilidadNombre(habNombre)) {
                    System.out.println("Habilidad ya existe");                
                    hab = habServ.buscarHabilidadNombre(habNombre);
                    System.out.println(hab.getId());  
                } else {
                    habNueva = new Habilidad(habNombre);
                        hab = 
                            new Habilidad(habNueva.getNombre());
                        habServ.crearHabilidad(hab);
                        System.out.println("Habilidad Guardada");
                }

                habProy.add(hab);  
                //También habría que sumarla a la persona a la que pertenece el proyecto

            }  );   
            habProy.forEach((hab) -> {
                System.out.println(hab.getNombre());
            });
        }     

        
        Proyecto proy =
                new Proyecto(proyecto.getTitulo(), proyecto.getDescripcion(), proyecto.getUrl(), proyecto.getFecha(), proyecto.getImagen(), proyecto.getPersona(), habProy);

        //habProy.add(habServ.buscarHabilidadByName(proyecto.getHabilidades().name));  

        
        proyectoServ.crearProyecto(proy);
        return new ResponseEntity(new Mensaje("proyecto Guardado"), HttpStatus.CREATED);
    }
    
    @GetMapping ("/ver-todos")
    @ResponseBody
    public List<ProyectoNuevo> verProyectos() {
        return proyectoServ.verProyectos();
    }
    
    @GetMapping ("/{id}")
    @ResponseBody
//    public Proyecto buscarProyecto(@PathVariable Long id) {
//        return proyectoServ.buscarProyecto(id);
//    }
    public ProyectoNuevo buscarProyecto (@Valid @PathVariable Long id ) {
  
        System.out.println("Proyecto: "  + id);
            
        Proyecto proyecto = proyectoServ.buscarProyecto(id);
        
        Set<String> habProy = new HashSet<>();
        
        proyecto.getHabilidades().forEach((hab)-> {          
            habProy.add(hab.getNombre());                
        }  );   
    
        ProyectoNuevo proy =
            new ProyectoNuevo(proyecto.getId(),proyecto.getTitulo(), proyecto.getDescripcion(), proyecto.getUrl(), proyecto.getFecha(), proyecto.getImagen(),
                    proyecto.getPersona(), habProy);
        
        return proy;
    }

        
    @GetMapping ("/persona/{id}")
    @ResponseBody
    public List<ProyectoNuevo> buscarPorPersona(@PathVariable Long id) {
        return proyectoServ.buscarPorPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")    
    @PutMapping ("/edit")
//    public void editarProyecto (@RequestBody Proyecto proy) {
//        proyectoServ.editarProyecto(proy);
//    }
    public ResponseEntity<?> editarProyecto (@Valid @RequestBody ProyectoNuevo proyecto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        System.out.println("Proyecto: "  + proyecto.getTitulo());
        System.out.println(proyecto.getHabilidades());
        
        Set<Habilidad> habProy = new HashSet<>();
        
        proyecto.getHabilidades().forEach((habNombre)-> {
            System.out.println(habNombre);
            Habilidad habNueva;            
            Habilidad hab;
            
            if (habServ.existsByHabilidadNombre(habNombre)) {
                System.out.println("Habilidad ya existe");                
                hab = habServ.buscarHabilidadNombre(habNombre);
            } else {
                habNueva = new Habilidad(habNombre);
                    hab = 
                        new Habilidad(habNueva.getNombre());
                    habServ.crearHabilidad(hab);
                    System.out.println("Habilidad Guardada");
            }
            habProy.add(hab);                
        }  );   
        
        habProy.forEach((hab) -> {
            System.out.println(hab.getNombre());
        });
    
        Proyecto proy =
                new Proyecto(proyecto.getId(),proyecto.getTitulo(), proyecto.getDescripcion(), proyecto.getUrl(), proyecto.getFecha(),
                        proyecto.getImagen(), proyecto.getPersona(), habProy);
        
        proyectoServ.editarProyecto(proy);
        return new ResponseEntity(new Mensaje("proyecto Editado"), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/delete/{id}")
    public void borrarProyecto (@PathVariable Long id) {
        proyectoServ.borrarProyecto(id);
    }
}
