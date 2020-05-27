/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listaenlazada.modelop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elianajuradx
 */
@Entity
@Table(name = "piloto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piloto.findAll", query = "SELECT p FROM Piloto p")
    , @NamedQuery(name = "Piloto.findByCodigo", query = "SELECT p FROM Piloto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Piloto.findByNombre", query = "SELECT p FROM Piloto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Piloto.findByEdad", query = "SELECT p FROM Piloto p WHERE p.edad = :edad")
    , @NamedQuery(name = "Piloto.findByGenero", query = "SELECT p FROM Piloto p WHERE p.genero = :genero")
    , @NamedQuery(name = "Piloto.findByMoto", query = "SELECT p FROM Piloto p WHERE p.moto = :moto")})
public class Piloto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Short codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private short edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private boolean genero;
    @Size(max = 100)
    @Column(name = "moto")
    private String moto;

    public Piloto() {
    }

    public Piloto(Short codigo) {
        this.codigo = codigo;
    }

    public Piloto(Short codigo, String nombre, short edad, boolean genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public Short getCodigo() {
        return codigo;
    }

    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piloto)) {
            return false;
        }
        Piloto other = (Piloto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.listaenlazada.modelop.Piloto[ codigo=" + codigo + " ]";
    }
    
}
