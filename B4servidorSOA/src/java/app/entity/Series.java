/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Félix
 */
@Entity
@Table(name = "SERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Series.findAll", query = "SELECT s FROM Series s"),
    @NamedQuery(name = "Series.findById", query = "SELECT s FROM Series s WHERE s.id = :id"),
    @NamedQuery(name = "Series.findByNombre", query = "SELECT s FROM Series s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Series.findByPuntuacion", query = "SELECT s FROM Series s WHERE s.puntuacion = :puntuacion"),
    @NamedQuery(name = "Series.findByAutor", query = "SELECT s FROM Series s WHERE s.autor = :autor")})
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PUNTUACION")
    private Integer puntuacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AUTOR")
    private String autor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idserie")
    private List<Vinietas> vinietasList;

    public Series() {
    }

    public Series(Integer id) {
        this.id = id;
    }

    public Series(Integer id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlTransient
    public List<Vinietas> getVinietasList() {
        return vinietasList;
    }

    public void setVinietasList(List<Vinietas> vinietasList) {
        this.vinietasList = vinietasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Series)) {
            return false;
        }
        Series other = (Series) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Series[ id=" + id + " ]";
    }
    
}
