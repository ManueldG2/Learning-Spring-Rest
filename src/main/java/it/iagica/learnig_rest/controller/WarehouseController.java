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

import it.iagica.learnig_rest.repository.ArticleRepository;
import it.iagica.learnig_rest.repository.WareHouseRepository;


import it.iagica.learnig_rest.entity.Article;
import it.iagica.learnig_rest.entity.WareHouse;
import it.iagica.learnig_rest.service.ArticleService;
import it.iagica.learnig_rest.service.WareHouseService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



@RestController
@RequestMapping("/api")

public class WarehouseController {
	
	@Autowired
	WareHouseRepository wareHouseRepository;
	
	@Autowired
	WareHouseService wareHouseService;

	
	// lista articoli
	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	@ResponseBody
	public  Iterable getAllArticles() {
		
		
		return wareHouseRepository.findAll();
		
	}
	
	// articolo {id}
	@GetMapping("/articolo/{id}")
	public Optional<WareHouse> getArticleById(@PathVariable Long id) {
		
		return wareHouseRepository.findById(id);
		
	}
	
	//aggiunge Articolo
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Article> addArticle(@RequestParam Map params , HttpServletResponse response) {
						
		WareHouse art = wareHouseService.toEntity(params);
		
		wareHouseRepository.save(art);
		
		return new ResponseEntity("ok", HttpStatus.CREATED);		
				
	}
	
	//aggiornamento con query string per usare il form html
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> updateProduct(@RequestParam Map params, HttpServletResponse response) {
						
		WareHouse wh = wareHouseService.toEntity(params);
		
		Long id = ( Long.parseLong((String) params.get("id")) );		
		
		return new ResponseEntity( wareHouseService.updateWareHouse(wh, id), HttpStatus.OK);		
				
	}
	
	//aggiornamento con json
	@PutMapping("/articolo/{id}")// update
	public ResponseEntity<WareHouse> updateProduct(@PathVariable Long id, @RequestBody Article articolo) {
		
		
		System.out.println(articolo.toString() + "" +  id);
		
		WareHouse depDB = wareHouseRepository.findById(id).get();
		 
		/*
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
        */
        
         wareHouseRepository.save(depDB);
         
         return new ResponseEntity<WareHouse>(wareHouseRepository.save(depDB), HttpStatus.OK);	
		
	}
	
	// cancellazione con json
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity deleteProduct(@PathVariable Long id , HttpServletResponse response) {
						
		wareHouseService.deleteArticolo(id);
		
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
 
        List<WareHouse> listArticle;
		listArticle = (List<WareHouse>) wareHouseRepository.findAll();
		
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
  
        String[] header = { "Title", "Description", "Category", "Quantity", "Unity", "Code", "Price"};
        
        csvWriter.writeHeader(header);
 
        for (WareHouse article : listArticle) {
            csvWriter.write(article, header);
        }
        
        csvWriter.close();
    }
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    return "error";
	}
	

}
