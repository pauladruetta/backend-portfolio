

package com.portfolio.backend.security;

import com.portfolio.backend.jwt.JwtEntryPoint;
import com.portfolio.backend.jwt.JwtTokenFilter;
import com.portfolio.backend.service.UserDetailsServiceImpl;
import java.util.Arrays;
import java.util.List;
import static lombok.AccessLevel.PUBLIC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
        
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//        http.cors().configurationSource(request -> {
//            CorsConfiguration cors = new CorsConfiguration();
//            cors.setAllowedOrigins(Arrays.asList("*"));
//            cors.setAllowedMethods(Arrays.asList("*"));
//            cors.setAllowedHeaders(Arrays.asList("*"));
//            return cors;
//        });
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/persona/ver-todas").permitAll() 
//                .antMatchers(HttpMethod.GET,"/educacion/ver-todas").permitAll() 
//                .antMatchers(HttpMethod.GET,"/experiencia/ver-todas").permitAll() 
//                .antMatchers(HttpMethod.GET,"/proyecto/ver-todos").permitAll() 
//                .antMatchers(HttpMethod.GET,"/habilidad/ver-todas").permitAll() 
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);        
////        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
        
        
        http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/auth/*").permitAll()        
                .antMatchers(HttpMethod.GET,"/persona/ver-todas").permitAll() 
                .antMatchers(HttpMethod.GET,"/educacion/ver-todas").permitAll() 
                .antMatchers(HttpMethod.GET,"/experiencia/ver-todas").permitAll() 
                .antMatchers(HttpMethod.GET,"/proyecto/ver-todos").permitAll() 
                .antMatchers(HttpMethod.GET,"/habilidad/ver-todas").permitAll() 
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);        
//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//                        
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); //To change body of generated methods, choose Tools | Templates.
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
