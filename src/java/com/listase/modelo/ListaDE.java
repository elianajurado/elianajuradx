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
 * @author elianajuradx
 */
public class ListaDE implements Serializable{
    private NodoDE cabeza;

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public ListaDE() {
    }
    
    public void adicionarNodo(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDE(infante);
        }
        else
        {
            //Lamo a mi ayudante
            NodoDE temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodoDE(infante));
            temp.getSiguiente().setAnterior(temp);
        }
        
    }
    
    public void adicionarNodoAlInicio(Infante infante)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDE(infante);
        }
        else
        {
            NodoDE temp= new NodoDE(infante);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
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
            NodoDE temp= cabeza;
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
            NodoDE temp= cabeza;            
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
            NodoDE temp= cabeza;            
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
            NodoDE temp= cabeza;            
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
        ListaDE listaTemporal= new ListaDE();
            NodoDE temp= cabeza;
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
            NodoDE temp= cabeza;
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
                cabeza.setAnterior(null);
                return;
            }
            else
            {
                NodoDE temp=cabeza;
                while(temp.getSiguiente()!=null)
                {
                    if(temp.getSiguiente().getDato().getCodigo()== codigo)
                    {
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if(temp.getSiguiente()!=null)
                            temp.getSiguiente().setAnterior(temp);
                        return;
                    }
                    temp= temp.getSiguiente();
                }
                throw new infanteExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new infanteExcepcion("La lista de infantes está vacia");
    }
    
    public Infante obtenerInfante(short codigo) throws infanteExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {
                return cabeza.getDato();
            }
            else
            {
                NodoDE temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()== codigo)
                    {
                        return temp.getDato();
                    }
                    temp= temp.getSiguiente();
                }
                throw new infanteExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new infanteExcepcion("La lista de infantes está vacia");
    }
}
