package com.portfolio.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String empresa;
    private String tipo;
    private String pais;
    private String provincia;
    private long fecha_inicio;
    private long fecha_fin;
    private String imagen;
            //(fetch = FetchType.LAZY)
    @ManyToOne
    //@JsonIgnore 
    @JoinColumn(name="persona_id")
    private Persona persona;
    //@JsonBackReference 
    
    public Experiencia() {
    }

    public Experiencia(Long id, String titulo, String empresa, String tipo, String pais, String provincia, long fecha_inicio, long fecha_fin, String imagen, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.tipo = tipo;
        this.pais = pais;
        this.provincia = provincia;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.imagen = imagen;
        this.persona = persona;
    }






    
    
    
}
