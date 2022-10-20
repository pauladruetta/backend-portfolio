
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadNueva;
import com.portfolio.backend.model.HabilidadPersona;
import com.portfolio.backend.repository.HabilidadPersonaRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadPersonaService implements IHabilidadPersonaService {
    
    @Autowired
    public HabilidadPersonaRepository habilperRepo;

    @Override
    public List<HabilidadPersona> verHabilidadPersonas() {
        return habilperRepo.findAll();
    }

    @Override
    public void crearHabilidadPersona(HabilidadPersona habPer) {
        habilperRepo.save(habPer);
    }

    @Override
    public void borrarHabilidadPersona(Long id) {
        habilperRepo.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarHabilidadPersona(HabilidadPersona habPer) {
        habilperRepo.save(habPer);
    }

    @Override
    public Optional<HabilidadPersona> buscarHabilidadPersona(Long id) {
        return habilperRepo.findById(id);
    }

    @Override
    public List<HabilidadPersona> buscarHabilidadesPersona(Long id) {
        
        List<HabilidadPersona> habilidadesPersona = new ArrayList<HabilidadPersona>(); 
        
        habilperRepo.findAllByPersonaId(id).forEach((habP) -> {
            habilidadesPersona.add(habP);
        });      
        return habilidadesPersona; 
    }
    
    @Override
    public List<Habilidad> buscarHabilidadesdePersona(Long id) {
        
        List<Habilidad> habilidadesPersona = new ArrayList<Habilidad>(); 
        
        habilperRepo.findAllByPersonaId(id).forEach((habP) -> {
            habilidadesPersona.add(habP.getHabilidad());
        });      
        return habilidadesPersona; 
    }
}
