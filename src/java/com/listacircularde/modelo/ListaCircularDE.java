/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircularde.modelo;


import com.listase.excepciones.InfanteExcepcion;
import com.listase.modelo.NodoDE;
import com.listasenlazada.modelo.Infante;
import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class ListaCircularDE implements Serializable{
    private NodoDE cabeza;

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }
    
    
    
     public void adicionarNodo(Infante infante) {
        if (cabeza == null) {
            cabeza = new NodoDE(infante);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            
        } else {
           NodoDE temp= cabeza.getAnterior();
           NodoDE nodoInsertar = new NodoDE(infante);
           temp.setSiguiente(nodoInsertar);
           nodoInsertar.setAnterior(temp);           
           nodoInsertar.setSiguiente(cabeza);
           cabeza.setAnterior(nodoInsertar);
        }
    }

    public void adicionarNodoAlInicio(Infante infante) {
        if (cabeza == null) {
             cabeza = new NodoDE(infante);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDE temp= cabeza.getAnterior();
           NodoDE nodoInsertar = new NodoDE(infante);
           temp.setSiguiente(nodoInsertar);
           nodoInsertar.setAnterior(temp);           
           nodoInsertar.setSiguiente(cabeza);
           cabeza.setAnterior(nodoInsertar);
           cabeza = cabeza.getAnterior();
        }
    }
    
    public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            NodoDE temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=cabeza)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    
     public String listarInfantes(String listado) throws InfanteExcepcion
     {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            do
            {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }while(temp != cabeza);

            return listado;
        }
        throw new InfanteExcepcion(("No existen niños en la lista"));
    }
     
    
}
