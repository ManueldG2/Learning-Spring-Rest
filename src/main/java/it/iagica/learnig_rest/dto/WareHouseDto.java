package it.iagica.learnig_rest.dto;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Set;

import it.iagica.learnig_rest.entity.Article;

public class WareHouseDto {
    
    private Long id;

    private Integer amount;

    private String position;
    
    private ArrayList<Map<Long, ArticleDto>> article;	

	public ArrayList<Map<Long, ArticleDto>> getArticle() {
		
		return  article;
		
	}

	public void setArticle(List<Map<Long, Object>> warehouse) {			
		
		ArrayList<Map<Long, ArticleDto>> newList = new ArrayList();
		Map<Long, ArticleDto> newMap = null;
		
			
		for (Map elem : warehouse) {
				
			newMap = new HashMap();
			
			ArticleDto article = new ArticleDto();		
			
			article.setArtId((Long) elem.get("artId"));		
			article.setTitle((String) elem.get("title"));		
			article.setDescription( (String) elem.get("description"));
			article.setCharacteristic( (String) elem.get("characteristic"));
				
			article.setCode( (String) elem.get("code"));			
			article.setUnity((String) elem.get("unity"));
				
			if(Objects.nonNull( (Float) elem.get("price") ))	
				article.setPrice( (Float) elem.get("price") );
			else
				article.setPrice( (Float) 0F );
			/*	
			if(Objects.nonNull( (Integer) elem.get("quantity") ))
				article.setQuantity((Integer) elem.get("quantity") );			 
			else
				article.setPrice( (Integer) 0 );
			*/
				
				
			newMap.put( (Long) elem.get("art_id"), article);			
	
			newList.add(0,newMap);
				
		}		
	
		this.article =  newList;
		
		
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
