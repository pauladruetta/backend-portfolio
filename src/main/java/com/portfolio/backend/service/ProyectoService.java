package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.model.ProyectoNuevo;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyectRepository;
    
    @Autowired    
    HabilidadService habService;
    
    @Override
    public List<ProyectoNuevo> verProyectos() {
        List<ProyectoNuevo> proyectos = new ArrayList<ProyectoNuevo>(); 
        
        proyectRepository.findAll().forEach((proy) -> {
            Set<String> habilidades = new HashSet<String>(); 
            proy.getHabilidades().forEach((hab) -> {
              habilidades.add(hab.getNombre());
            });      
            ProyectoNuevo nuevoProy = new ProyectoNuevo(proy.getId(), proy.getTitulo(), proy.getDescripcion(), proy.getUrl(), proy.getFecha(), proy.getImagen(),
            proy.getPersona(), habilidades);
            proyectos.add(nuevoProy);
        });
        
        return proyectos;
    }
    
//    @Override
//    public void crearProyecto(Proyecto proy) {
//
//        //Habilidad habilidad = HabilidadService.buscarHabilidad(habilidad_id);
//        proyectRepository.save(proyecto);
//    }

    @Override
    public void crearProyecto(Proyecto proy) {

        //proy.getHabilidades().forEach(hab -> habilidades.add(hab));
            //habilidades.add(habService.buscarHabilidad().get());
       
        //Habilidad habilidad = HabilidadService.buscarHabilidad(habilidad_id);
        proyectRepository.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectRepository.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {       
        return proyectRepository.findById(id).orElse(null);
    }

    @Override
    public void editarProyecto(Proyecto proy) {
        proyectRepository.save(proy);
    }
    
    @Override
    public List<ProyectoNuevo> buscarPorPersona(Long id) {
        //return proyectRepository.findAllByPersonaId(id);
    //}
        List<ProyectoNuevo> proyectos = new ArrayList<ProyectoNuevo>(); 
        
        proyectRepository.findAllByPersonaId(id).forEach((proy) -> {
            Set<String> habilidades = new HashSet<String>(); 
            proy.getHabilidades().forEach((hab) -> {
              habilidades.add(hab.getNombre());
            });      
            ProyectoNuevo nuevoProy = new ProyectoNuevo(proy.getId(), proy.getTitulo(), proy.getDescripcion(), proy.getUrl(), proy.getFecha(), proy.getImagen(),
            proy.getPersona(), habilidades);
            proyectos.add(nuevoProy);
        });
        
        return proyectos;
    }
}
