package gov.modelo;

import java.awt.Image;

/**
 * Nombre de la clase: Diputado
 * Version: 1.0
 * Fecha: 08-may-2018
 * Autor: Ulises Guzman
 */
public class Diputado {
    private int idDiputado;
    private int dui;
    private int idPartido;
    private Image imagen;

    public Diputado() {
    }

    public Diputado(int idDiputado, int dui, int idPartido, Image imagen) {
        this.idDiputado = idDiputado;
        this.dui = dui;
        this.idPartido = idPartido;
        this.imagen = imagen;
    }

    public int getIdDiputado() {
        return idDiputado;
    }

    public void setIdDiputado(int idDiputado) {
        this.idDiputado = idDiputado;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
