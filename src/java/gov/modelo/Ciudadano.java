package gov.modelo;

/**
 * Nombre : Ciudadano
 * Fecha : May 8, 2018   
 * Version : 1.0 
 * @author jose_
 */
public class Ciudadano {
    private String dui;
    private String nombre;
    private String apellidos;
    private Municipio municipio;
    private Departamento departamento;
    private String genero;
    private int edad;
    private String fechaExpiracion;

    public Ciudadano() {
    }

    public Ciudadano(String dui, String nombre, String apellidos, Municipio municipio, Departamento departamento, String genero, int edad, String fechaExpiracion) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.municipio = municipio;
        this.departamento = departamento;
        this.genero = genero;
        this.edad = edad;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
