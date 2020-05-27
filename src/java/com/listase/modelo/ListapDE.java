/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.PilotoExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.listaenlazada.modelop.Piloto;

/**
 *
 * @author elianajuradx
 */
public class ListapDE implements Serializable{
    private NodopDE cabeza;

    public NodopDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodopDE cabeza) {
        this.cabeza = cabeza;
    }

    public ListapDE() {
    }
    
    public void adicionarNodo(Piloto piloto)
    {
        if(cabeza ==null)
        {
            cabeza = new NodopDE(piloto);
        }
        else
        {
            //Lamo a mi ayudante
            NodopDE temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodopDE(piloto));
            temp.getSiguiente().setAnterior(temp);
        }
        
    }
    
    public void adicionarNodoAlInicio(Piloto piloto)
    {
        if(cabeza ==null)
        {
            cabeza = new NodopDE(piloto);
        }
        else
        {
            NodopDE temp= new NodopDE(piloto);
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
            NodopDE temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoPilotos()
    {
        
        //Un método recursivo que recoora mis pilotos y que sacando la
        // info la adicione een el string
        
        return listarPilotos("");
    }
    
    public String listarPilotos(String listado)
    {
        if(cabeza !=null)
        {
            NodopDE temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay pilotos";
    }
    
    
     public List obtenerListaPilotos()
    {
        List<Piloto> listado = new ArrayList<>();
        //Un método recursivo que recoora mis pilotos y que sacando la
        // info la adicione een el string
        listarPilotos(listado);
        return listado;
    }
    
    public void listarPilotos(List listado)
    {
        if(cabeza !=null)
        {
            NodopDE temp= cabeza;            
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
            NodopDE temp= cabeza;            
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
        ListapDE listaTemporal= new ListapDE();
            NodopDE temp= cabeza;
            while(temp!=null)
            {
                listaTemporal.adicionarNodoAlInicio(temp.getDato() );
                temp=temp.getSiguiente();
                
            }
            cabeza= listaTemporal.getCabeza();
        }
    }
    

    
    public void eliminarPiloto(short codigo) throws PilotoExcepcion
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
                NodopDE temp=cabeza;
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
                throw new PilotoExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new PilotoExcepcion("La lista de pilotos está vacia");
    }
    
    public Piloto obtenerPiloto(short codigo) throws PilotoExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {
                return cabeza.getDato();
            }
            else
            {
                NodopDE temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()== codigo)
                    {
                        return temp.getDato();
                    }
                    temp= temp.getSiguiente();
                }
                throw new PilotoExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new PilotoExcepcion("La lista de pilotos está vacia");
    }


  
    public int cantidad ()
    {
        int cant = 0;
        NodopDE reco = this.cabeza;
        while (reco != null) {
            reco = reco.getSiguiente();
            cant++;
        }
        return cant;
    }

   public void adicionarPosicion(int pos, Piloto x)
    {
        if (pos <= cantidad () + 1)    {
            NodopDE nuevo = new NodopDE(x);
           
            if (pos == 1){
                nuevo.setSiguiente(this.cabeza); 
                if (this.cabeza!=null)
                    
                this.cabeza.setAnterior(nuevo);
                this.cabeza = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    NodopDE reco = this.cabeza;
                    while (reco.getSiguiente() != null) {
                        reco = reco.getSiguiente();
                    }
                    reco.setSiguiente(nuevo);
                    nuevo.setAnterior(reco);
                    nuevo.setSiguiente(null);
                } else {
                    NodopDE reco = this.cabeza;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.getSiguiente();
                    NodopDE siguiente = reco.getSiguiente();
                    reco.setSiguiente(nuevo) ;
                    nuevo.setAnterior(reco);
                    nuevo.setSiguiente(siguiente); 
                    siguiente.setAnterior(nuevo);
                }
        }
    }
    
    public short obtenerPosicion(short codigo)throws PilotoExcepcion{
        
        if(cabeza==null){
            throw new PilotoExcepcion("La lista de pilotos esta vacia");
            
        } else{
            NodopDE temp= cabeza;
            short cont= 1;
            while(temp !=null){
                if(temp.getDato().getCodigo()== codigo){
                    return cont;
                }
                temp= temp.getSiguiente();
                cont++;
            }
            throw new PilotoExcepcion("El codigo"+codigo+"No existe en la lista");
        }
    }
    
    public void adicionarNodoPosicion(int posicion, Piloto dato) throws PilotoExcepcion {
        if (cabeza != null) {
            if (posicion == 1) {
                adicionarNodoAlInicio(dato);               
            } else {
                int cont = 1;
                NodopDE temp = cabeza;
                while (temp != null) {
                    if ((posicion - 1) == cont) {
                        NodopDE nodoInsertar = new NodopDE(dato);
                        nodoInsertar.setSiguiente(temp.getSiguiente());
                        temp.setSiguiente(nodoInsertar);
                        if(nodoInsertar.getSiguiente()!=null)
                            nodoInsertar.getSiguiente().setAnterior(nodoInsertar);
                        nodoInsertar.setAnterior(temp);
                        break ;
                    }
                    temp = temp.getSiguiente();
                    cont++;
                }
            }
        }
        else{
            throw new PilotoExcepcion(("La lista está vacía"));
        }
    }

    public int obtenerPosicionPiloto(short codigo) throws PilotoExcepcion {
        if (cabeza != null) {
            int cont = 1;
            NodopDE temp = cabeza;
            while (temp != null) {
                if (temp.getDato().getCodigo() == codigo) {
                    return cont;
                }
                temp = temp.getSiguiente();
                cont++;
            }
            throw new PilotoExcepcion("El código ingresado no existe ");

        }
        throw new PilotoExcepcion("La lista de pilotos está vacía");
    }
    public void intercambiarNodos(byte datoA, byte datoB) throws PilotoExcepcion{
        if (cabeza != null){
            throw new PilotoExcepcion("La lista de pilotos está vacía");
        } else {
            NodopDE temp = cabeza;
            Piloto tempDatoA = null;
            Piloto tempDatoB = null;
            while (temp!=null) {
                if (temp.getDato().getCodigo() == datoA){
                    tempDatoA=temp.getDato();
                }
                else if (temp.getDato().getCodigo() == datoB) {
                    tempDatoB=temp.getDato();
                }
                temp = temp.getSiguiente();
            }
            
            if ( tempDatoA==null || tempDatoB==null)
                throw new PilotoExcepcion("Alguno de los datos son erroneos");
            
            Piloto pilotoTemp = tempDatoA;
            tempDatoA = tempDatoB;
            tempDatoB = pilotoTemp;
            
        }
    
    }
    
    public Piloto obtenerPilotoMenorEdad() throws PilotoExcepcion
    {
        if(cabeza !=null)
        {
            Piloto menor = cabeza.getDato();
            NodopDE temp = cabeza;
            while (temp !=null) 
            {
                if(temp.getDato().getEdad()< menor.getEdad())
                {
                    menor = temp.getDato();
                }
                temp = temp.getSiguiente();
            }
            return menor;
        }
        throw new PilotoExcepcion("La lista de pilotos esta vacio"); 
    }
    
}


      
    