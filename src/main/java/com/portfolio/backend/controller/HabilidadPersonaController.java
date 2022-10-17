
package com.portfolio.backend.controller;

import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadPersona;
import com.portfolio.backend.service.HabilidadService;
import com.portfolio.backend.service.IHabilidadPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/habilidadPersona")
@CrossOrigin(origins ={"http://localhost:4200", "https://frontendap-c120f.web.app"})
public class HabilidadPersonaController {

    private final IHabilidadPersonaService habilPerServ;
//    
//    @Autowired    
//    PersonaService perServ;
//    
   @Autowired    
    HabilidadService habServ;
//
    public HabilidadPersonaController(IHabilidadPersonaService habilPerServ) {
        this.habilPerServ = habilPerServ;
    }

      
    @PreAuthorize("hasRole('ADMIN')")     
    @PostMapping("/new")
    public ResponseEntity<?> agregarHabilidadPersona (@RequestBody HabilidadPersona habP) {

        Habilidad habilidadGuardada;
                
        if(habServ.existsByHabilidadNombre(habP.getHabilidad().getNombre())){
            habilidadGuardada = habServ.buscarHabilidadNombre(habP.getHabilidad().getNombre());
        } else {
            try {
                habServ.crearHabilidad(habP.getHabilidad()); 
                habilidadGuardada = habServ.buscarHabilidadNombre(habP.getHabilidad().getNombre());
//               return ResponseEntity.created(new URI("/habilidad/"+habilidadGuardada.getId())).body(habilidadGuardada);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        
        HabilidadPersona habilidadPersona = new HabilidadPersona(habP.getPersona(),habilidadGuardada,habP.getPorcentaje());
        
        habilPerServ.crearHabilidadPersona(habilidadPersona); 
        return new ResponseEntity(new Mensaje("HabilidadPersona Creada"), HttpStatus.OK);
    }
        
    @GetMapping ("/ver-todas")
    @ResponseBody
    public List<HabilidadPersona> verHabilidadesPersona() {
        return habilPerServ.verHabilidadPersonas();
    }
    
                    
    @GetMapping ("/{id}")
    @ResponseBody
    public HabilidadPersona buscarHabilidadPersona(@PathVariable Long id) {
        return habilPerServ.buscarHabilidadPersona(id).get();
    }
    
    @GetMapping ("/persona/{idPersona}")
    @ResponseBody
    public List<HabilidadPersona> buscarHabilidadesPersona(@PathVariable Long idPersona) {
        return habilPerServ.buscarHabilidadesPersona(idPersona);
    }
    
    @GetMapping ("/noPersona/{idPersona}")
    @ResponseBody
    public List<Habilidad> buscarHabilidadesNoPersona(@PathVariable Long idPersona) {
        List<Habilidad> habil =  habServ.verHabilidades();
        List<HabilidadPersona> habilP =  habilPerServ.buscarHabilidadesPersona(idPersona);
         List<HabilidadPersona> filtradas;
         //filtradas = habil;
         habilP.forEach((habP) -> {
//            habil.forEach((hab) -> {
//            if(habP.getHabilidad().getNombre() == hab.getNombre()){
//                habil.remove(hab);
//                System.out.println(habil);
//            }
            habil.remove(habP.getHabilidad());
         //});
         });
         return habil;
    }
    
//    @GetMapping ("buscar/{nombre}")
//    @ResponseBody
//    public Habilidad buscarHabilidadNombre(@PathVariable String nombre) {
//        return habilidadServ.buscarHabilidadNombre(nombre);
//    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping ("/edit")
    public void editarHabilidad (@RequestBody HabilidadPersona habP) {
        habilPerServ.editarHabilidadPersona(habP);
    }
    
//    @GetMapping ("/persona/{id}")
//    @ResponseBody
//    public List<HabilidadPersona> buscarPorPersona(@PathVariable Long id) {
//        return habPerServ.buscarHabilidadesPersona(id);
//    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id) {
        habilPerServ.borrarHabilidadPersona(id);
    }
    }