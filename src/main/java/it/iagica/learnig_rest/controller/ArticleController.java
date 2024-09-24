package it.iagica.learnig_rest.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections.OrderedMap;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import it.iagica.learnig_rest.entity.Article;
import it.iagica.learnig_rest.repository.ArticleRepository;
import it.iagica.learnig_rest.service.ArticleService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



@RestController
@RequestMapping("/api/article")
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleService articleService;

	

	
	// articolo {id}
		@GetMapping("")
		public ResponseEntity< List<Map<Long, Object>>> selectJoin() {
			
			List<Map<Long, Object>> article = articleRepository.selectJoin();
			
			return new ResponseEntity(article, HttpStatus.OK);		
		}
		
		// articolo {id}
		@GetMapping("/{id}")
		public ResponseEntity<List<Map<Long, Object>>> selectJoinById(@PathVariable Long id) {
			
			List<Map<Long, Object>> article = articleRepository.selectJoinById(id);
					
			return new ResponseEntity(article,HttpStatus.OK);
		}
	
	//aggiunge Articolo
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Article> addArticle(@RequestBody @NonNull Article articolo , HttpServletResponse response) {
										
		articleRepository.save(articolo);
				
	
		return new ResponseEntity("ok", HttpStatus.CREATED);		
				
	}
	
	//aggiunge Articolo
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<Article> addArticle(@RequestParam @NonNull  Map params , HttpServletResponse response) {
							
			
			Article art = articleService.toEntity(params);
				
					
			articleRepository.save(art);
					
		
			return new ResponseEntity("ok", HttpStatus.CREATED);		
					
		}
		
	
	//aggiornamento con query string per usare il form html
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Article> updateProduct(@RequestParam Map params, HttpServletResponse response) {
						
		Article art = articleService.toEntity(params);
		
		Long id = ( Long.parseLong((String) params.get("id")) );		
		
		return new ResponseEntity(articleService.updateArticolo(art, id), HttpStatus.OK);		
				
	}
	
	//aggiornamento con json
	@PutMapping("/{id}")// update
	public ResponseEntity<Article> updateProduct(@PathVariable Long id, @RequestBody @NonNull Article articolo) {
		
		
		System.out.println(articolo.toString() + "" +  id);
		
		Article depDB = articleRepository.findById(id).get();
		 
        if (Objects.nonNull(articolo.getTitle()) && !"".equalsIgnoreCase(articolo.getTitle())) {
            depDB.setTitle(articolo.getTitle());
        }
        
        if (Objects.nonNull(articolo.getDescription()) && !"".equalsIgnoreCase(articolo.getDescription())) {
            depDB.setDescription(articolo.getDescription());
        }
        
        if (Objects.nonNull(articolo.getQuantity()) ) {
            depDB.setQuantity(articolo.getQuantity());
        }
       
        depDB.setPrice( (Float) articolo.getPrice());
              
        
         articleRepository.save(depDB);
         
         return new ResponseEntity<Article>(articleRepository.save(articolo), HttpStatus.OK);	
		
	}
	
	// cancellazione con json
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity deleteProduct(@PathVariable Long id , HttpServletResponse response) {
						
		articleService.deleteArticolo(id);
		
		return new ResponseEntity("ok", HttpStatus.OK);		
				
	}
	
	@RequestMapping(value = "/csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "article.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        List<Article> listArticle = (List<Article>) articleRepository.findAll();        
 
        // uses the Super CSV API to generate CSV data from the model data
        CsvPreference csvPreference = new CsvPreference.Builder('"', ';', "\r\n").build();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                csvPreference);
 
  
        String[] header = { "Title", "Description", "Category", "Quantity", "Unity", "Code", "Price"};
        
        csvWriter.writeHeader(header);
 
        for (Article article : listArticle) {
            csvWriter.write(article, header);
        }
        
        csvWriter.close();
    }
	
	
	
	// endpoint di test
		@GetMapping("/hello")
		public ResponseEntity<String> hello() {
			
		    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
		    
		}
		
		@GetMapping("/query")
		@ResponseBody
		public String getFoos(@RequestParam String id) {
		    return "ID: " + id;
		}
		

		// lista articoli
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<Iterable> getAllArticles() {
			
			return new ResponseEntity( articleRepository.findAll(),HttpStatus.OK);
			
		}
		
		// articolo {id}
		@GetMapping("/all/{id}")
		public ResponseEntity getArticleById(@PathVariable Long id) {
			
			Optional<Article> article = articleRepository.findById(id);
			
			return new ResponseEntity(article, HttpStatus.OK);		
		}	
		

}
