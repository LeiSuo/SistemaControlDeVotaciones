package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoPartidoPolitico
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoPartidoPolitico extends Conexion{
    public List<PartidoPolitico> mostrarPartidoPolitico() throws Exception{
        ResultSet rs;
        List<PartidoPolitico> lst = new ArrayList<>();
        String sql = "select * from partidoPolitico";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                PartidoPolitico pp = new PartidoPolitico();
                pp.setIdPartido(rs.getInt("idPartido"));
                pp.setNombre(rs.getString("nombre"));
                lst.add(pp);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertarPartidoPolitico(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "insert into partidoPolitico(nombre) values(?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, pp.getNombre());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarPartidoPolitico(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "update partidoPolitico set nombre = ? where idPartido = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, pp.getNombre());
            pst.setInt(2, pp.getIdPartido());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminarPartidoPolitico(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "delete from partidoPolitico where partidoPolitico = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, pp.getIdPartido());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
}
