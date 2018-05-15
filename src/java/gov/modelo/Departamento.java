package gov.modelo;

/**
 * Nombre : Usuario
 * Fecha : May 8, 2018   
 * Version : 1.0 
 * @author jose_
 */
public class Departamento {
    private int idDepartamento;
    private String nombre;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  

    public void setIdDepartamento(String cmbDepartamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
