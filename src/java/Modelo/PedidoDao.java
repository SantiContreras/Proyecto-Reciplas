/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class PedidoDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarNumPedido() {
        String numPed = "";
        String sql = "select count(*) from pedido";
        String salida = null;
        int inc;
        String valor = null;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numPed = rs.getString(1);
            }
            inc = Integer.parseInt(numPed);
            inc = inc + 1;

            salida = String.format("%05d", inc);

        } catch (SQLException e) {
        }

        return salida;

    }

    public String IdPedido() {
        String sql = "Select max(Id_pedido) from pedido";
        String idpedido = "";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idpedido = rs.getString(1);
            }
        } catch (SQLException e) {
        }

        return idpedido;
    }

    public int guardarPedido(Pedido pe) {

        String sql = "insert into pedido(fecha,monto,id_empleado,id_cliente,numeroserie,estado,pago) values(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pe.getFecha());
            ps.setDouble(2, pe.getMonto());
            ps.setInt(3, pe.getIdempleado());
            ps.setInt(4, pe.getIdcliente());
            ps.setString(5, pe.getNumpedido());
            ps.setString(6, pe.getEstado());

            ps.setString(7, pe.getPago());
            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;

    }

    public int guardarDetalle(Pedido pe) {
        String sql = "insert into detallepedido(id_pedido,id_producto,cantidad,precio_pedido) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getIdpedido());
            ps.setInt(2, pe.getIdpro());
            ps.setInt(3, pe.getCantidad());
            ps.setDouble(4, pe.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;

    }

}
