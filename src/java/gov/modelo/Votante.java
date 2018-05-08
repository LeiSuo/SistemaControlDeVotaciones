/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private Ciudadano Ciudadano;
    private String clave;
    private String activo;

    public Votante() {
    }

    public Votante(Ciudadano Ciudadano, String clave, String activo) {
        this.Ciudadano = Ciudadano;
        this.clave = clave;
        this.activo = activo;
    }

    public Ciudadano getCiudadano() {
        return Ciudadano;
    }

    public void setCiudadano(Ciudadano Ciudadano) {
        this.Ciudadano = Ciudadano;
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
