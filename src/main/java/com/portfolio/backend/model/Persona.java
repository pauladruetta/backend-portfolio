package com.portfolio.backend.model;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Persona(Long id, String nombre, String apellido, String titulo, LocalDate fecha_nacimiento, String imagen_perfil, String imagen_portada, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.imagen_perfil = imagen_perfil;
        this.imagen_portada = imagen_portada;
        this.descripcion = descripcion;
    }





    
    
}
