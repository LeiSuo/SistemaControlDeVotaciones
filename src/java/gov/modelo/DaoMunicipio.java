package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoMunicipio
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoMunicipio extends Conexion {
    public List<Municipio> mostrarMunicipio() throws Exception{
        ResultSet rs;
        List<Municipio> lst = new ArrayList<>();
        String sql = "select municipio.idMunicipio, municipio.nombre as nombreMun,"
                + "departamento.idDepartamento, departamento.nombre as nombreDep "
                + "from municipio inner join departamento on "
                + "municipio.idDepartamento = departamento.idDepartamento; ";
        Municipio mu;
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Departamento de = new Departamento();
                de.setIdDepartamento(rs.getInt("idDepartamento"));
                de.setNombre(rs.getString("nombreDep"));
                mu = new Municipio(rs.getInt("idMunicipio"),
                                   rs.getString("nombreMun"),
                                   de);
                lst.add(mu);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertarMunicipio(Municipio mu) throws Exception{
        try {
            this.conectar();
            String sql = "insert into municipio(nombre, idDepartamento) values(?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, mu.getNombre());
            pst.setInt(2, mu.getDepartamento().getIdDepartamento());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarMunicipio(Municipio mu) throws Exception{
        try {
            this.conectar();
            String sql = "update municipio set nombre = ?, idDepartamento = ?"
                      + " where idMunicipio = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, mu.getNombre());
            pst.setInt(2, mu.getDepartamento().getIdDepartamento());
            pst.setInt(3, mu.getIdMunicipio());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminarMunicipio(Municipio mu) throws Exception{
        try {
            this.conectar();
            String sql = "delete from municipio where idMunicipio = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, mu.getIdMunicipio());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
}
