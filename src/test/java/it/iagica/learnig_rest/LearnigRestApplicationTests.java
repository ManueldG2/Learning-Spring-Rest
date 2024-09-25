package it.iagica.learnig_rest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import it.iagica.learnig_rest.LearnigRestApplication;
import it.iagica.learnig_rest.repository.ArticleRepository;
import it.iagica.learnig_rest.repository.CategoryRepository;
import it.iagica.learnig_rest.repository.WareHouseRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest(classes = LearnigRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LearnigRestApplicationTests {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	WareHouseRepository warehouseRepository;	

	@Test
	@Order(1)
	void contextLoads() {
	}
	
    /*
    // inserimento
    @Test
    @Order(2)
    public void testCreateWarehouse() throws Exception {
    	
        // Arrange
        String warehouseJson = "{\"amount\":2,\"position\":\"prova\"}";

        // Act
        ResultActions result = mockMvc.perform(post("http://localhost:8080/api/warehouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(warehouseJson));
       
    }   

    
    @Test
    @Order(3)
    public void testGetWareHouseById() throws Exception {
    	    	
        // Arrange
        long warehouseId = warehouseRepository.selectMax();
        
        System.out.println("pId " + warehouseId);

        // Act
        ResultActions result = mockMvc.perform(get("http://localhost:8080/api/warehouse/join/{id}", warehouseId));

        // Assert
        result.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.id").value(warehouseId))
              .andExpect(jsonPath("$.amount").value(2))
              .andExpect(jsonPath("$.position").value("prova"));
    }    
    
    @Test //aggiornamento
    @Order(4)
    public void testUpdateWareHouse() throws Exception {
        // Arrange
        long id = warehouseRepository.selectMax();
    	//long id = 28L;
        String updatedUserJson = "{\"amount\":34,\"position\":\"test\"}";
        
        // Act
        ResultActions result = mockMvc.perform(put("http://localhost:8080/api/warehouse/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserJson));

        // Assert
        result.andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(id))
              .andExpect(jsonPath("$.amount").value(34))
              .andExpect(jsonPath("$.position").value("test"));
    }
    
    @Test //delete
    @Order(5)
    public void testDeleteUser() throws Exception {
        // Arrange
        long userId = warehouseRepository.selectMax();

        // Act
        ResultActions result = mockMvc.perform(delete("/api/warehouse/{id}", userId));

        // Assert
        result.andExpect(status().isOk());
    }    */
    
    /***************************************************************************************************/
    
   
    
    
    @Test    
    public void testAllWarehouse() throws Exception {
    	
        // create
        String warehouseJson = "{\"amount\":2,\"position\":\"prova\"}";
        ResultActions result = mockMvc.perform(post("http://localhost:8080/api/warehouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(warehouseJson));
       
    
    	    	
        //read
        long warehouseId = warehouseRepository.selectMax();
        
        System.out.println("pId " + warehouseId);

        ResultActions result2 = mockMvc.perform(get("http://localhost:8080/api/warehouse/join/{id}", warehouseId));

        result2.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.id").value(warehouseId))
              .andExpect(jsonPath("$.amount").value(2))
              .andExpect(jsonPath("$.position").value("prova"));
    
        // update
        long id = warehouseRepository.selectMax();
    	//long id = 28L;
        String updatedUserJson = "{\"amount\":34,\"position\":\"test\"}";
        
        ResultActions result3 = mockMvc.perform(put("http://localhost:8080/api/warehouse/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserJson));

        result3.andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(id))
              .andExpect(jsonPath("$.amount").value(34))
              .andExpect(jsonPath("$.position").value("test"));
   
        //delete
        long userId = warehouseRepository.selectMax();

        ResultActions result4 = mockMvc.perform(delete("/api/warehouse/{id}", userId));

        result4.andExpect(status().isOk());
        
    }    
    
    
    

}
