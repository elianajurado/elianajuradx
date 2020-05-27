/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listacircularde.modelo;


import com.listase.excepciones.PilotoExcepcion;
import com.listase.modelo.NodopDE;
import com.listaenlazada.modelop.Piloto;
import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class ListaCircularpDE implements Serializable{
    private NodopDE cabeza;

    public NodopDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodopDE cabeza) {
        this.cabeza = cabeza;
    }
    
    
    
     public void adicionarNodo(Piloto piloto) {
        if (cabeza == null) {
            cabeza = new NodopDE(piloto);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            
        } else {
           NodopDE temp= cabeza.getAnterior();
           NodopDE nodoInsertar = new NodopDE(piloto);
           temp.setSiguiente(nodoInsertar);
           nodoInsertar.setAnterior(temp);           
           nodoInsertar.setSiguiente(cabeza);
           cabeza.setAnterior(nodoInsertar);
        }
    }

    public void adicionarNodoAlInicio(Piloto piloto) {
        if (cabeza == null) {
             cabeza = new NodopDE(piloto);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodopDE temp= cabeza.getAnterior();
           NodopDE nodoInsertar = new NodopDE(piloto);
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
            NodopDE temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=cabeza)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    
     public String listarPilotos(String listado) throws PilotoExcepcion
     {
        if (cabeza != null) {
            NodopDE temp = cabeza;
            do
            {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }while(temp != cabeza);

            return listado;
        }
        throw new PilotoExcepcion(("No existen niños en la lista"));
    }
     
    
}
