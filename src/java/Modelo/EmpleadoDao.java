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
import static java.util.Collections.list;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author santi
 */
public class EmpleadoDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado Validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "Select * from empleado where usuario=? and Dni=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);

            rs = ps.executeQuery();
            while (rs.next()) {
                em.setDni(rs.getString("Dni"));
                em.setUser(rs.getString("usuario"));

                em.setId_empleado(rs.getInt("id_empleado"));
                em.setEs(rs.getString("Estado"));
                em.setEmail(rs.getString("correo"));
                em.setNom(rs.getString("nombre"));
            }

        } catch (SQLException e) {
        }
        return em;
    }

    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId_empleado(rs.getInt(1));
                em.setNom(rs.getString(2));
                em.setUser(rs.getString(3));
                em.setDni(rs.getString(4));
                em.setEmail(rs.getString(5));
                em.setEs(rs.getString(6));
                lista.add(em);
            }
        } catch (SQLException e) {
        }
        return lista;

    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(nombre,usuario,dni,correo,estado)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setString(2, em.getUser());
            ps.setString(3, em.getDni());
            ps.setString(4, em.getEmail());
            ps.setString(5, em.getEs());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
        return r;
    }

    public void eliminar(int id) {

        String sql = "delete from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setNom(rs.getString(2));
                emp.setUser(rs.getString(3));
                emp.setDni(rs.getString(4));
                emp.setEmail(rs.getString(5));
                emp.setEs(rs.getString(6));

            }
        } catch (SQLException e) {
        }
        return emp;
    }

    public int Actualizar(Empleado em) {
        String sql = "update empleado set nombre=? , usuario=? , dni=? , correo=? , estado=? where Id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, em.getNom());
            ps.setString(2, em.getUser());
            ps.setString(3, em.getDni());
            ps.setString(4, em.getEmail());
            ps.setString(5,em.getEs());
            ps.setInt(6, em.getId_empleado());
            ps.executeUpdate();
           

        } catch(SQLException e)  {
        }
        
        return r;
    }

}
