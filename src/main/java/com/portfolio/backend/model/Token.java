package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;   
    
    @NotNull
    private String accessToken ;
    
    @NotNull
    private String refreshToken ;

    @NotNull
    private String tokenType ;
    
    @NotNull
    private Long expiryDuration ;
    
                      
}
