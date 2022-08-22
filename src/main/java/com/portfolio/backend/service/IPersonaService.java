
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;
import java.sql.Blob;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    public void editarPersona(Persona pers);
    public void agregarImagen(Blob img);
    
}
