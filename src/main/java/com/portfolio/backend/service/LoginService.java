
package com.portfolio.backend.service;

import com.portfolio.backend.model.Login;
import com.portfolio.backend.model.Token;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService{

    Login loginCorrecto = new Login(Long.valueOf(1), "admin","1234Paula");    
    Token TokenUsuario = new Token(Long.valueOf(1), "asdlfkjalskdfjasdf", "ajdflasdf", "token", Long.valueOf(90000));

    @Override
    public Object iniciarSesion(Login user) {
        if (user.getUsuario().equals(loginCorrecto.getUsuario()) && user.getPassword().equals(loginCorrecto.getPassword())) {   
            return TokenUsuario;
        } else {
//            System.out.println("hola");
            throw new UnsupportedOperationException("It is not correct. User: " + user.getUsuario() +" Password: " + user.getPassword()); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Override
    public void finalizarSesion(Login sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUsuario(Login sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarUsuario(Login sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarUsuario(Login sesion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
