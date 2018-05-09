/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Nombre de la clase: Diputado
 * Version: 1.1
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception{
        try{
            Class.forName("");
            con = DriverManager.getConnection("");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void desconectar() throws Exception{
        try{
            if(con!=null) {
                if (con.isClosed()==false) {
                    con.close();
                }
            }
        }catch(Exception e){
            throw e;
        }
    }
}
