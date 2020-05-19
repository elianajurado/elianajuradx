/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import com.listase.excepciones.InfanteExcepcion;
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
    
    public void eliminarInfante(short codigo) throws InfanteExcepcion
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
                throw new InfanteExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new InfanteExcepcion("La lista de infantes está vacia");
    }
    
    public Infante obtenerInfante(short codigo) throws InfanteExcepcion
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
                throw new InfanteExcepcion("El código: "+codigo+ " No existe en la lista");
            }
        }
        throw new InfanteExcepcion("La lista de infantes está vacia");
    }


    public String obtenerMenorEdad() throws InfanteExcepcion {
      
        if (cabeza == null) {
            throw new InfanteExcepcion("La lista de los infantes esta vacia");

        } else {
            NodoDE temp = cabeza;
            byte menor = temp.getDato().getEdad();
              String a=temp.getDato().getNombre();
            while (temp != null) {
                if (temp.getDato().getEdad() < menor) {
                    menor = temp.getDato().getEdad();
                    a = temp.getDato().getNombre();
                    
                    
                }
                temp = temp.getSiguiente();
            }
            return a;
        }
    }
    
    public int cantidad ()
    {
        int cant = 0;
        NodoDE reco = this.cabeza;
        while (reco != null) {
            reco = reco.getSiguiente();
            cant++;
        }
        return cant;
    }

   public void adicionarPosicion(int pos, Infante x)
    {
        if (pos <= cantidad () + 1)    {
            NodoDE nuevo = new NodoDE(x);
           
            if (pos == 1){
                nuevo.setSiguiente(this.cabeza); 
                if (this.cabeza!=null)
                    
                this.cabeza.setAnterior(nuevo);
                this.cabeza = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    NodoDE reco = this.cabeza;
                    while (reco.getSiguiente() != null) {
                        reco = reco.getSiguiente();
                    }
                    reco.setSiguiente(nuevo);
                    nuevo.setAnterior(reco);
                    nuevo.setSiguiente(null);
                } else {
                    NodoDE reco = this.cabeza;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.getSiguiente();
                    NodoDE siguiente = reco.getSiguiente();
                    reco.setSiguiente(nuevo) ;
                    nuevo.setAnterior(reco);
                    nuevo.setSiguiente(siguiente); 
                    siguiente.setAnterior(nuevo);
                }
        }
    }
    
    public short obtenerPosicion(short codigo)throws InfanteExcepcion{
        
        if(cabeza==null){
            throw new InfanteExcepcion("La lista de infantes esta vacia");
            
        } else{
            NodoDE temp= cabeza;
            short cont= 1;
            while(temp !=null){
                if(temp.getDato().getCodigo()== codigo){
                    return cont;
                }
                temp= temp.getSiguiente();
                cont++;
            }
            throw new InfanteExcepcion("El codigo"+codigo+"No existe en la lista");
        }
    }
    
    public void adicionarNodoPosicion(int posicion, Infante dato) throws InfanteExcepcion {
        if (cabeza != null) {
            if (posicion == 1) {
                adicionarNodoAlInicio(dato);               
            } else {
                int cont = 1;
                NodoDE temp = cabeza;
                while (temp != null) {
                    if ((posicion - 1) == cont) {
                        NodoDE nodoInsertar = new NodoDE(dato);
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
            throw new InfanteExcepcion(("La lista está vacía"));
        }
    }

    public int obtenerPosicionInfante(short codigo) throws InfanteExcepcion {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            while (temp != null) {
                if (temp.getDato().getCodigo() == codigo) {
                    return cont;
                }
                temp = temp.getSiguiente();
                cont++;
            }
            throw new InfanteExcepcion("El código ingresado no existe ");

        }
        throw new InfanteExcepcion("La lista de infantes está vacía");
    }
    public void intercambiarNodos(byte datoA, byte datoB) throws InfanteExcepcion{
        if (cabeza != null){
            throw new InfanteExcepcion("La lista de infantes está vacía");
        } else {
            NodoDE temp = cabeza;
            Infante tempDatoA = null;
            Infante tempDatoB = null;
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
                throw new InfanteExcepcion("Alguno de los datos son erroneos");
            
            Infante infanteTemp = tempDatoA;
            tempDatoA = tempDatoB;
            tempDatoB = infanteTemp;
            
        }
    
    }
    
    public Infante obtenerInfanteMenorEdad() throws InfanteExcepcion
    {
        if(cabeza !=null)
        {
            Infante menor = cabeza.getDato();
            NodoDE temp = cabeza;
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
        throw new InfanteExcepcion("La lista de infantes esta vacio"); 
    }
    
}


      
    