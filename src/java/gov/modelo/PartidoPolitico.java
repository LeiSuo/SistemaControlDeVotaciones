package gov.modelo;

import java.io.InputStream;
import java.sql.Blob;

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
    InputStream archivoimg;
    private byte[] archivoimg2;

    public PartidoPolitico() {
    }

    public PartidoPolitico(int idPartido, String nombre, InputStream archivoimg, byte[] archivoimg2) {
        this.idPartido = idPartido;
        this.nombre = nombre;
        this.archivoimg = archivoimg; //para guardar en base de datos
        this.archivoimg2 = archivoimg2; //para mostrar
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

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }
    /**
     * @return the archivopdf2
     */
    public byte[] getArchivoimg2() {
        return archivoimg2;
    }
    /**
     * @param archivopdf2 the archivopdf2 to set
     */
    public void setArchivoimg2(byte[] archivoimg2) {
        this.archivoimg2 = archivoimg2;
    }

    
    
}
