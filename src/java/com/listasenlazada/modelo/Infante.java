/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listasenlazada.modelo;

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
@Table(name = "infante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infante.findAll", query = "SELECT i FROM Infante i")
    , @NamedQuery(name = "Infante.findByCodigo", query = "SELECT i FROM Infante i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Infante.findByNombre", query = "SELECT i FROM Infante i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Infante.findByEdad", query = "SELECT i FROM Infante i WHERE i.edad = :edad")
    , @NamedQuery(name = "Infante.findByCiudadNacimiento", query = "SELECT i FROM Infante i WHERE i.ciudadNacimiento = :ciudadNacimiento")
    , @NamedQuery(name = "Infante.findByGenero", query = "SELECT i FROM Infante i WHERE i.genero = :genero")})
public class Infante implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "ciudad_nacimiento")
    private String ciudadNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private boolean genero;

    public Infante() {
    }

    public Infante(Short codigo) {
        this.codigo = codigo;
    }

    public Infante(Short codigo, String nombre, short edad, String ciudadNacimiento, boolean genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudadNacimiento = ciudadNacimiento;
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

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
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
        if (!(object instanceof Infante)) {
            return false;
        }
        Infante other = (Infante) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return this.nombre;
    }
}
