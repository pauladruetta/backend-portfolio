
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Login;
import com.portfolio.backend.service.ILoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class LoginController {

    private final ILoginService loginServ;

    public LoginController (ILoginService loginServ) {
        this.loginServ = loginServ;      
    }

    @PostMapping("/newUser")
    public void crearUsuario (@RequestBody Login user) {
        loginServ.crearUsuario(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public Object iniciarSesion (@RequestBody Login user) {
        return loginServ.iniciarSesion(user);
    }    

    @PostMapping("/logout")
    public void finalizarSesion (@RequestBody Login user) {
        loginServ.finalizarSesion(user);
    }   
    
    @DeleteMapping("/deleteUser")
    public void eliminarUsuario (@RequestBody Login user) {
        loginServ.eliminarUsuario(user);
    }   
}