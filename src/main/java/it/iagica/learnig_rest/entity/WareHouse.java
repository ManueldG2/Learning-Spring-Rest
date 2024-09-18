package it.iagica.learnig_rest.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
	
	@Min(value=1, message="must be equal or greater than 1")  
	private Integer amount;
	
	@NotNull
	@Size(min=2, max=255)
	private String position;
		
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
	
	
}
