package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase: DaoVotante
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoVotante extends Conexion{
    public List<Votante> mostrar() throws Exception{
        ResultSet res;
        List<Votante> lst = new ArrayList<>();
        String sql = "select vot.dui, ciu.nombres, ciu.apellidos, ciu.genero, mun.idMunicipio as idMun, mun.nombre as nomMun, dep.idDepartamento as idDep, dep.nombre as nomDep, vot.password, vot.estado from votante As vot INNER JOIN ciudadano As ciu ON vot.dui = ciu.dui INNER JOIN municipio as mun ON ciu.idMunicipio = mun.idMunicipio INNER JOIN departamento As dep ON mun.idDepartamento = dep.idDepartamento;";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareCall(sql);
            res = pst.executeQuery();
            while(res.next()){
                Ciudadano ciu = new Ciudadano();
                ciu.setDui(res.getString("dui"));
                ciu.setNombre(res.getString("nombres"));
                ciu.setApellidos(res.getString("apellidos"));
                ciu.setGenero(res.getString("genero"));
                Municipio mun = new Municipio();
                mun.setIdMunicipio(res.getInt("idMun"));
                mun.setNombre(res.getString("nomMun"));
                Departamento dep = new Departamento();
                dep.setIdDepartamento(res.getInt("idDep"));
                dep.setNombre(res.getString("nomDep"));
                Votante vot = new Votante(
                        ciu,
                        res.getString("password"),
                        res.getString("estado"),
                        dep,
                        mun
                );
                lst.add(vot);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertar(Votante vot) throws Exception{
        try {
            this.conectar();
            String sql = "insert into votante(dui, password, estado) values(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vot.getCiudadano().getDui());
            pre.setString(2, vot.getPassword());
            pre.setString(3, vot.getEstado());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificar(Votante vot) throws Exception{
        try {
            this.conectar();
            String sql = "UPDATE votante SET password = ?, estado =? where dui=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vot.getPassword());
            pre.setString(2, vot.getEstado());
            pre.setString(3, vot.getCiudadano().getDui());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminar(Votante vot) throws Exception{
        try {
            this.conectar();
            String sql = "DELETE FROM votante WHERE dui=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vot.getCiudadano().getDui());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public int validarRegistro(Votante vot) throws Exception{
        ResultSet res;
        int val = 0;
        String sql = "SELECT estado FROM votante where dui = ?";
        try {
            this.conectar();
            String var = null;
            PreparedStatement pst = this.getCon().prepareCall(sql);
            pst.setString(1, vot.getCiudadano().getDui());
            res = pst.executeQuery();
            while(res.next()){
                var = res.getString("estado");
            }
            if (var!=null){  //esta inscrito
                if(var.equals("Activo")){  //el ciudadano puede ejercer su voto
                    val=1;
                }else{
                    val=0; //El ciudadano no puede ejercer su voto ya que lo ha ejercido anteriormente
                }
            }else{
                val = 2; //significa que no esta inscrito
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return val;
    }
    
    public List<Votante> validarSesion(Votante vot) throws Exception{
        ResultSet res;
        List<Votante> lst = new ArrayList<>();
        String sql = "SELECT ciudadano.nombres, ciudadano.apellidos, votante.estado FROM ciudadano INNER JOIN votante ON ciudadano.dui = votante.dui WHERE votante.password=? AND votante.dui=?";
        try {
            this.conectar();
            String var = null;
            PreparedStatement pst = this.getCon().prepareCall(sql);
            pst.setString(1, vot.getPassword());
            pst.setString(2, vot.getCiudadano().getDui());
            res = pst.executeQuery();
            while(res.next()){
                Ciudadano ciu = new Ciudadano();
                ciu.setNombre(res.getString("nombres"));
                ciu.setApellidos(res.getString("apellidos"));
                Votante vo = new Votante();
                vo.setCiudadano(ciu);
                vo.setEstado(res.getString("estado"));
                lst.add(vo);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
}
