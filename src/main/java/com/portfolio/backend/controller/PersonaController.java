
package com.portfolio.backend.controller;

import com.portfolio.backend.dto.InformacionPersonalDto;
import com.portfolio.backend.dto.Mensaje;
import com.portfolio.backend.dto.PersonaDTO;
import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadNueva;
import com.portfolio.backend.model.HabilidadPersona;
import com.portfolio.backend.model.HabilidadPersonaNueva;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.EducacionService;
import com.portfolio.backend.service.ExperienciaService;
import com.portfolio.backend.service.HabilidadPersonaService;
import com.portfolio.backend.service.HabilidadService;
import com.portfolio.backend.service.IPersonaService;
import com.portfolio.backend.service.ProyectoService;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/persona")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@CrossOrigin(origins ={"http://localhost:4200", "https://frontendap-c120f.web.app"})

public class PersonaController {

    
    private final IPersonaService personaServ;
    
    @Autowired   
    ExperienciaService exService;
    
    @Autowired   
    EducacionService edService;

    @Autowired   
    ProyectoService PrService;
    
    @Autowired   
    HabilidadService HabService;
    
    @Autowired   
    HabilidadPersonaService HabPerSer;
    
    public PersonaController(IPersonaService personaServ) {
        this.personaServ = personaServ;
    }    
    
   
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> agregarPersona (@RequestBody PersonaDTO persDTO) {
        if (StringUtils.isBlank(persDTO.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(persDTO.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if (persDTO.getFecha_nacimiento().isAfter(LocalDate.now()) || persDTO.getFecha_nacimiento().isEqual(LocalDate.now()) )
            return new ResponseEntity(new Mensaje("La fecha de nacimiento debe ser anterior a la fecha actual"), HttpStatus.BAD_REQUEST);
//        Persona persona = new Persona(persDTO.getNombre(),persDTO.getApellido(), persDTO.getTitulo(), persDTO.getFecha_nacimiento(), persDTO.getImagen_perfil(),persDTO.getImagen_portada(), 
//                 persDTO.getDescripcion(), persDTO.getProyectos(), persDTO.getExperiencias(), persDTO.getEducaciones());
        Persona persona = new Persona(persDTO.getNombre(),persDTO.getApellido(), persDTO.getTitulo(), persDTO.getFecha_nacimiento(), persDTO.getImagen_perfil(),persDTO.getImagen_portada(), 
                 persDTO.getDescripcion());
        personaServ.crearPersona(persona);
       
       
        Set<Experiencia> experiencias = new HashSet<>(persDTO.getExperiencias());
        //System.out.println(experiencias);
        experiencias.forEach(ex -> {
            ex.setPersona(persona);
            exService.crearExperiencia(ex);
        });
        
        Set<Educacion> educaciones = new HashSet<>(persDTO.getEducaciones());
        //System.out.println(educaciones);
        educaciones.forEach(ed -> {
            ed.setPersona(persona);
            edService.crearEducacion(ed);
        });
        
        Set<Proyecto> proyectos = new HashSet<>(persDTO.getProyectos());
        System.out.println(experiencias);
        proyectos.forEach(py -> {
            py.setPersona(persona);
            PrService.crearProyecto(py);
        });
        
//        Set<Habilidad> habilidades = new HashSet<>();
        //System.out.println(habilidades);
        
        if (persDTO.getHabilidades().isEmpty()) {
            System.out.println("La persona no tiene habilidades");
        } else {
            persDTO.getHabilidades().forEach((hab)-> {
                Habilidad habilidad;  
                Habilidad habNueva;
                HabilidadPersona habPer; 
                String habNombre = hab.getNombre();

                if (HabService.existsByHabilidadNombre(habNombre)) {
                    System.out.println("Habilidad ya existe");                
                    //habilidad = HabService.buscarHabilidadNombre(habNombre);
                    //habPer = new HabilidadPersonaNueva(persona,habilidad,hab.getPorcentaje());             
                } else {
                    //habNueva = new HabilidadNueva(habNombre,hab.getPorcentaje());
                    habNueva = new Habilidad(habNombre);
                        HabService.crearHabilidad(habNueva);                        
                        System.out.println("Habilidad Guardada");
                }   
                habilidad = HabService.buscarHabilidadNombre(habNombre);
                habPer = new HabilidadPersona(persona,habilidad,hab.getPorcentaje());
                HabPerSer.crearHabilidadPersona(habPer);
            });   
        }     
        
        return new ResponseEntity(new Mensaje("Persona Creada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/edit")
    public ResponseEntity<?> editarPersona (@RequestBody InformacionPersonalDto persDTO) {
        if (persDTO.getId() == null )
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.BAD_REQUEST);
        if (!personaServ.existsById(persDTO.getId()))
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(persDTO.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(persDTO.getApellido()))
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
//        if (persDTO.getFecha_nacimiento().isAfter(LocalDate.now()) || persDTO.getFecha_nacimiento().isEqual(LocalDate.now()) )
//            return new ResponseEntity(new Mensaje("La fecha de nacimiento debe ser anterior a la fecha actual"), HttpStatus.BAD_REQUEST);

        Persona persona = personaServ.buscarPersona(persDTO.getId()).get();
        persona.setNombre(persDTO.getNombre());
        persona.setApellido(persDTO.getApellido());
        persona.setTitulo(persDTO.getTitulo());     
        persona.setDescripcion(persDTO.getDescripcion());
        persona.setImagen_perfil(persDTO.getImagen_perfil());     
        persona.setImagen_portada(persDTO.getImagen_portada()); 
        //persona.setEducaciones(persDTO.getEducaciones());        
        //persona.setExperiencias(persDTO.getExperiencias());  
        //persona.setFecha_nacimiento(persDTO.getFecha_nacimiento()); 
        //persona.setHabilidades(persDTO.getHabilidades());  
        //persona.setProyectos(persDTO.getProyectos());     
        personaServ.editarPersona(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK); 
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/image-upload")
    public void agregarImagen (@RequestBody Blob img) {
        personaServ.agregarImagen(img);
    }
    
    @GetMapping ("/ver-todas")
    @ResponseBody
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> personas = personaServ.verPersonas();
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }
    
    @GetMapping ("/personal-info/{id}")
    @ResponseBody
    public ResponseEntity<InformacionPersonalDto> getInfoById(@PathVariable("id") Long id) {

        if(!personaServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaServ.buscarPersona(id).get();
        System.out.println(persona);
        InformacionPersonalDto informacion = new InformacionPersonalDto(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getTitulo(), persona.getImagen_perfil(), persona.getImagen_portada(), persona.getDescripcion());
        return new ResponseEntity(informacion, HttpStatus.OK);
    }
    
    @GetMapping ("/details/{id}")
    @ResponseBody
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {

        if(!personaServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Optional<Persona> persona = personaServ.buscarPersona(id);
        System.out.println(persona);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
   
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> borrarPersona (@PathVariable("id") Long id) {
        if (!personaServ.existsById(id))
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.BAD_REQUEST);
        personaServ.borrarPersona(id);
        return new ResponseEntity(new Mensaje("Persona Borrada"), HttpStatus.OK); 
    }

    
}