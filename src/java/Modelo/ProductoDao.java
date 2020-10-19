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
public class ProductoDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where id_producto="+id;
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

        } catch (Exception e) {
        }
        return r;
    }

}
