package it.iagica.learnig_rest.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "warehouse")

public class WareHouse{
	
	public WareHouse() {
		
	}


	public WareHouse(Long article_id, Integer amount, String position) {
		
		this.article_id = article_id;
		this.amount = amount;
		this.position = position;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private Long article_id;
	
	private Integer amount;
	
	private String position;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
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
		return "Warehouse [id=" + id + ", article_id=" + article_id + ", amount=" + amount + ", position=" + position
				+ "]";
	}
	
	//SELECT article.title, article.description, article.characteristic, category.name, article.unity, article.quantity, article.price, article.code FROM article JOIN category ON article.category=category.id; 
		
	

}
