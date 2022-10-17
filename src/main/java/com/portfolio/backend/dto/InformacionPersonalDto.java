package com.portfolio.backend.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InformacionPersonalDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    
    private String titulo;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String imagen_perfil;
    private String imagen_portada;
    
    private String descripcion;

    public InformacionPersonalDto(Long id, String nombre, String apellido, String titulo, String imagen_perfil, String imagen_portada, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
        this.descripcion = descripcion;
    }
    
    
}
