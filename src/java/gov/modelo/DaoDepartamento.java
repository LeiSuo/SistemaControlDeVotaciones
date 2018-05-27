package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoDepartamento
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoDepartamento extends Conexion{
    public List<Departamento> mostrarDepartamento() throws Exception{
        ResultSet rs;
        List<Departamento> lst = new ArrayList<>();
        String sql = "select * from departamento";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Departamento de = new Departamento();
                de.setIdDepartamento(rs.getInt("idDepartamento"));
                de.setNombre(rs.getString("nombre"));
                lst.add(de);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertarDepartamento(Departamento de) throws Exception{
        try {
            this.conectar();
            String sql = "insert into departamento(nombre) values(?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, de.getNombre());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarDepartamento(Departamento de) throws Exception{
        try {
            this.conectar();
            String sql = "update departamento set nombre = ? where idDepartamento = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, de.getNombre());
            pst.setInt(2, de.getIdDepartamento());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminarDepartamento(Departamento de) throws Exception{
        try {
            this.conectar();
            String sql = "delete from departamento where idDepartamento = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, de.getIdDepartamento());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
}
