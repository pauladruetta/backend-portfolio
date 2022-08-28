package com.portfolio.backend.repository;

import com.portfolio.backend.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
   Optional<Habilidad> findByNombre(String nombre);
   boolean existsByNombre (String nombre);
}
