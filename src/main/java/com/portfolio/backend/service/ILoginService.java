
package com.portfolio.backend.service;

import com.portfolio.backend.model.Login;


public interface ILoginService {

    public Object iniciarSesion (Login sesion);
    public void finalizarSesion (Login sesion);
    public void crearUsuario (Login sesion);
    public void editarUsuario (Login sesion);
    public void eliminarUsuario (Login sesion);
}
