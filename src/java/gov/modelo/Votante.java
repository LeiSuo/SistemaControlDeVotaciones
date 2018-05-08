

package gov.modelo;

/**
 * Nombre: Votante
 * Version: 1.0
 * Fecha: 08-may-2018
 * Copyright: Me
 * @author Gerson Baires
 */
public class Votante 
{
    private Ciudadano ciudadano;
    private String clave;
    private String activo;

    public Votante() {
    }

    public Votante(Ciudadano ciudadano, String clave, String activo) {
        this.ciudadano = ciudadano;
        this.clave = clave;
        this.activo = activo;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

   

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
}
