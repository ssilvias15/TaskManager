/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.silvia.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Silvia
 */
@Entity
@Table(name = "priority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Priority.findAll", query = "SELECT p FROM Priority p"),
    @NamedQuery(name = "Priority.findById", query = "SELECT p FROM Priority p WHERE p.id = :id"),
    @NamedQuery(name = "Priority.findByPriorname", query = "SELECT p FROM Priority p WHERE p.priorname = :priorname")})
public class Priority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "priorname")
    private String priorname;
    @OneToMany(mappedBy = "priorityid")
    private List<Tasks> tasksList;

    public Priority() {
    }

    public Priority(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriorname() {
        return priorname;
    }

    public void setPriorname(String priorname) {
        this.priorname = priorname;
    }

    @XmlTransient
    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
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
        if (!(object instanceof Priority)) {
            return false;
        }
        Priority other = (Priority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ie.silvia.model.Priority[ id=" + id + " ]";
    }
    
}
