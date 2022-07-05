package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyectRepository;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyectRepository.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proy) {
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
    
}
