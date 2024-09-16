package it.iagica.learnig_rest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long>{
	
	
	@Query(value = " CALL `warehouse-all`(); " , nativeQuery = true)
	List<Map<String,Object>> selectJoin();
		
	
	@Query(value = "CALL `warehouse-id`(%?1%); ", nativeQuery = true )
	List<Map<String,Object>> selectJoinById(Long id);	
	
	
}
