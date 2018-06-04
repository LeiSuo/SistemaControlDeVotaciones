package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoCiudadano
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoCiudadano extends Conexion{
    public List<Ciudadano> mostrarCiudadano() throws Exception{
        ResultSet rs;
        List<Ciudadano> lst = new ArrayList<>();
        String sql ="SELECT ciudadano.dui, ciudadano.nombres , ciudadano.apellidos, "
                + "ciudadano.genero, ciudadano.edad, departamento.nombre as nomDep "
                + ",municipio.idMunicipio as idMun ,municipio.nombre as nomMun FROM "
                + "ciudadano inner join municipio on ciudadano.idMunicipio = municipio.idMunicipio "
                + "inner join departamento on municipio.idDepartamento = departamento.idDepartamento ";
        Ciudadano ciu;
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Municipio mu = new Municipio();
                mu.setIdMunicipio(rs.getInt("idMun"));
                mu.setNombre(rs.getString("nomMun"));
                Departamento dep = new Departamento();
                dep.setNombre(rs.getString("nomDep"));
                ciu = new Ciudadano(rs.getInt("dui"), 
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        mu, dep,
                        rs.getString("genero"),
                        rs.getInt("edad"));
                lst.add(ciu);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
    
        public void insertarCiudadano(Ciudadano ciu) throws Exception{
        try {
            this.conectar();
            String sql = "insert into ciudadano values(?,?,?,?,?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, ciu.getDui());
            pst.setString(2, ciu.getNombre());
            pst.setString(3, ciu.getApellidos());
            pst.setInt(4, ciu.getMunicipio().getIdMunicipio());
            pst.setString(5, ciu.getGenero());
            pst.setInt(6, ciu.getEdad());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificarCiudadano(Ciudadano ciu) throws Exception{
        try {
            this.conectar();
            String sql = "update ciudadano set nombres = ?,"
                    + "apellidos = ?, idMunicipio = ?, genero = ?,"
                    + "edad = ? where dui = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);            
            pst.setString(1, ciu.getNombre());
            pst.setString(2, ciu.getApellidos());
            pst.setInt(3, ciu.getMunicipio().getIdMunicipio());
            pst.setString(4, ciu.getGenero());
            pst.setInt(5, ciu.getEdad());
            pst.setInt(6, ciu.getDui());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminarCiudadano(Ciudadano ciu) throws Exception{
        try {
            this.conectar();
            String sql = "delete from ciudadano where dui = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, ciu.getDui());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
}
