package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoTipoVoto
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoTipoVoto extends Conexion{
    
    public List<TipoVoto> mostrarTipo() throws Exception{
        List<TipoVoto> lst = new ArrayList();
        ResultSet rs;
        String sql = "select * from tipoVoto";
        
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                TipoVoto tv = new TipoVoto();
                tv.setIdTipoVoto(rs.getInt("idTipoVoto"));
                tv.setNombre(rs.getString("nombre"));
                lst.add(tv);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertarTipoVoto(TipoVoto tv) throws Exception{
        try {
            this.conectar();
            String sql = "insert into tipoVoto(nombre) values(?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, tv.getNombre());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarTipoVoto(TipoVoto tv) throws Exception{
        try {
            this.conectar();
            String sql = "update tipoVoto set nombre = ? where idTipoVoto = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, tv.getNombre());
            pst.setInt(2, tv.getIdTipoVoto());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminarTipoVoto(TipoVoto tv) throws Exception{
        try {
            this.conectar();
            String sql = "delete from tipoVoto where idTipoVoto = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, tv.getIdTipoVoto());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }    
    
}
