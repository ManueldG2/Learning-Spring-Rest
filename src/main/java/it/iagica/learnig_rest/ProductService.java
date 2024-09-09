package it.iagica.learnig_rest;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.iagica.learnig_rest.entity.Product;

@Service
public class ProductService {
		
		@Autowired
		ProductRepository productRepository; 
		
		
		
		@Autowired
		public ProductService(ProductRepository productRepository) {
			
			this.productRepository = productRepository;
			
		}
		
		public Product saveProduct(Product product) {
			
			return (Product) productRepository.save(product);
			
		}
		
		public List<Product> findAllProduct(Product product) {
				
				return (List<Product>) productRepository.findAll();
				
			}
		
		public List<Product> findById(long id) {
			
			return (List<Product>) productRepository.findById(id).orElse(null);
			
		}
		
		// update operation
	    
	    public Product updateProduct(Product product, Long id) {
	    	
	        Product depDB = (Product) productRepository.findById(id).get();
	 
	        if (Objects.nonNull(product.getTitle()) && !"".equalsIgnoreCase(product.getTitle())) {
	            depDB.setTitle(product.getTitle());
	        }
	        
	        if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
	            depDB.setDescription(product.getDescription());
	        }
	        
	        if (Objects.nonNull(product.getQuantity()) ) {
	            depDB.setQuantity(product.getQuantity());
	        }
	        /*
	         * fare la verifica degli altri campi */
	        if (Objects.nonNull(product.getPrice()) ) {
	            depDB.setPrice( (Float) (product.getPrice()));
	        }
	     
	       
	        
	        return (Product) productRepository.save(depDB);
	    }
	 


		public void deleteProduct(Long id) {
			System.out.println("delete " + id);
			productRepository.deleteById(id);
			
		}
	



}
