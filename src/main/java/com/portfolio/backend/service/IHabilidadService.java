
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import java.util.List;


public interface IHabilidadService  {
    
    public List<Habilidad> verHabilidades ();
    public void crearHabilidad (Habilidad exp);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidadNombre (String nombre);
    public boolean existsByHabilidadNombre (String nombre);
    public Habilidad buscarHabilidad (Long id);
    public void editarHabilidad (Habilidad exp);
//    public List<Habilidad> buscarPorPersona(Long id);
}
