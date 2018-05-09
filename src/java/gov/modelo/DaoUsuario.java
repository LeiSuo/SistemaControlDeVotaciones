package gov.modelo;

import gov.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Nombre de la clase: DaoUsuario
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoUsuario extends Conexion{
    String sql="";
    PreparedStatement pre;
    ResultSet res;
    public int validar(Usuario us) throws Exception{
        int nivel=0;
        try {
            this.conectar();
            sql="select nivel from usuario where usuario=? and password=?";
            pre=this.getCon().prepareCall(sql);
            pre.setString(1, us.getUsuario());
            pre.setString(2, us.getPassword());
            res=pre.executeQuery();
            while (res.next()) {
                nivel=res.getInt(1);
            }
            res.close();
        } catch (Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return nivel;
    }
}
