package it.iagica.learnig_rest.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "warehouse")

public class WareHouse{
	
	public WareHouse() {
		
	}


	public WareHouse( Integer amount, String position) {
		
		
		this.amount = amount;
		this.position = position;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private Integer amount;
	
	private String position;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Article> article;
	

	public List<Article> getArticle() {
		return article;
	}



	public void setArticle(List<Article> article) {
		this.article = article;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}	


	@Override
	public String toString() {
		return "Warehouse [id=" + id +" amount=" + amount + ", position=" + position
				+ "]";
	}
	
	//SELECT article.title, article.description, article.characteristic, category.name, article.unity, article.quantity, article.price, article.code FROM article JOIN category ON article.category=category.id; 
		
	

}
