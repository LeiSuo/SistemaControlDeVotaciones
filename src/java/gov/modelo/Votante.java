

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
    private String password;
    private String estado;
    private Departamento departamento;
    private Municipio municipio;
    public Votante() {
    }

    public Votante(Ciudadano ciudadano, String password, String estado, Departamento departamento, Municipio municipio) {
        this.ciudadano = ciudadano;
        this.password = password;
        this.estado = estado;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
