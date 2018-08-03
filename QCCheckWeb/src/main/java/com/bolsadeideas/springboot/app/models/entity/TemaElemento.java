/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jmendosa
 */
@Entity
@Table(name = "tema_elemento", catalog = "qc_help_revision", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemaElemento.findAll", query = "SELECT t FROM TemaElemento t")
    , @NamedQuery(name = "TemaElemento.findByIdtemaElemento", query = "SELECT t FROM TemaElemento t WHERE t.idtemaElemento = :idtemaElemento")
    , @NamedQuery(name = "TemaElemento.findByTemaElemento", query = "SELECT t FROM TemaElemento t WHERE t.temaElemento = :temaElemento")
    , @NamedQuery(name = "TemaElemento.findByEstado", query = "SELECT t FROM TemaElemento t WHERE t.estado = :estado")})
public class TemaElemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtema_elemento", nullable = false)
    private Integer idtemaElemento;
    @Column(name = "tema_elemento", length = 45)
    private String temaElemento;
    @Lob
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "idherramienta", referencedColumnName = "idherramienta")
    @ManyToOne(fetch = FetchType.LAZY)
    private TemaHerramienta idherramienta;
    @OneToMany(mappedBy = "idelemento", fetch = FetchType.LAZY)
    private List<Validacion> validacionList;

    public TemaElemento() {
    }

    public TemaElemento(Integer idtemaElemento) {
        this.idtemaElemento = idtemaElemento;
    }

    public Integer getIdtemaElemento() {
        return idtemaElemento;
    }

    public void setIdtemaElemento(Integer idtemaElemento) {
        this.idtemaElemento = idtemaElemento;
    }

    public String getTemaElemento() {
        return temaElemento;
    }

    public void setTemaElemento(String temaElemento) {
        this.temaElemento = temaElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TemaHerramienta getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(TemaHerramienta idherramienta) {
        this.idherramienta = idherramienta;
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
        hash += (idtemaElemento != null ? idtemaElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemaElemento)) {
            return false;
        }
        TemaElemento other = (TemaElemento) object;
        if ((this.idtemaElemento == null && other.idtemaElemento != null) || (this.idtemaElemento != null && !this.idtemaElemento.equals(other.idtemaElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.TemaElemento[ idtemaElemento=" + idtemaElemento + " ]";
    }
    
}
