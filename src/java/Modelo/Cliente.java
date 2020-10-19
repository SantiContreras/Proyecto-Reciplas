/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santi
 */
public class Cliente {
    int id_cliente;
    String Dni;
    String Nom;
    String Dir;
    String tel;

    public Cliente() {
    }

    public Cliente(int id_cliente, String Dni, String Nom, String Dir, String tel) {
        this.id_cliente = id_cliente;
        this.Dni = Dni;
        this.Nom = Nom;
        this.Dir = Dir;
        this.tel = tel;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    
    
}
