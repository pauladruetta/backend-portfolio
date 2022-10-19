
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import com.portfolio.backend.repository.PersonaRepository;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService  implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Optional<Persona> buscarPersona(Long id) {
        Optional<Persona> persona = persoRepo.findById(id);
        System.out.println(persona);
        return persona;
    }
    
    @Override
    public Boolean existsById(Long id) {
        return persoRepo.existsById(id);
    }

    @Override
    public void editarPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public void agregarImagen(Blob img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
