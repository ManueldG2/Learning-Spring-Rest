package it.iagica.learnig_rest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.Article;




public interface ArticleRepository extends JpaRepository<Article, Long>{	
	
	@Query(value = " CALL `article-all`(); " , nativeQuery = true)
	List<Map<Long, Object>> selectJoin();
		
	
	@Query(value = "CALL `article-id`(%?1%); ", nativeQuery = true )
	List<Map<Long,Object>> selectJoinById(Long id);	
	
	@Query(value = "SELECT MAX(id) FROM article;", nativeQuery = true )
	Long selectMax();	
	
}
