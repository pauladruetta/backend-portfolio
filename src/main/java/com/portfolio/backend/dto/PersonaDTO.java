
package com.portfolio.backend.dto;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.model.Habilidad;
import com.portfolio.backend.model.HabilidadNueva;
import com.portfolio.backend.model.Proyecto;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class PersonaDTO {
    
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

    private LocalDate fecha_nacimiento;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String imagen_perfil;
    private String imagen_portada;  
    private String descripcion;
    
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_habilidades",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "habilidad_id")}
//    )
    private Set<HabilidadNueva> habilidades;
   
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_proyectos",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "proyecto_id")}
//    )
    private Set<Proyecto> proyectos;
    
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_experiencias",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "experiencia_id")}
//    )
    private Set<Experiencia> experiencias; 
    
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_educaciones",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "educacion_id")}
//    )
    private Set<Educacion> educaciones;  

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, String titulo, LocalDate fecha_nacimiento, String imagen_perfil, String imagen_portada, String descripcion, Set<HabilidadNueva> habilidades, Set<Proyecto> proyectos, Set<Experiencia> experiencias, Set<Educacion> educaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
        this.proyectos = proyectos;
        this.experiencias = experiencias;
        this.educaciones = educaciones;
    }
    
       
}
