
package com.portfolio.backend.model;

//import java.util.Set;
//import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "habilidades")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String nombre;
    //private long porcentaje;
    
//    @ManyToOne
//    @JoinColumn(name="persona_id")
//    private Persona persona;
   //@OneToMany (mappedBy = "habilidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private Set<Proyecto> proyectos;
    
//    @OneToOne() 
//    private Proyecto proyecto;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Proyecto proyecto;
    
//    @ManyToOne()
//    @JoinColumn(name = "proyecto_id")//, nullable = false
//    private Proyecto proyecto;
    
//    @ManyToMany(mappedBy = "habilidades")
//    private Set<Proyecto> proyectos;

    public Habilidad(String nombre) {
        this.nombre = nombre;
        //this.porcentaje = porcentaje;
    }
}
