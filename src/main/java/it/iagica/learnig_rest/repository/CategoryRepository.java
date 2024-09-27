package it.iagica.learnig_rest.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.Category;
import it.iagica.learnig_rest.entity.WareHouse;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT MAX(id) FROM category;", nativeQuery = true )
	Long selectMax();	

	
}
