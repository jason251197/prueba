/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;
import java.io.File;

/**
 *
 * @author whiston
 */
public class ControllerLogin extends Controller {
   File Archivo = new File("D:\\trabajo.txt");
    public ControllerLogin(){
    
    }
    
    public boolean logIn(String usuario, String clave){
        boolean band = false;
        
        band = ModeloUsuario.logIn(Archivo,usuario, clave);
        
        return band;
    }
    
    
    public boolean logUp(String id,String usuario,  String clave, String nombres,String apellidos, String email){
        
        boolean band=false;
        
        Usuario user1 = new Usuario(id ,usuario, clave,nombres,apellidos,email);
        
        band = ModeloUsuario.logup(Archivo,user1);
        
        return band;
    }
    
    public boolean RecuperarClave(String usuario, String clave){
        boolean band=false;
        band = ModeloUsuario.RecuperarClave(Archivo,usuario,clave);
        return band;
    }
    
}
