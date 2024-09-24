package it.iagica.learnig_rest.dto;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import it.iagica.learnig_rest.entity.Article;

public class WareHouseDto {
    
    private Long id;

    private Integer amount;

    private String position;
    
    private ArrayList<Map<Long, Article>> article;	

	public ArrayList<Map<Long, Article>> getArticle() {
		
		return  article;
		
	}

	public void setArticle(List<Map<Long, Object>> warehouse) {			
		
		ArrayList<Map<Long, Article>> newList = new ArrayList();
		Map<Long, Article> newMap = null;
		Long id =  1L;
		
		for (Map elem : warehouse) {
			
			newMap = new HashMap();
			Article article = new Article();		
			
			article.setCharacteristic( (String) elem.get("characteristic"));
			article.setCode( (String) elem.get("code"));
			article.setDescription( (String) elem.get("description"));
			article.setUnity((String) elem.get("unity"));
			article.setTitle((String) elem.get("title"));
			article.setPrice( (Float) elem.get("price") );
			article.setQuantity((Integer) elem.get("quantity") );			 
			
			newMap.put( (Long) elem.get("art_id"), article);			
			
			newList.add(0,newMap);
			
		}		
		System.out.println(newList.get(1));
		this.article =  newList;
		//this.article = warehouse;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmount() {
		//pulire i dati
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
