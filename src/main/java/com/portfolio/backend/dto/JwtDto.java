
package com.portfolio.backend.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter @Setter
public class JwtDto {

    private String token;
    
    private String bearer = "Bearer";

    private String nombreUsuario;

    private Collection<? extends GrantedAuthority> autthorities;

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> autthorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.autthorities = autthorities;
    }



}
