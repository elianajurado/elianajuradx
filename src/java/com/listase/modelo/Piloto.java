/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

/**
 *
 * @author elianajuradx
 */
public class Piloto {
    private String nombre; //null
    private short codigo; //0
    private byte edad; //0
    private boolean genero;
    private String ciudadNacimiento;

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public Piloto() {
        this.edad=1;
    }    
    
    public Piloto(String nombre, short codigo, byte edad, boolean genero, String ciudadNacimiento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.genero = genero;
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
       return this.nombre; 
    }
    
    
}
