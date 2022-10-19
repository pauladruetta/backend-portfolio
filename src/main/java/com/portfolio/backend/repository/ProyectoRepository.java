
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository  extends JpaRepository<Proyecto, Long>{
   List<Proyecto> findAllByPersonaId(final Long proyecto_id);
}
