package it.iagica.learnig_rest.service;

import java.util.List;
import java.util.Map;

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
	    	
	    
	        return (WareHouse) wareHouseRepository.save(depDB);
	    }

		public void deleteArticolo(Long id) {
			
			wareHouseRepository.deleteById(id);
			
		}
		
		//metodo per convertire oggetto Map in WareHouse
		public WareHouse toEntity(Map<?, ?> params) {				
			Long id = (Long) params.get("id");
			Integer amount = (Integer) params.get("amount");
			String position = (String) params.get("position");
			
			// valore != null e conversione String -> Integer
			/* String cat =   (!("").equals(params.get("category"))) ? (String) params.get("category") : "0";
			Integer categoria = Integer.parseInt(cat);*/
			
			WareHouse wareHouse = new WareHouse(id, amount, position);		
			
			return wareHouse;
			
		}

}