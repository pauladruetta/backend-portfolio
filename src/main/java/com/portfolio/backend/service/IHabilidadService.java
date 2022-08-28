
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import java.util.List;
import java.util.Optional;


public interface IHabilidadService  {
    
    public List<Habilidad> verHabilidades ();
    public void crearHabilidad (Habilidad exp);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidadNombre (String nombre);
    public boolean existsByHabilidadNombre (String nombre);
    public Habilidad buscarHabilidad (Long id);
    public void editarHabilidad (Habilidad exp);

}
