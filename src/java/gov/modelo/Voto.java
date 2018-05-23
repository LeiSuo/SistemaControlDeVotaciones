

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
    private int voto;

    public Voto() {
    }

    public Voto(Ciudadano ciudadano, TipoVoto tipoVoto, int idVoto, int voto) {
        this.ciudadano = ciudadano;
        this.tipoVoto = tipoVoto;
        this.idVoto = idVoto;
        this.voto = voto;
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
    
    

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
    public int getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(int idVoto) {
        this.idVoto = idVoto;
    }
    
}
