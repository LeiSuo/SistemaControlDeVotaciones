

package gov.modelo;

/**
 * Nombre: Voto
 * Version: 1.0
 * Fecha: 08-may-2018
 * Copyright: Me
 * @author Gerson Baires
 */
public class Voto {
    private Ciudadano Ciudadano;
    private TipoVoto  TipoVoto;
    private int voto;

    public Voto() {
    }

    public Voto(Ciudadano Ciudadano, TipoVoto TipoVoto, int voto) {
        this.Ciudadano = Ciudadano;
        this.TipoVoto = TipoVoto;
        this.voto = voto;
    }

    public Ciudadano getCiudadano() {
        return Ciudadano;
    }

    public void setCiudadano(Ciudadano Ciudadano) {
        this.Ciudadano = Ciudadano;
    }

    public TipoVoto getTipoVoto() {
        return TipoVoto;
    }

    public void setTipoVoto(TipoVoto TipoVoto) {
        this.TipoVoto = TipoVoto;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
    
}
