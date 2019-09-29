/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
    static public boolean logIn(File documento,String usuario,String  clave){
        boolean band = false;        
        
        try{
            if(!documento.exists()){
                documento.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(documento));
            String conexion;
            String []separador;
            conexion = br.readLine();
            while (conexion != null) {
                separador = conexion.split(",");
                if (usuario.equals(separador[1])) {
                    if (clave.equals(separador[2])) {
                        band = true;
                    }
                }
                conexion = br.readLine();
            }
           br.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }       
        return band;
    }
    
   
    
     static public boolean logup(File documento,Usuario user){
         boolean band= false;
		try {
                    if(!documento.exists()){
                      documento.createNewFile();
                    }
                                      
			BufferedWriter bfwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(documento,true),"utf-8"));
		        //escribe los datos en el archivo
	        bfwriter.write(user.getId()+","+user.getUsuario()+"," + user.getClave() + "," + user.getNombres() + "," + user.getApellidos()
		+ "," + user.getEmail()+ "\r");
			//cierra el buffer intermedio
			System.out.println("Archivo creado satisfactoriamente..");
                        band = true;
                        bfwriter.close();
                    
		} catch (Exception e) {
			e.printStackTrace();
		}             
        
        return band;
    }
     static public boolean RecuperarClave(File documento,String usuario, String clave){
         boolean band=false;
         try{
             if(!documento.exists()){      
                documento.createNewFile();
             }
            BufferedReader br= new BufferedReader(new FileReader(documento));
            String conexion;
            ArrayList<String> Datos = new ArrayList<>();
            conexion = br.readLine();
            String[] atributos;
            while (conexion!= null) {
                atributos = conexion.split(",");
                if (usuario.equals(atributos[1])) {
                    atributos[2] = clave;
                    band = true;

                }
                Datos.add(atributos[0] + "," + atributos[1] + "," + atributos[2] + "," + atributos[3] + "," + atributos[4]);
                conexion= br.readLine();
            }
            FileWriter fw = new FileWriter(documento);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < Datos.size(); i++) {
                bw.write(Datos.get(i));
                bw.newLine();
            }

            bw.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         
         
         return band;
     }
}
