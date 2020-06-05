/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listacircular.modelo.Pirinola;
import com.listacircular.modelo.ListaCircularPirinolaDE;
import com.listacircular.modelo.NodoPirinolaDE;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author elianajuradx
 */
@Named(value = "AppPirinola")
@ApplicationScoped
public class AppPirinola {

    private String correoTurno="elianajurado0825@gmail.com";    
    private int cont=0;   
    private ListaCircularPirinolaDE pirinola;
    private NodoPirinolaDE ayudante;
    private Pirinola pirinolaActual;   
    private DefaultDiagramModel model;
    
       public ListaCircularPirinolaDE getPirinola() {
        return pirinola;
    }

    public String getCorreoTurno() {
        return correoTurno;
    }

    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setPirinola(ListaCircularPirinolaDE pirinola) {
        this.pirinola = pirinola;
    }

    public NodoPirinolaDE getAyudante() {
        return ayudante;
    }

    public void setAyudante(NodoPirinolaDE ayudante) {
        this.ayudante = ayudante;
    }

    public Pirinola getPirinolaActual() {
        return pirinolaActual;
    }

    public void setPirinolaActual(Pirinola pirinolaActual) {
        this.pirinolaActual = pirinolaActual;
    }


    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

    public void aumentarContador(String correo)
    {
        switch(correo)
        {
            case "elianajurado0825@gmail.com":
                correoTurno= "ejurado69896@umanizales.edu.co";
                break;
            default:
                correoTurno= "elianajurado0825@gmail.com";
        }
        
        cont++;
    }
    
    public boolean validarTurno(String correo)
    {
        if(correo.equals(correoTurno))
        {
            return true;
        }
        return false;
    }
    
    public AppPirinola() {
        
        pirinola = new ListaCircularPirinolaDE();        
        pirinola.adicionarNodo(new Pirinola("Toma uno", 1));
        pirinola.adicionarNodo(new Pirinola("Pon dos", 2));
        pirinola.adicionarNodo(new Pirinola("Toma todo", 3));
        pirinola.adicionarNodo(new Pirinola("pon uno", 4));        
        pintarPirinola();
    }

 
    
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if (label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }

        return conn;
    }
    public void pintarPirinola(){
        model = new DefaultDiagramModel();

        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        if (pirinola.getCabeza() != null)
        //si no esta vacia
        {
           //entonces mi ayudante va a la cabeza
            NodoPirinolaDE temp = pirinola.getCabeza();
            //defino la posición de los elementos con posX y posY
            double posX;
            double posY;
            //Puntos del diagrama, número de puntos
            int puntos = pirinola.contarNodos();
            //Define el ángulo en el que se pintará el digrama
            double angle;
            //el contador
            int cont = 0;
            //distibuyo los datos en la pirinola ejemplo sacado de: https://stackoverflow.com/questions/44358067/evenly-distribute-points-on-a-circle
            do {
                angle= (2*Math.PI*cont)/puntos;
                
                angle += (1.5 *Math.PI);
                
                posX = 35 + (15*Math.cos(angle));
                posY = 15 + (15*Math.sin(angle));
                cont++;
                
                Element ele = new Element(temp.getDato().getNombre() + ": " + temp.getDato().getCaras(), 
                        posX + "em", posY + "em");
                ele.setId(String.valueOf(temp.getDato().getNombre()));

                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));

                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));

                if (temp == pirinola.getCabeza()){
                    ele.setStyleClass("ui-diagram-inicial");
                }
                
                model.addElement(ele);
                
                temp = temp.getSiguiente();
                
            } while (temp != pirinola.getCabeza());
          
            for (int i = 0; i < model.getElements().size() - 1; i++) {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1),
                        model.getElements().get(i + 1).getEndPoints().get(0), ""));

            }

        }
    }
    public void verSiguiente(){
        pirinola.setCabeza(pirinola.getCabeza().getSiguiente());
        pintarPirinola();
    }
    public void verAnterior(){
        pirinola.setCabeza(pirinola.getCabeza().getAnterior());
        pintarPirinola();
    }


}
