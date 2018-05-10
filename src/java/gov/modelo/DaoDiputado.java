package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoDiputado
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoDiputado extends Conexion {
    
    public List<Diputado> mostrarDiputado() throws Exception{
        ResultSet rs;
        List<Diputado> lst = new ArrayList<>();
        Diputado di;
        try {
            String sql = "select * from diputado";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();       
            while (rs.next()) {                
                PartidoPolitico pp = new PartidoPolitico();
                Ciudadano ciu = new Ciudadano();
                di = new Diputado(rs.getInt("idDiputado"),
                        ciu,
                        pp, 
                        rs.getBlob("img"));
                lst.add(di);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertarDiputado(Diputado di) throws Exception{
        try {
            this.conectar();
            String sql = "insert into diputado(dui,idPartido,img) values(?,?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, di.getCiu().getDui());
            pst.setInt(2, di.getPartidoPolitico().getIdPartido());
            pst.setBlob(3, di.getImagen());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarDiputado(Diputado di) throws Exception{
        try {
            this.conectar();
            String sql = "update diputado set dui = ?, idPartido = ?,"
                    + "img = ? where idDiputado = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, di.getCiu().getDui());
            pst.setInt(2, di.getPartidoPolitico().getIdPartido());
            pst.setBlob(3, di.getImagen());
            pst.setInt(4, di.getIdDiputado());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
        
    public void eliminarDiputado(Diputado di) throws Exception{
        try {
            this.conectar();
            String sql = "delete * from diputado where idDiputado = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, di.getIdDiputado());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }    
}
