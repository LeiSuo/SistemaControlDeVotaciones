package gov.modelo;

import java.io.InputStream;
import java.sql.Blob;
import javax.persistence.Column;

/**
 * Nombre: PartidoPolitico
 * Version: 1.0
 * Fecha: 08-may-2018
 * Copyright: Me
 * @author Gerson Baires
 */
public class PartidoPolitico 
{
    private int idPartido;
    private String nombre;
    private InputStream bandera; 
    private String base64Image;

    public PartidoPolitico() {
    }
    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getBandera() {
        return bandera;
    }

    public void setBandera(InputStream bandera) {
        this.bandera = bandera;
    }
    
    public String getBase64Image() {
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
