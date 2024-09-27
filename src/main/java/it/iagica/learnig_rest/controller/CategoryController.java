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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import it.iagica.learnig_rest.entity.Article;
import it.iagica.learnig_rest.entity.Category;
import it.iagica.learnig_rest.repository.ArticleRepository;
import it.iagica.learnig_rest.repository.CategoryRepository;
import it.iagica.learnig_rest.service.ArticleService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



@RestController
@RequestMapping("/api/category")

public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;	
	
	// lista categorie
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public  Iterable getAllCategories() {
		
		return categoryRepository.findAll();
		
	}
	
	// categorie {id}
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable Long id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		
		return category;
	}

	
	// categorie {id}
	@RequestMapping(value="", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity createCategory(@RequestBody Category category , HttpServletResponse response) {
			
		Category newCategory = categoryRepository.save(category);
			
		return new ResponseEntity(newCategory, HttpStatus.CREATED);		
	}
		
	
	//aggiunge categoria
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Category> addCategory(@RequestBody Category category , HttpServletResponse response) {
	
		categoryRepository.save(category);
		
		return new ResponseEntity("ok", HttpStatus.CREATED);		
				
	}
	
	
	//aggiornamento con json
	@PutMapping("/{id}")// update
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
				
		Category catOld = categoryRepository.findById(id).get();
		
		catOld.setName(category.getName());		 
       
         categoryRepository.save(catOld);
         
         return new ResponseEntity<Category>(categoryRepository.save(category), HttpStatus.OK);	
		
	}
	
	// cancellazione con json
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity deleteCategory(@PathVariable Long id , HttpServletResponse response) {
						
		categoryRepository.deleteById(id);
		
		return new ResponseEntity("ok", HttpStatus.OK);		
				
	}
	
	@RequestMapping(value = "/csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "categories.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setHeader(headerKey, headerValue);
 
        List<Category> listCategory = (List<Category>) categoryRepository.findAll();        
 
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
  
        String[] header = { "name"};
        
        csvWriter.writeHeader(header);
 
        for (Category article : listCategory) {
            csvWriter.write(article, header);
        }
        
        csvWriter.close();
        
        
    }
	
		

}
