package ie.silvia.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@Column(name = "catname")
	private String catName;
	
	public Category(){
		
	}
	
	public Category(String catName){
		this.catName = catName;
	}
	
	public Category(Integer id, String catName){
		this.id = id;
		this.catName = catName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}

	
	
}
