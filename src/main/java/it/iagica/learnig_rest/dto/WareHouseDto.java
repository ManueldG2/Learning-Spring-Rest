package it.iagica.learnig_rest.dto;



import java.util.List;

import it.iagica.learnig_rest.entity.Article;

public class WareHouseDto {
    
    private Long id;

    private Integer amount;

    private String position;
    
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
		return "WareHouseDto [id=" + id + ", amount=" + amount + ", position=" + position + "]";
	}



   

    
}
