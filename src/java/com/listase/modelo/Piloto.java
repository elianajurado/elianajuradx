/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author elianajuradx
 */
public class Piloto implements  Serializable{
    private String nombre; //null
    private short codigo; //0
    private byte edad; //0
    private boolean genero;
    private String moto;
    private short posicion;

    public short getPosicion() {
        return posicion;
    }

    public void setPosicion(short posicion) {
        this.posicion = posicion;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
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
    
    public Piloto(String nombre, short codigo, byte edad, boolean genero, String moto) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.genero = genero;
        this.moto = moto;
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
