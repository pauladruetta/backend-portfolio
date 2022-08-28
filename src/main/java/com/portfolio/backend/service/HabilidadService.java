
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
//import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{
  
    @Autowired
    public HabilidadRepository habilRepository;
    
    @Override
    public List<Habilidad> verHabilidades() {
        return habilRepository.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habilRepository.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habilRepository.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {       
        return habilRepository.findById(id).orElse(null);
    }

    @Override
    public void editarHabilidad(Habilidad hab) {
        habilRepository.save(hab);
    }

    @Override
    public boolean existsByHabilidadNombre(String nombre) {
        return habilRepository.existsByNombre(nombre);
        //return habilRepository.existsByNombre(nombre).orElse(null);
    }
    
    @Override
    public Habilidad buscarHabilidadNombre(String nombre) {
        return habilRepository.findByNombre(nombre).orElse(null);
        //return habilRepository.existsByNombre(nombre).orElse(null);
    }

}
