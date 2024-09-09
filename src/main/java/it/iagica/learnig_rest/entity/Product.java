package it.iagica.learnig_rest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")

public class Product{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	private String title;
	
	private String description;

	private float price;
	
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty
	public float getPrice() {
		
		System.out.println("get");
		return price;
		
	}
	
	@JsonProperty
	public void setPrice(float price) {
		
		System.out.println("set " + price);
		this.price =  price;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	

}
