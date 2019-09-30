/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;

/**
 *
 * @author whiston
 */
public class ControllerLogin extends Controller {
     
    public ControllerLogin(){
    
    }
    
    public boolean logIn(String usuario, String clave){
        boolean band = false;
        
        band = ModeloUsuario.logIn(usuario, clave);
        
        return band;
    }
    
    
    public boolean logUp(String id, String usuario, String clave,String nombres,String apellidos,String email){
        
        boolean band = false;
        Usuario user = new Usuario(id,usuario,clave,nombres,apellidos,email);
        band = ModeloUsuario.logup(user);
        
        return band;
    }
    
    public boolean RecuperarClave(String usuario, String clave){
        boolean band=false;
        
        band = ModeloUsuario.Recuperarclave(usuario, clave);
        
        return band;
    }
}
