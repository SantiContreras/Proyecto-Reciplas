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
public class ClienteDao {

    Conexion cn = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    int r;

    public List Listar() {
        String sql = "select * from cliente ";
        List<Cliente> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setTel(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setNom(rs.getString(5));
                lista.add(cl);
            }
        } catch (SQLException e) {
        }

        return lista;

    }

    public int Agregar(Cliente cli) {
        String sql = "insert into cliente (dni,telefono,domicilio,nombre) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getTel());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int Eliminar(int id) {
        String sql = "Delete from cliente where id_cliente= " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public Cliente editar(int id) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where id_cliente="+id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setTel(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setNom(rs.getString(5));
            }

        } catch (SQLException e) {

        }
        return cli;
    }

    public int Actualizar(Cliente cli) {
          String sql=" update cliente Set dni=?,telefono=?,domicilio=?,nombre=?, where id_cliente=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getTel());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getNom());
            ps.setInt(5, cli.getId_cliente());
            ps.executeUpdate();
        } catch (SQLException e) {
        }

        return r;
    }

}
