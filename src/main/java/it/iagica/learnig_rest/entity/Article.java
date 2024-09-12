package it.iagica.learnig_rest.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")

public class Article{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 	
	
	public Article(String title, String description, String characteristic, Integer category, Integer quantity,
			String unity, String code, float price) {
		super();
		this.title = title;
		this.description = description;
		this.characteristic = characteristic;
		this.category = category;
		this.quantity = quantity;
		this.unity = unity;
		this.code = code;
		this.price = price;
	}
	
	

	public Article() {
		
	}


	private String title;
	
	private String description;
	
	private String characteristic; 
	
	private Integer category; 
	
	private Integer quantity;
	
	private String unity;
	
	private String code; 
	
	private float price; 	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titolo) {
		this.title = titolo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrizione) {
		this.description = descrizione;
	}

	public String getCharateristic() {
		return characteristic;
	}

	public void setCharateristic(String charateristic) {
		this.characteristic = charateristic;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Articolo [titolo=" + title + ", description=" + description + ", charateristic=" + characteristic
				+ ", category=" + category + ", quantity=" + quantity + ", unity=" + unity + ", code=" + code
				+ ", price=" + price + "]";
	}



	
		
	

}
