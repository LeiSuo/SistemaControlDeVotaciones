package gov.modelo;

import java.awt.Image;
import java.io.InputStream;
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
    private InputStream imagen;
    private String base64Image;
    
    public Diputado() {
    }

    public Diputado(int idDiputado, Ciudadano ciu, PartidoPolitico partidoPolitico, InputStream imagen, String base64Image) {
        this.idDiputado = idDiputado;
        this.ciu = ciu;
        this.partidoPolitico = partidoPolitico;
        this.imagen = imagen;
        this.base64Image = base64Image;
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

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
