
package com.portfolio.backend.model;

import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoNuevo {
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;
    private long fecha;
    private String imagen;

//    @ManyToOne
//    @JoinColumn(name="proyecto_id")
    private Persona persona;
        
    private Set<String> habilidades;

//    public ProyectoNuevo(String titulo, String descripcion, String url, long fecha, String imagen, Set<String> habilidades) {
//        this.titulo = titulo;
//        this.descripcion = descripcion;
//        this.url = url;
//        this.fecha = fecha;
//        this.imagen = imagen;
//        this.habilidades = habilidades;
//    }

    public ProyectoNuevo(Long id, String titulo, String descripcion, String url, long fecha, String imagen, Persona persona, Set<String> habilidades) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.fecha = fecha;
        this.imagen = imagen;
        this.persona = persona;
        this.habilidades = habilidades;
    }
    
    
}
