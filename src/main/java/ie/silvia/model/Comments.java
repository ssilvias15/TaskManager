/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.silvia.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Silvia
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id"),
    @NamedQuery(name = "Comments.findByCommenttext", query = "SELECT c FROM Comments c WHERE c.commenttext = :commenttext")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "commenttext")
    private String commenttext;
    @JoinColumn(name = "taskid", referencedColumnName = "id")
    @ManyToOne
    private Tasks taskid;
    
    @Transient
    private Integer springTaskId;
    
    @Transient
    private Integer springUserId;

    @JoinColumn(name="userid", referencedColumnName="id")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Users user;
    
    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public Tasks getTaskid() {
        return taskid;
    }

    public void setTaskid(Tasks taskid) {
        this.taskid = taskid;
    }
    
    

    public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
	public Integer getSpringTaskId() {
		return springTaskId;
	}

	public void setSpringTaskId(Integer springTaskId) {
		this.springTaskId = springTaskId;
	}

	public Integer getSpringUserId() {
		return springUserId;
	}

	public void setSpringUserId(Integer springUserId) {
		this.springUserId = springUserId;
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
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ie.silvia.model.Comments[ id=" + id + " ]";
    }
    
}
