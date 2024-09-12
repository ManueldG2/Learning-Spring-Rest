package it.iagica.learnig_rest.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

import it.iagica.learnig_rest.ArticleRepository;
import it.iagica.learnig_rest.ArticleService;
import it.iagica.learnig_rest.entity.Article;
import jakarta.servlet.http.HttpServletResponse;


import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



@RestController
@RequestMapping("/api")

public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleService articleService;


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
	
	
	@RequestMapping(value = "/articolo", method = RequestMethod.GET)
	@ResponseBody
	public  Iterable getAllProduct() {
		
		return articleRepository.findAll();
		
	}
	
	@GetMapping("/articolo/{id}")
	public Optional<Article> getProductById(@PathVariable Long id) {
		
		return articleRepository.findById(id);
		
	}
	
	@PutMapping("/articolo/{id}")// update
	public ResponseEntity<Article> updateProduct(@PathVariable Long id, @RequestBody Article articolo) {
		
		
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
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity deleteProduct(@PathVariable Long id , HttpServletResponse response) {
						
		articleService.deleteArticolo(id);
		
		return new ResponseEntity("ok", HttpStatus.OK);		
				
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Article> addProduct(@RequestParam Map params , HttpServletResponse response) {
						
		Article art = articleService.toEntity(params);
		
		articleRepository.save(art);
		
		return new ResponseEntity("ok", HttpStatus.CREATED);		
				
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Article> updateProduct(@RequestParam Map params, HttpServletResponse response) {
						
		Article art = articleService.toEntity(params);
		
		Long id = ( Long.parseLong((String) params.get("id")) );		
		
		return new ResponseEntity(articleService.updateArticolo(art, id), HttpStatus.OK);		
				
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
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
  
        String[] header = { "Title", "Description", "Category", "Quantity", "Unity", "Code", "Price"};
        
        csvWriter.writeHeader(header);
 
        for (Article article : listArticle) {
            csvWriter.write(article, header);
        }
        
        csvWriter.close();
    }
	

}
