package gov.modelo;

import gov.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * Nombre de la clase: DaoUsuario
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoUsuario extends Conexion{
    public int validar(Usuario us) throws Exception{
        String sql="";
        PreparedStatement pre;
        ResultSet res;
        int nivel=0;
        try {
            this.conectar();
            sql="select nivel from usuario where usuario=? and password=?";
            pre=this.getCon().prepareStatement(sql);
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
    
    public List<Usuario> mostrar() throws Exception{
        ResultSet rs;
        List<Usuario> lst = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Usuario us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setNombre(rs.getString("nombre"));
                us.setUsuario(rs.getString("usuario"));
                us.setPassword(rs.getString("password"));
                us.setNivel(Integer.parseInt(rs.getString("nivel")));
                lst.add(us);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void  insertar(Usuario us) throws Exception{
        try {
            this.conectar();
            String sql = "INSERT INTO usuario(nombre, usuario, password, nivel) values( ? , ? , ? , ? )";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, us.getNombre());
            pst.setString(2, us.getUsuario());
            pst.setString(3, us.getPassword());
            pst.setInt(4, us.getNivel());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificar(Usuario us) throws Exception{
        try {
            this.conectar();
            String sql = "UPDATE usuario SET nombre=? ,usuario=? ,password=? ,nivel=? WHERE idusuario=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, us.getNombre());
            pst.setString(2, us.getUsuario());
            pst.setString(3, us.getPassword());
            pst.setInt(4, us.getNivel());
            pst.setInt(5, us.getIdUsuario());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminar(Usuario us) throws Exception{
        try {
            this.conectar();
            String sql = "delete from usuario where idUsuario = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, us.getIdUsuario());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }  
}
