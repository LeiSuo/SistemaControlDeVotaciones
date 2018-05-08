package gov.modelo;

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

    public PartidoPolitico() {
    }

    public PartidoPolitico(int idPartido, String nombre) {
        this.idPartido = idPartido;
        this.nombre = nombre;
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
    

}
