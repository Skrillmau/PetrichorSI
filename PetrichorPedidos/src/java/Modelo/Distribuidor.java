/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JUan Camilo Posada
 */
public class Distribuidor {

    private int Iddistribuidor;
    private int Idusuario;
    private String Usuario;
    private String Password;
    private String Tipo;
    private String Nombre;
    private String Direccion;
    private String Ciudad;
    private String Pais;

    public Distribuidor() {

    }

    public int getIddistribuidor() {
        return Iddistribuidor;
    }

    public void setIddistribuidor(int Iddistribuidor) {
        this.Iddistribuidor = Iddistribuidor;
    }

    public int getIdusuario() {
        return Idusuario;
    }

    public void setIdusuario(int Idusuario) {
        this.Idusuario = Idusuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

}
