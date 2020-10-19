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
public class ClienteDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente Buscar(String dni) {

        Cliente cli = new Cliente();
        String sql = "select * from cliente where Dni="+dni;
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

}
