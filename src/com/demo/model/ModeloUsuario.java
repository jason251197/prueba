/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
   public static final String url= "jdbc:mysql://localhost:3306/bd_conexion" +"?userTimezone=true&serverTimezone=UTC" ;
    public static final String usuario="root";
    public static final String Password = "76075651";
    Connection con;
    public ModeloUsuario(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,Password);
            System.out.println("Conexion Exitosa");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    static public boolean logIn(String usuario, String clave){
        boolean band = false;
        ModeloUsuario cb1 = new ModeloUsuario();
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = cb1.con.prepareStatement("select * from registro where usuarioN = ?;");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("clave").equals(clave)){
                    band = true;
                }
            }
            cb1.con.close();
        }catch(Exception e){
            System.err.println("Error de Sesion: "+e);
        }
        return band;
    }
       
     static public boolean logup(Usuario user){
        boolean band= false;
        ModeloUsuario cb = new ModeloUsuario(); 
        try{
            PreparedStatement st;
            String insertar ="INSERT INTO registro(  id_registro, usuarioN,clave, nombre, apellido, email) VALUES (?,?,?,?,?,?)";
            st= cb.con.prepareStatement(insertar);
            
            st.setString(3,user.getClave());
            st.setString(4,user.getNombres());
            st.setString(6,user.getEmail());
            st.setString(5,user.getApellidos());
            st.setString(1,user.getId());
            st.setString(2,user.getUSUARIO());
            st.executeUpdate();
            band=true;
            
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        
        return band;
    }
     
     
     static public boolean Recuperarclave(String usuario, String clave){
         boolean band = false;
         ModeloUsuario cb2 = new ModeloUsuario();
         PreparedStatement ps;
         String sSQL = "UPDATE registro set clave =? WHERE usuarioN =?";
         try{
           ps = cb2.con.prepareStatement(sSQL);
           ps.setString(1, clave);
           ps.setString(2, usuario);
           band = true ;
           ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
         
         return band;
     }
}
