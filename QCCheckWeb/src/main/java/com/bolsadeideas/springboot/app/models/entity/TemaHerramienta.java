/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmendosa
 */
@Entity
@Table(name = "tema_herramienta", catalog = "qc_help_revision", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemaHerramienta.findAll", query = "SELECT t FROM TemaHerramienta t")
    , @NamedQuery(name = "TemaHerramienta.findByIdherramienta", query = "SELECT t FROM TemaHerramienta t WHERE t.idherramienta = :idherramienta")
    , @NamedQuery(name = "TemaHerramienta.findByNombreHerramienta", query = "SELECT t FROM TemaHerramienta t WHERE t.nombreHerramienta = :nombreHerramienta")
    , @NamedQuery(name = "TemaHerramienta.findByEstado", query = "SELECT t FROM TemaHerramienta t WHERE t.estado = :estado")
    , @NamedQuery(name = "TemaHerramienta.findByFechaCreacion", query = "SELECT t FROM TemaHerramienta t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TemaHerramienta.findByFechaDesactivacion", query = "SELECT t FROM TemaHerramienta t WHERE t.fechaDesactivacion = :fechaDesactivacion")})
public class TemaHerramienta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idherramienta", nullable = false)
    private Integer idherramienta;
    @Column(name = "nombre_herramienta", length = 45)
    private String nombreHerramienta;
    @Column(name = "estado")
    private Boolean estado;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_desactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;
    @OneToMany(mappedBy = "idherramienta", fetch = FetchType.LAZY)
    private List<TemaElemento> temaElementoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idherramienta", fetch = FetchType.LAZY)
    private List<Validacion> validacionList;

    public TemaHerramienta() {
    }

    public TemaHerramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public Integer getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

    @XmlTransient
    public List<TemaElemento> getTemaElementoList() {
        return temaElementoList;
    }

    public void setTemaElementoList(List<TemaElemento> temaElementoList) {
        this.temaElementoList = temaElementoList;
    }

    @XmlTransient
    public List<Validacion> getValidacionList() {
        return validacionList;
    }

    public void setValidacionList(List<Validacion> validacionList) {
        this.validacionList = validacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idherramienta != null ? idherramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemaHerramienta)) {
            return false;
        }
        TemaHerramienta other = (TemaHerramienta) object;
        if ((this.idherramienta == null && other.idherramienta != null) || (this.idherramienta != null && !this.idherramienta.equals(other.idherramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TemaHerramienta[ idherramienta=" + idherramienta + " ]";
    }
    
}
