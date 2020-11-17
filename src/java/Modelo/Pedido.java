/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author santi
 */
public class Pedido {
    
    int idpedido ;
    int item;
    int idcliente;
    int idpro;
    int idempleado;
    String Numpedido;
    String descripcion;
    String fecha;
    Double precio;
    int cantidad;
    Double monto;
    Double subtotal;
    String estado;
    String pago;

   


    public Pedido() {
    }

    public Pedido(int idpedido, int item, int idcliente, int idpro, int idempleado, String Numpedido, String descripcion, String fecha, Double precio, int cantidad, Double monto, Double subtotal, String estado, String pago) {
        this.idpedido = idpedido;
        this.item = item;
        this.idcliente = idcliente;
        this.idpro = idpro;
        this.idempleado = idempleado;
        this.Numpedido = Numpedido;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.monto = monto;
        this.subtotal = subtotal;
        this.estado = estado;
        this.pago = pago;
    }
    
    

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNumpedido() {
        return Numpedido;
    }

    public void setNumpedido(String Numpedido) {
        this.Numpedido = Numpedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
}
