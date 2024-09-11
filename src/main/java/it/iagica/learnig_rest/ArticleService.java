package it.iagica.learnig_rest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.iagica.learnig_rest.entity.Article;

@Service
public class ArticleService {
		
		@Autowired
		ArticleRepository articleRepository; 
		
		
		
		@Autowired
		public ArticleService(ArticleRepository articleRepository) {
			
			this.articleRepository = articleRepository;
			
		}
		
		public Article saveArticolo(Article article) {
			
			
			return (Article) articleRepository.save(article);
			
		}
		
		public List<Article> findAllArticolo(Article article) {
				
				return (List<Article>) articleRepository.findAll();
				
			}
		
		public List<Article> findById(long id) {
			
			return (List<Article>) articleRepository.findById(id).orElse(null);
			
		}
		
		// update operation
	    
	    public Article updateArticolo(Article article, Long id) {
	    	
	        Article depDB = articleRepository.findById(id).get();
	 
	        if (Objects.nonNull(article.getTitolo()) && !"".equalsIgnoreCase(article.getTitolo())) {
	            depDB.setTitolo(article.getTitolo());
	        }
	        
	        if (Objects.nonNull(article.getDescrizione()) && !"".equalsIgnoreCase(article.getDescrizione())) {
	            depDB.setDescrizione(article.getDescrizione());
	        }
	        
	        if (Objects.nonNull(article.getQuantity()) ) {
	            depDB.setQuantity(article.getQuantity());
	        }
	        /*
	         * fare la verifica degli altri campi */
	        if (Objects.nonNull(article.getPrice()) ) {
	            depDB.setPrice( (Float) (article.getPrice()));
	        }
	     
	       
	        
	        return (Article) articleRepository.save(depDB);
	    }

		public void deleteArticolo(Long id) {
			System.out.println("delete " + id);
			articleRepository.deleteById(id);
			
		}
		
		
	



}


