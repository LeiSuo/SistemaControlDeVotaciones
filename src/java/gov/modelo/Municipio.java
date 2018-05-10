package gov.modelo;

/**
 * Nombre : Municipio
 * Fecha : May 8, 2018   
 * Version : 1.0 
 * @author jose_
 */
public class Municipio {
    private int idMunicipio;
    private String nombre;
    private Departamento departamento;

    public Municipio() {
    }

    public Municipio(int idMunicipio, String nombre, Departamento departamento) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
