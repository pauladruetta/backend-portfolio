/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
   Optional<Usuario> findByNombreUsuario(String nombreUsuario);
   boolean existsByNombreUsuario (String nombreUsuario);
   boolean existsByEmail (String email);
   
}