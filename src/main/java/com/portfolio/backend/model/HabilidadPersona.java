
package com.portfolio.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "habilidades_persona")
@Getter @Setter
public class HabilidadPersona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="persona_id")
            //fetch = FetchType.LAZY)
    //@MapsId("personaId")
    private Persona persona;
 
    @ManyToOne
    @JoinColumn(name="habilidad_id")
        //(fetch = FetchType.LAZY)
    //@MapsId("habilidadId")
    private Habilidad habilidad;
 
    //@Column(name = "porcentaje")
    private long porcentaje;

    public HabilidadPersona() {
    }

    public HabilidadPersona(Persona persona, Habilidad habilidad, long porcentaje) {
        this.persona = persona;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
    
}
