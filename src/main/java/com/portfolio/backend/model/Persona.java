package com.portfolio.backend.model;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
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
//    private Set<Habilidad> habilidades;
//   
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_proyectos",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "proyecto_id")}
//    )
//    private Set<Proyecto> proyectos;
    
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_experiencias",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "experiencia_id")}
//    )
//    private Set<Experiencia> experiencias; 
//    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy ="persona", cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
//    private Set<Experiencia> experiencias;    
    //@JsonIgnore 
    //@JsonManagedReference

        
//    @ManyToMany(cascade = {
//        CascadeType.MERGE
//    })
//    @JoinTable(
//        name = "persona_educaciones",
//        joinColumns = {@JoinColumn(name = "persona_id")},
//        inverseJoinColumns = {@JoinColumn(name = "educacion_id")}
//    )
//    private Set<Educacion> educaciones;  
    
    public Persona() {
        
    }

//    public void setFecha_nacimiento(String fecha_nacimiento) {
//
//        try {
//            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//            this.fecha_nacimiento = formato.parse(fecha_nacimiento);
//        } catch (ParseException ex) {
//            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//

//
//    public Persona(String nombre, String apellido, String titulo, LocalDate fecha_nacimiento, String imagen_perfil, String imagen_portada, String descripcion) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.titulo = titulo;
//        this.fecha_nacimiento = fecha_nacimiento;
//        this.imagen_perfil = imagen_perfil;
//        this.imagen_portada = imagen_portada;
//        this.descripcion = descripcion;
//    }

    public Persona(String nombre, String apellido, String titulo, LocalDate fecha_nacimiento, String imagen_perfil, String imagen_portada, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
        this.descripcion = descripcion;
    }

   
}
