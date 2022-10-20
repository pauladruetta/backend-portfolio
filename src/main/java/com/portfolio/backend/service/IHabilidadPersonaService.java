
package com.portfolio.backend.service;

import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadPersona;
import java.util.List;
import java.util.Optional;


public interface IHabilidadPersonaService {
    public List<HabilidadPersona> verHabilidadPersonas ();
    public void crearHabilidadPersona (HabilidadPersona habPer);
    public void borrarHabilidadPersona (Long id);
    public Boolean existsById (Long id);
    public Optional<HabilidadPersona> buscarHabilidadPersona (Long id);
    public List<HabilidadPersona> buscarHabilidadesPersona (Long id);
    public List<Habilidad> buscarHabilidadesdePersona (Long id);
    public void editarHabilidadPersona(HabilidadPersona habPer);
}
