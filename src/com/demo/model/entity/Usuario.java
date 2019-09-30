/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model.entity;

/**
 *
 * @author whiston
 */
public class Usuario {
     
    private String id;
    private String email;
    private String clave;
    private String apellidos;
    private String nombres;
    private String nusuario;

    public Usuario() {
    }

    public Usuario(String id, String usuario, String clave,String nombres,String apellidos,String email) {
        this.id = id;
        this.email = email;
        this.clave = clave;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.nusuario = usuario;
    }

    public Usuario(String usuario, String clave) {
        this.nusuario = usuario;
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUSUARIO() {
        return nusuario;
    }

    public void setUSUARIO(String usuario) {
        this.nusuario = usuario;
    }
    
      
}
