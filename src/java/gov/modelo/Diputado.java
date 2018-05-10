package gov.modelo;

import java.awt.Image;
import java.sql.Blob;

/**
 * Nombre de la clase: Diputado
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class Diputado {
    private int idDiputado;
    private Ciudadano ciu;
    private PartidoPolitico partidoPolitico;
    private Blob imagen;

    public Diputado() {
    }

    public Diputado(int idDiputado, Ciudadano ciu, PartidoPolitico partidoPolitico, Blob imagen) {
        this.idDiputado = idDiputado;
        this.ciu = ciu;
        this.partidoPolitico = partidoPolitico;
        this.imagen = imagen;
    }

    public int getIdDiputado() {
        return idDiputado;
    }

    public void setIdDiputado(int idDiputado) {
        this.idDiputado = idDiputado;
    }

    public Ciudadano getCiu() {
        return ciu;
    }

    public void setCiu(Ciudadano ciu) {
        this.ciu = ciu;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
         
}
