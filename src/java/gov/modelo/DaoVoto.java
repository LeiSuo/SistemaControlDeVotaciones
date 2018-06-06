package gov.modelo;

import gov.conexion.Conexion;
import java.sql.PreparedStatement;

/**
 * Nombre de la clase: DaoVoto
 * Versión: 1.0
 * Fecha: 04-jun-2018
 * Autor: Ulises
 */
public class DaoVoto extends Conexion{
    public void votar(Voto vot) throws Exception{
        try {
            this.conectar();
            String sql="INSERT INTO `voto`(`dui`, `idTipoVoto`, `datoVoto`) VALUES (?,?,?)";
            PreparedStatement pre =this.getCon().prepareStatement(sql);
            pre.setInt(1,vot.getCiudadano().getDui());
            pre.setInt(2,vot.getTipoVoto().getIdTipoVoto());
            pre.setInt(3, vot.getDatoVoto());
            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    }
}
