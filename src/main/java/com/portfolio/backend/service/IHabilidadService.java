
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import java.util.List;


public interface IHabilidadService  {
    
    public List<Habilidad> verHabilidades ();
    public void crearHabilidad (Habilidad exp);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidad (Long id);
    public void editarHabilidad (Habilidad exp);

}
