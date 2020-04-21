/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.infanteExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carloaiza
 */
public class ListaSE implements Serializable{
    private Nodo cabeza;

    public ListaSE() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarNodo(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new Nodo(infante);
        }
        else
        {
            //Lamo a mi ayudante
            Nodo temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new Nodo(infante));
        }
        
    }
    
    public void adicionarNodoAlInicio(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new Nodo(infante);
        }
        else
        {
            Nodo temp= new Nodo(infante);
            temp.setSiguiente(cabeza);
            cabeza= temp;
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
            //llamar a mi ayudante
            Nodo temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoInfantes()
    {
        
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        
        return listarInfantes("");
    }
    
    public String listarInfantes(String listado)
    {
        if(cabeza !=null)
        {
            Nodo temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay infantes";
    }
    
    
     public List obtenerListaInfantes()
    {
        List<Infante> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarInfantes(listado);
        return listado;
    }
    
    public void listarInfantes(List listado)
    {
        if(cabeza !=null)
        {
            Nodo temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp=temp.getSiguiente();
                
            }            
        }
        
    }
    
    public float promediarEdades()
    {
        int sumaEdades=0;
        int contador=0;
        if(cabeza !=null)
        {
            Nodo temp= cabeza;            
            while(temp!=null)
            {
                sumaEdades += temp.getDato().getEdad();
                contador++;
                temp=temp.getSiguiente();
                
            }
            return sumaEdades/(float) contador;
        }
        return 0;
    }
    
    public void invertirLista()
    {
        if(cabeza !=null)
        {
            ListaSE listaTemporal= new ListaSE();
            Nodo temp= cabeza;
            while(temp!=null)
            {
                listaTemporal.adicionarNodoAlInicio(temp.getDato() );
                temp=temp.getSiguiente();
                
            }
            cabeza= listaTemporal.getCabeza();
        }
    }
    
    public short contarInfantesxGenero(boolean genero)
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            Nodo temp= cabeza;
            short cont=1;
            while(temp!=null)
            {
                if(temp.getDato().isGenero()==genero)
                {
                    cont++;
                }
                temp=temp.getSiguiente();
            }
            return cont;
        }
    }
    
    public void eliminarInfante(short codigo) throws infanteExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {
                cabeza=cabeza.getSiguiente();
                return;
            }
            else
            {
                Nodo temp=cabeza;
                while(temp.getSiguiente()!=null)
                {
                    if(temp.getSiguiente().getDato().getCodigo()== codigo)
                    {
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        return;
                    }
                    temp= temp.getSiguiente();
                }
                throw new infanteExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new infanteExcepcion("La lista de infantes está vacia");
    }
    
}
