package it.iagica.learnig_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.iagica.learnig_rest.ProductRepository;
import it.iagica.learnig_rest.entity.Product;



@RestController

public class ProductController {
	
	@Autowired
	ProductRepository productRepository;


	// endpoint di test
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	    
	}
	
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public  Iterable getAllProduct() {
		
		return productRepository.findAll();
		
	}

}
