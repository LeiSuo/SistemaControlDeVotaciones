package gov.modelo;

import gov.conexion.Conexion;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
/**
 * Nombre de la clase: DaoDiputado
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoDiputado extends Conexion {
    
    public List<Diputado> mostrar() throws Exception{
        ResultSet rs;
        List<Diputado> lst = new ArrayList<>();
        try {
            this.conectar();
            String sql = "select diputado.idDiputado, diputado.dui, diputado.img ,ciudadano.nombres as nomDip, ciudadano.apellidos apeDip, diputado.idPartido, partidopolitico.nombre as partido from diputado INNER JOIN ciudadano on diputado.dui = ciudadano.dui INNER JOIN partidopolitico on diputado.idPartido = partidopolitico.idPartido ORDER BY diputado.idDiputado;";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();       
            while (rs.next()) {                
                PartidoPolitico pp = new PartidoPolitico();
                Ciudadano ciu = new Ciudadano();
                Diputado dip = new Diputado();
                dip.setIdDiputado(rs.getInt("idDiputado"));
                ciu.setDui(rs.getString("dui"));
                ciu.setNombre(rs.getString("nomDip"));
                ciu.setApellidos(rs.getString("apeDip"));
                pp.setIdPartido(rs.getInt("idPartido"));
                pp.setNombre(rs.getString("partido"));
                dip.setCiu(ciu);
                dip.setPartidoPolitico(pp);
                Blob blob = rs.getBlob("img"); //recuperamos los datos binarios de la base de datos
                if(blob !=null){
                    //Conversion de binario a cadena base64
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    //Fin de conversion

                    dip.setBase64Image(base64Image); //Guardamos la conversion en nuestro objeto
                    inputStream.close();
                    outputStream.close();
                }
                lst.add(dip);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertar(Diputado di) throws Exception{
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
    
    public void modificar(Diputado di) throws Exception{
        try {
            this.conectar();
            String sql = "update diputado set dui = ?, idPartido = ?,"
                    + " where idDiputado = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, di.getCiu().getDui());
            pst.setInt(2, di.getPartidoPolitico().getIdPartido());
            pst.setInt(3, di.getIdDiputado());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificar2(Diputado di) throws Exception{
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
        
    public void eliminar(Diputado di) throws Exception{
        try {
            this.conectar();
            String sql = "delete from diputado where idDiputado = ?";
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
