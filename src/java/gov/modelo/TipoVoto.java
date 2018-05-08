package gov.modelo;

/**
 * Nombre: TipoVoto
 * Version: 1.0
 * Fecha: 08-may-2018
 * Copyright: Me
 * @author Gerson Baires
 */
public class TipoVoto
{
    private int idTipoVoto;
    private String nombre;

    public TipoVoto() {
    }

    public TipoVoto(int idTipoVoto, String nombre) {
        this.idTipoVoto = idTipoVoto;
        this.nombre = nombre;
    }

    public int getIdTipoVoto() {
        return idTipoVoto;
    }

    public void setIdTipoVoto(int idTipoVoto) {
        this.idTipoVoto = idTipoVoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
