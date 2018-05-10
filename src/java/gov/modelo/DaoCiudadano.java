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
    public List<Ciudadano> mostrarCiudadano(){
        ResultSet rs;
        List<Ciudadano> lst = new ArrayList<>();
        String sql = "select * from ciudadano";
        try {
            this.conectar();
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Ciudadano ciu = new Ciudadano();
                ciu.setDui(sql);
            }
        } catch (Exception e) {
        }
        return lst;
    }
}
