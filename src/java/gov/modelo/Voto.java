

package gov.modelo;

/**
 * Nombre: Voto
 * Version: 1.0
 * Fecha: 08-may-2018
 * Copyright: Me
 * @author Gerson Baires
 */
public class Voto {
    private Ciudadano ciudadano;
    private TipoVoto  tipoVoto;
    private int idVoto;
    private int datoVoto;

    public Voto() {
    }
    
    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public int getDatoVoto() {
        return datoVoto;
    }

    public void setDatoVoto(int datoVoto) {
        this.datoVoto = datoVoto;
    }
    
    public int getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(int idVoto) {
        this.idVoto = idVoto;
    }
    
}
