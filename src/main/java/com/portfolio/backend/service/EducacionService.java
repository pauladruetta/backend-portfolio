
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public EducacionRepository EduRepo;

    @Override
    public List<Educacion> verEducacion() {
        return EduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        EduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        EduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return EduRepo.findById(id).orElse(null);
    }

    @Override
    public void editarEducacion(Educacion edu) {
        EduRepo.save(edu);
    }
}
