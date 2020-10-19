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
public class EmpleadoDao {
     Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
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
