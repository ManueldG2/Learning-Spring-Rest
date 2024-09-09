package it.iagica.learnig_rest;

import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	

}
