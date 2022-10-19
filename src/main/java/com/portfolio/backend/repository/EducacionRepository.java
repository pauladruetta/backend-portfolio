package com.portfolio.backend.repository;
import java.util.List;
import com.portfolio.backend.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    List<Educacion> findAllByPersonaId(final Long educacion_id);
}
