
package com.portfolio.backend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HabilidadPersonaId implements Serializable {
    
    @Column(name = "persona_id")
    private Long personaId;
 
    @Column(name = "habilidad_id")
    private Long habilidaId;

    public HabilidadPersonaId() {
    }

    public HabilidadPersonaId(Long personaId, Long habilidaId) {
        this.personaId = personaId;
        this.habilidaId = habilidaId;
    }
    
    
}
