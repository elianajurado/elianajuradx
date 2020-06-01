/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;
import com.listasenlazada.modelo.Infante;

/**
 *
 * @author carloaiza
 */
public class Nodo implements Serializable{
    private Infante dato;
    private Nodo siguiente;
    private Piloto posicion;

    
    public Nodo(Infante dato) {
        this.dato = dato;
    }

    public Piloto getPosicion() {
        return posicion;
    }

    public void setPosicion(Piloto posicion) {
        this.posicion = posicion;
    }
      

    public Infante getDato() {
        return dato;
    }

    public void setDato(Infante dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
