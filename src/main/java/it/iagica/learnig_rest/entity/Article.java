package it.iagica.learnig_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "article")

public class Article{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	
	public Article(String title, String description, String characteristic, Integer category, Integer quantity,
			String unity, String code, float price, Long warehouseId) {
		super();
		this.title = title;
		this.description = description;
		this.characteristic = characteristic;
		this.category = category;
		this.quantity = quantity;
		this.unity = unity;
		this.code = code;
		this.price = price;
		this.warehouseId = warehouseId;
	}	

	public Article() {
		
	}
	
	@NotNull
	@Size(min=2, max=255)
	private String title;
	

	@NotNull
	@Size(min=2, max = 255)
	private String description;
	
	@NotNull
	@Size(min=2, max = 255)
	private String characteristic; 
	
	private Integer category; 
	
	@Min(value=1, message="must be equal or greater than 1")  
	private Integer quantity;
	
	private String unity;
	
	private String code; 	
	
	@DecimalMin(value="00.01", message="must be greater than 0")  
	private float price; 	
	
	private Long warehouseId; 	
	
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
	
	public String getCharacteristic() {
		return characteristic;
	}



	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}


	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public String toString() {
		return "Articolo [titolo=" + title + ", description=" + description + ", charateristic=" + characteristic
				+ ", category=" + category + ", quantity=" + quantity + ", unity=" + unity + ", code=" + code
				+ ", price=" + price + "]";
	}

		
	

}
