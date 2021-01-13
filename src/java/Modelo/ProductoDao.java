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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class ProductoDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));

                lista.add(pro);
            }
        } catch (SQLException e) {
        }
        return lista;

    }

    public int agregar(Producto pro) {
        String sql = "insert into producto(nombre,precio,stock,estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());

            ps.executeUpdate();
        } catch (SQLException e) {

        }
        return r;
    }

    public void eliminar(int id) {

        String sql = "delete from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Producto listarId(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                

            }
        } catch (SQLException e) {
        }
        return pro;
    }

    public int Actualizar(Producto pro) {
        String sql = "update producto set nombre=? ,precio=? , stock=?, estado=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, pro.getNombre());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());

            ps.setInt(5, pro.getId_producto());
            ps.executeUpdate();

        } catch (SQLException e) {
        }

        return r;
    }

}
