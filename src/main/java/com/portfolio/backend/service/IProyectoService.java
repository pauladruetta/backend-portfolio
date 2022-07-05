
package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> verProyectos ();
    public void crearProyecto (Proyecto proy);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public void editarProyecto(Proyecto proy);
    
}
