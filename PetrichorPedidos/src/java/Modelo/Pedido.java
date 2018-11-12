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
public class Pedido {

    private int Idpedido;
    private String Nombree;
    private int Idproducto;
    private int Iddistribuidor;
    private int Cantidad;
    private double Costo;
    private String Estado;
    private String Fecha;

    public Pedido() {
    }

    public int getIdpedido() {
        return Idpedido;
    }

    public void setIdpedido(int Idpedido) {
        this.Idpedido = Idpedido;
    }

    public String getNombree() {
        return Nombree;
    }

    public void setNombree(String Nombree) {
        this.Nombree = Nombree;
    }

    public int getIdproducto() {
        return Idproducto;
    }

    public void setIdproducto(int Idproducto) {
        this.Idproducto = Idproducto;
    }

    public int getIddistribuidor() {
        return Iddistribuidor;
    }

    public void setIddistribuidor(int Iddistribuidor) {
        this.Iddistribuidor = Iddistribuidor;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

}
