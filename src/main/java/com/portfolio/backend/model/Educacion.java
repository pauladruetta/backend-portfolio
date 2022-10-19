
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String institucion;
    private String pais;
    private long fecha_inicio;
    private long fecha_fin;
    private String imagen;
    
    @ManyToOne
    @JoinColumn(name="persona_id")
    private Persona persona;

    public Educacion() {
    }

    public Educacion(String titulo, String institucion, String pais, long fecha_inicio, long fecha_fin, String imagen, Persona persona) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.pais = pais;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.imagen = imagen;
        this.persona = persona;
    }
    
    
    
}
