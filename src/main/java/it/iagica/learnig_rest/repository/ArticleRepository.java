package it.iagica.learnig_rest.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.Article;




public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	/*@Query(value = "SELECT c.*, o.*, p.* "
			  + " from Customer c, CustomerOrder o ,Product p "
			  + " where c.id=o.customer_id "
			  + " and o.id=p.customerOrder_id "
			  + " and c.id=?1 "
			  , nativeQuery = true)
			List<Map<String, Object>> findByCustomer(Long id);*/
	
	
	@Query(value = "SELECT article.title, article.description, article.characteristic, article.category, article.category, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article JOIN warehouse ON article.warehouse_id = warehouse.id " , nativeQuery = true)
	List<Map<String,Object>> selectJoin();
	
	@Query(value = "SELECT article.title, article.description, article.characteristic, article.category, article.category, article.unity ,article.code ,article.price , warehouse.position, article.quantity as quantita_per_pacchetto, warehouse.amount as quantita_totale,(article.price * article.quantity) as cost_per_package  FROM article JOIN warehouse ON article.warehouse_id = warehouse.id AND article.id=%?1%", nativeQuery = true )
	List<Map<String,Object>> selectJoinById(Long id);
	
	
}
