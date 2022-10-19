
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{
    List<Experiencia> findAllByPersonaId(final Long experiencia_id);
}
