package it.iagica.learnig_rest.dto;

public class ExportDto {
	
	
	



	



	public ExportDto(Long id, String title, Float price, String description, String characteristic, String unity, String code, Integer amount, String position, String category) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.characteristic = characteristic;
		this.unity = unity;
		this.code = code;
		this.amount = amount;
		this.position = position;
		this.category = category;
		
	}
	
	private Long id;
	private String title;	
	private Float price;
	private String description;
	private String characteristic;
	private String unity;
	private String code;
	private Integer amount;
	private String position;
	private String category;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Long getId() {
		return id;
	}
	public void setId(Long artId) {
		this.id = artId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
