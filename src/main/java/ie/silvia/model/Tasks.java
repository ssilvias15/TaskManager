/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.silvia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Silvia
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t"),
    @NamedQuery(name = "Tasks.findById", query = "SELECT t FROM Tasks t WHERE t.id = :id"),
    @NamedQuery(name = "Tasks.findByTaskname", query = "SELECT t FROM Tasks t WHERE t.taskname = :taskname")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "taskname")
    private String taskname;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    @JoinTable(name = "tags_tasks", joinColumns = {
        @JoinColumn(name = "taskid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagid", referencedColumnName = "id")})
    @ManyToMany
    private List<Tags> tagsList;
    @OneToMany(mappedBy = "taskid")
    private List<Attachments> attachmentsList;
    @OneToMany(mappedBy = "taskid")
    private List<Comments> commentsList;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Users userid;
    @JoinColumn(name = "catid", referencedColumnName = "id")
    @ManyToOne
    private Categories catid;
    @JoinColumn(name = "priorityid", referencedColumnName = "id")
    @ManyToOne
    private Priority priorityid;
    @JoinColumn(name = "statusid", referencedColumnName = "id")
    @ManyToOne
    private Status statusid;
    
    
    @Transient
    private Integer userSpringIdentifier;
    
    // for Spring form
    @Transient
    private Integer categoryId;

    public Tasks() {
    }

    public Tasks(Integer id) {
        this.id = id;
    }

    public Tasks(Integer id, String taskname, String content) {
        this.id = id;
        this.taskname = taskname;
        this.content = content;
    }

    
    
    public Integer getUserSpringIdentifier() {
		return userSpringIdentifier;
	}

	public void setUserSpringIdentifier(Integer userSpringIdentifier) {
		this.userSpringIdentifier = userSpringIdentifier;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @XmlTransient
    public List<Attachments> getAttachmentsList() {
        return attachmentsList;
    }

    public void setAttachmentsList(List<Attachments> attachmentsList) {
        this.attachmentsList = attachmentsList;
    }

    @XmlTransient
    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    public Categories getCatid() {
        return catid;
    }

    public void setCatid(Categories catid) {
        this.catid = catid;
    }

    public Priority getPriorityid() {
        return priorityid;
    }

    public void setPriorityid(Priority priorityid) {
        this.priorityid = priorityid;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    
    
    
    public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ie.silvia.model.Tasks[ id=" + id + " ]";
    }
    
}
