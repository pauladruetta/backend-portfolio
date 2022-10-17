
package com.portfolio.backend.repository;

import com.portfolio.backend.model.HabilidadPersona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HabilidadPersonaRepository extends JpaRepository<HabilidadPersona, Long>{
       List<HabilidadPersona> findAllByPersonaId(final Long persona_id);
}
