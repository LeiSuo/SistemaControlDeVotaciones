package gov.modelo;

import gov.conexion.Conexion;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Nombre de la clase: DaoPartidoPolitico
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class DaoPartidoPolitico extends Conexion{
    public List<PartidoPolitico> mostrar() throws Exception{
        ResultSet rs;
        List<PartidoPolitico> lst = new ArrayList<>();
        String sql = "select * from partidopolitico";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                PartidoPolitico pp = new PartidoPolitico();
                pp.setIdPartido(rs.getInt("idPartido"));
                pp.setNombre(rs.getString("nombre"));
                
                Blob blob = rs.getBlob("bandera"); //recuperamos los datos binarios de la base de datos
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

                    pp.setBase64Image(base64Image); //Guardamos la conversion en nuestro objeto
                    inputStream.close();
                    outputStream.close();
                }
                lst.add(pp);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return lst;
    }
    
    public void insertar(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "insert into partidopolitico(nombre, bandera) values(?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, pp.getNombre());
            pst.setBlob(2, pp.getBandera());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void modificar1(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "";
            sql = "UPDATE partidopolitico SET nombre = ?  where idPartido = ?";
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
    
    public void modificar2(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "";
            sql = "update partidopolitico set nombre = ?, bandera= ?  where idPartido = ?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setString(1, pp.getNombre());
            pst.setBlob(2, pp.getBandera());
            pst.setInt(3, pp.getIdPartido());
            pst.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
    
    public void eliminar(PartidoPolitico pp) throws Exception{
        try {
            this.conectar();
            String sql = "delete from partidopolitico where idPartido = ?";
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
