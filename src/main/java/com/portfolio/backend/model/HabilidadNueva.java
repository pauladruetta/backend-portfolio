
package com.portfolio.backend.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter @Setter
@AllArgsConstructor

public class HabilidadNueva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private long porcentaje;

    public HabilidadNueva(String nombre, long porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
}
