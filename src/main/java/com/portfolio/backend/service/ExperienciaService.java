
package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository ExpeRepo;

    @Override
    public List<Experiencia> verExperiencias() {
        return ExpeRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        ExpeRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        ExpeRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return ExpeRepo.findById(id).orElse(null);
    }

    @Override
    public void editarExperiencia(Experiencia exp) {
        ExpeRepo.save(exp);
    }

    @Override
    public List<Experiencia> buscarPorPersona(Long id) {
        return ExpeRepo.findAllByPersonaId(id);
    }
}

