
package com.portfolio.backend.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String descripcion;
    private String url;
    private long fecha;
    private String imagen;
    
//    @ManyToOne  //(fetch = FetchType.LAZY), optional = false
//    @JoinColumn(name = "habilidad_id")//, nullable = false
//    private Habilidad habilidad;
//    
//    @OneToMany()
//    private Set<Habilidad> habilidades;
    
//    @OneToMany(mappedBy = "proyecto")
//    private Set<Habilidad> habilidades;
    
    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(
        name = "proyecto_habilidad",
        joinColumns = {@JoinColumn(name = "proyecto_id")},
        inverseJoinColumns = {@JoinColumn(name = "habilidad_id")}
    )
    private Set<Habilidad> habilidades;
}
