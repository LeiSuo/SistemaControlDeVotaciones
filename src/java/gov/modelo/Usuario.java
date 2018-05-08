/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.modelo;

/**
 * Nombre : Usuario
 * Fecha : May 8, 2018   
 * Version : 1.0 
 * @author jose_
 */
public class Usuario {
    private int idUsuario;
    private String password;
    private String nombre;
    private String usuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String password, String nombre, String usuario) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }       
}
