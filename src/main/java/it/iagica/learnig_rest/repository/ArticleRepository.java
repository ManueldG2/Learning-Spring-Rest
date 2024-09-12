package it.iagica.learnig_rest.repository;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.Article;




public interface ArticleRepository extends CrudRepository<Article, Long>{
	
	
}
