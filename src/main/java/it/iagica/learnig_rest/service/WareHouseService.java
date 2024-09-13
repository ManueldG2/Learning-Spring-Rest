package it.iagica.learnig_rest.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.iagica.learnig_rest.entity.WareHouse;
import it.iagica.learnig_rest.repository.WareHouseRepository;

@Service
public class WareHouseService<K, V> {
		
		
		@Autowired
		WareHouseRepository wareHouseRepository;
		
		@Autowired
		public WareHouseService(WareHouseRepository warehouseRepository) {
			
			this.wareHouseRepository = warehouseRepository;			
			
		}
		

		public List<WareHouse> findAllArticolo(WareHouse article) {
				
				return (List<WareHouse>) wareHouseRepository.findAll();
				
			}
		
		public WareHouse findById(long id) {
			
			return  wareHouseRepository.findById(id).orElse(null);
			
		}
		
		// update operation
	    
	    public WareHouse updateWareHouse(WareHouse article, Long id) {
	    	
	    	//prendo l'articolo di ID id
	    	WareHouse depDB = wareHouseRepository.findById(id).get();
	    	
	    	/*
	    	//controllo se i parametri non sono nulli
	    	if (  (Objects.nonNull( article.getTitle()) && !("".equalsIgnoreCase(article.getTitle()) ) ) ){
	            depDB.setTitle(article.getTitle());
	        }
	        else {
	        	System.out.println("titolo" + article.toString());
	        } 
	    	
	    	 if (  (Objects.nonNull( article.getCharateristic() ) && !("".equalsIgnoreCase(article.getCharateristic() ) ) ) ){
		            depDB.setCharateristic(article.getCharateristic());
		        }
		        else {
		        	System.out.println("descrizione" + article.toString());
		        }
	    	
	        
	        if (  (Objects.nonNull( article.getDescription()) && !("".equalsIgnoreCase(article.getDescription()) ) ) ){
	            depDB.setDescription(article.getDescription());
	        }
	        else {
	        	System.out.println("descrizione" + article.toString());
	        }
	        
	        if (  (Objects.nonNull( article.getQuantity()) ) ){
	            depDB.setQuantity(article.getQuantity());
	        }
	        else {
	        	System.out.println("descrizione" + article.toString());
	        }	        
	        
	        /* fare la verifica degli altri campi */
	    	
	    	/*
	        if (Objects.nonNull(article.getPrice()) ) {
	            depDB.setPrice( (Float) (article.getPrice()));
	        }
	        else {
	        	System.out.println("price" + article.toString());
	        }*/
	        
	    	
	    	/*
	        System.out.println(depDB.toString());
	        depDB.setDescription(WareHouse.getDescription());
	        depDB.setCode( warehouse.getCode());    
	        */
	        return (WareHouse) wareHouseRepository.save(depDB);
	    }

		public void deleteArticolo(Long id) {
			System.out.println("delete " + id);
			wareHouseRepository.deleteById(id);
			
		}
		
		//metodo per convertire oggetto Map in Article
		public WareHouse toEntity(Map<K,V> params) {		
			
			
			Integer amount = (Integer) params.get("amount");
			String position = (String) params.get("position");
			
			// valore != null e conversione String -> Integer
			String cat =   (!("").equals(params.get("category"))) ? (String) params.get("category") : "0";
			Integer categoria = Integer.parseInt(cat);
			
			WareHouse art = new WareHouse( amount, position);		
			
			return art;
			
		}

}