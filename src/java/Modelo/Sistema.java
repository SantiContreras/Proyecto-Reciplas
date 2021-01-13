/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class Sistema {

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

    public Cliente Buscar(String dni) {

        Cliente cli = new Cliente();
        String sql = "select * from cliente where Dni=" + dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId_cliente(rs.getInt(1));
                cli.setDni(rs.getString(2));

                cli.setDir(rs.getString(3));
                cli.setTel(rs.getString(4));
                cli.setNom(rs.getString(5));
            }

        } catch (SQLException e) {
        }
        return cli;
    }

    public Producto buscar(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId_producto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }

        } catch (SQLException e) {
        }
        return pro;
    }

    public int actualizarstock(int id, int stock) {
        String sql = "update producto set stock=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return r;
    }
    
     public Empleado Validar( String user , String dni){
        Empleado em = new Empleado();
        String sql = "Select * from empleado where usuario=? and Dni=?";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1 ,user);
            ps.setString(2,dni);
            
            rs=ps.executeQuery();
            while(rs.next()){
                em.setDni(rs.getString("Dni"));
                em.setUser(rs.getString("usuario"));
               
               
                em.setId_empleado(rs.getInt("id_empleado"));
                em.setEs(rs.getString("Estado"));
                em.setEmail(rs.getString("correo"));
                em.setNom(rs.getString("nombre"));
            }
        
        }
        catch(SQLException e){
        }
        return em;
    }

}
