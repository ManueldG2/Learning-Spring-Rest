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
	
	@Autowired
	ArticleRepository articleRepository;	

	@Test
	@Order(1)
	void contextLoads() {
	}
	
   
   
    
    
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
    
    @Test    
    public void testAllArticle() throws Exception {
    	
        // create
        String articleJson = "{\"title\":\"test\", "
        		+ "\"description\":\"test\", "
        		+ "\"characteristic\":\"test\", "
        		+ "\"category\":4,"
        		+ "\"quantity\":10,"
        		+ " \"unity\":\"Pz\","
        		+ " \"code\":\"test\","
        		+ "\"price\":23,"
        		+ "\"warehouseId\":2}";
        
        System.out.println(articleJson);
        
        ResultActions result5 = mockMvc.perform(post("http://localhost:8080/api/article")
                									.contentType(MediaType.APPLICATION_JSON)
                									.content(articleJson));
       
    
    	    	
        //read
        long articleId = articleRepository.selectMax();
        
        System.out.println("aId " + articleId);

        ResultActions result6 = mockMvc.perform(get("http://localhost:8080/api/article/{id}", articleId));
        
        System.out.println("article id" + articleId);
        
        result6.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))             
              .andExpect(jsonPath("$[0].title").value("test"))
              .andExpect(jsonPath("$[0].description").value("test"));
    
        // update
        
        long id = articleRepository.selectMax();
    	//long id = 28L;
        String updatedArticleJson = "{\"title\":\"prova\", "
        		+ "\"description\":\"prova\", "
        		+ "\"characteristic\":\"prova\", "
        		+ "\"category\":4,"
        		+ "\"quantity\":10,"
        		+ " \"unity\":\"Pz\","
        		+ " \"code\":\"xxxx\","
        		+ "\"price\":23,"
        		+ "\"warehouseId\":2}";
        
        ResultActions result7 = mockMvc.perform(put("http://localhost:8080/api/article/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedArticleJson));

        result7.andExpect(status().isOk())             
              .andExpect(jsonPath("$.title").value("prova"))
              .andExpect(jsonPath("$.description").value("prova"))
              .andExpect(jsonPath("$.characteristic").value("prova"))
              .andExpect(jsonPath("$.category").value(4))
              .andExpect(jsonPath("$.quantity").value(10))
              .andExpect(jsonPath("$.unity").value("Pz"))
              .andExpect(jsonPath("$.code").value("xxxx"))
              .andExpect(jsonPath("$.price").value(23))
              .andExpect(jsonPath("$.warehouseId").value(2));
   
        //delete
       

        ResultActions result8 = mockMvc.perform(delete("/api/article/{id}", id));

        result8.andExpect(status().isOk());
        
    }    
    
    
    

}

// "{\"title\":\"prova\", \"description\":\"prova\", \"characteristic\":\"prova\", \"category\":4, \"quantity\":10, \"unity\":\"Pz\",  \"code\":\"xxxx\", \"price\":23, \"warehouse_id\":2}";
