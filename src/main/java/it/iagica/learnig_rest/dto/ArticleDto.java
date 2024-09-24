package it.iagica.learnig_rest.dto;

public class ArticleDto {
	
	private String position;	
	private String categoria;	
	private String title;
	private Float cost_per_package;
	private Float price;
	private String description;
	private Integer quantita_per_pacchetto;
	private String characteristic;
	private String unity;
	private String code;
	private Integer quantity;
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getCost_per_package() {
		return cost_per_package;
	}
	public void setCost_per_package(Float cost_per_package) {
		this.cost_per_package = cost_per_package;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantita_per_pacchetto() {
		return quantita_per_pacchetto;
	}
	public void setQuantita_per_pacchetto(Integer quantita_per_pacchetto) {
		this.quantita_per_pacchetto = quantita_per_pacchetto;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
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
	public void setQuantity(Integer quantity) {
		
		this.quantity= quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	

}
