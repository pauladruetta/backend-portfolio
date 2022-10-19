
package com.portfolio.backend.model;

import javax.persistence.Column;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadPersonaNueva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personaId")
    private Persona persona;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("habilidadId")
    private Habilidad habilidad;
 
    @Column(name = "porcentaje")
    private long porcentaje;

    public HabilidadPersonaNueva() {
    }

    public HabilidadPersonaNueva(Persona persona, Habilidad habilidad, long porcentaje) {
        this.persona = persona;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
    
}
