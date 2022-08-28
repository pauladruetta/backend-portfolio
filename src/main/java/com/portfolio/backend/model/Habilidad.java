
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
    
    private String nombre;
    private long porcentaje;
    
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

    public Habilidad(String nombre, long porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}
