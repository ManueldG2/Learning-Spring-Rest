package it.iagica.learnig_rest.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.iagica.learnig_rest.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long>{
	
	// correggere restituisce lista articoli
	@Query(value = " CALL `test-warehouse-all`(); " , nativeQuery = true)
	List<Map<Long,Object>> selectJoin();
		
	// 
	@Query(value = "CALL `warehouse-id`(%?1%); ", nativeQuery = true )
	List<Map<Long,Object>> selectJoinById(Long id);	
	

	@Query(value = "SELECT MAX(id) FROM warehouse;", nativeQuery = true )
	Long selectMax();	
	
}
