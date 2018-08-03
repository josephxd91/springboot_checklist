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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "validacion", catalog = "qc_help_revision", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Validacion.findAll", query = "SELECT v FROM Validacion v")
    , @NamedQuery(name = "Validacion.findByIdrevisionValidacion", query = "SELECT v FROM Validacion v WHERE v.idrevisionValidacion = :idrevisionValidacion")
    , @NamedQuery(name = "Validacion.findByRevision", query = "SELECT v FROM Validacion v WHERE v.revision = :revision")
    , @NamedQuery(name = "Validacion.findByFechaCreacion", query = "SELECT v FROM Validacion v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Validacion.findByFechaDesactivacion", query = "SELECT v FROM Validacion v WHERE v.fechaDesactivacion = :fechaDesactivacion")
    , @NamedQuery(name = "Validacion.findByEstado", query = "SELECT v FROM Validacion v WHERE v.estado = :estado")
    , @NamedQuery(name = "Validacion.findByTitulo", query = "SELECT v FROM Validacion v WHERE v.titulo = :titulo")})
public class Validacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrevision_validacion", nullable = false)
    private Integer idrevisionValidacion;
    @Column(name = "revision", length = 45)
    private String revision;
    @Lob
    @Column(name = "detalle", length = 65535)
    private String detalle;
    @Lob
    @Column(name = "ayuda", length = 65535)
    private String ayuda;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_desactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "titulo", length = 250)
    private String titulo;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @JoinColumn(name = "idelemento", referencedColumnName = "idtema_elemento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TemaElemento idelemento;
    @JoinColumn(name = "idherramienta", referencedColumnName = "idherramienta", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TemaHerramienta idherramienta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvalidacion", fetch = FetchType.LAZY)
    private List<ValidacionDetalle> validacionDetalleList;

    public Validacion() {
    }

    public Validacion(Integer idrevisionValidacion) {
        this.idrevisionValidacion = idrevisionValidacion;
    }

    public Integer getIdrevisionValidacion() {
        return idrevisionValidacion;
    }

    public void setIdrevisionValidacion(Integer idrevisionValidacion) {
        this.idrevisionValidacion = idrevisionValidacion;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TemaElemento getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(TemaElemento idelemento) {
        this.idelemento = idelemento;
    }

    public TemaHerramienta getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(TemaHerramienta idherramienta) {
        this.idherramienta = idherramienta;
    }

    @XmlTransient
    public List<ValidacionDetalle> getValidacionDetalleList() {
        return validacionDetalleList;
    }

    public void setValidacionDetalleList(List<ValidacionDetalle> validacionDetalleList) {
        this.validacionDetalleList = validacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrevisionValidacion != null ? idrevisionValidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Validacion)) {
            return false;
        }
        Validacion other = (Validacion) object;
        if ((this.idrevisionValidacion == null && other.idrevisionValidacion != null) || (this.idrevisionValidacion != null && !this.idrevisionValidacion.equals(other.idrevisionValidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Validacion[ idrevisionValidacion=" + idrevisionValidacion + " ]";
    }
    
}
