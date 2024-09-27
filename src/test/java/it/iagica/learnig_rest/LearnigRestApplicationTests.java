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
	
	@Autowired
	CategoryRepository categoryRepository;	


	@Test
	@Order(1)
	void contextLoads() {
	}    
    
    @Test    
    public void testAllWarehouse() throws Exception {
    	
        // create
        String warehouseJson = "{\"amount\":2,\"position\":\"prova\"}";
        ResultActions resultWH = mockMvc.perform(post("http://localhost:8080/api/warehouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(warehouseJson));
       
    
    	    	
        //read
        long warehouseId = warehouseRepository.selectMax();
        
        System.out.println("pId " + warehouseId);

        ResultActions resultWH2 = mockMvc.perform(get("http://localhost:8080/api/warehouse/join/{id}", warehouseId));

        resultWH2.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.id").value(warehouseId))
              .andExpect(jsonPath("$.amount").value(2))
              .andExpect(jsonPath("$.position").value("prova"));
    
        // update
        String updatedUserJson = "{\"amount\":34,\"position\":\"test\"}";
        
        ResultActions resultWH3 = mockMvc.perform(put("http://localhost:8080/api/warehouse/{id}", warehouseId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserJson));

        resultWH3.andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(warehouseId))
              .andExpect(jsonPath("$.amount").value(34))
              .andExpect(jsonPath("$.position").value("test"));
   
        //delete
        ResultActions resultWH4 = mockMvc.perform(delete("/api/warehouse/{id}", warehouseId));

        resultWH4.andExpect(status().isOk());
        
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
        
        System.out.println(" creo questo articolo" + articleJson);
        
        ResultActions resultA1 = mockMvc.perform(post("http://localhost:8080/api/article")
                									.contentType(MediaType.APPLICATION_JSON)
                									.content(articleJson));
       
    
    	    	
        //read
        long articleId = articleRepository.selectMax();
        
        System.out.println("aId " + articleId);

        ResultActions resultA2 = mockMvc.perform(get("http://localhost:8080/api/article/{id}", articleId));
        
        System.out.println("article id" + articleId);
        
        resultA2.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))             
              .andExpect(jsonPath("$[0].title").value("test"))
              .andExpect(jsonPath("$[0].description").value("test"));
    
        // update
        
        
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
        
        ResultActions resultA3 = mockMvc.perform(put("http://localhost:8080/api/article/{id}", articleId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedArticleJson));

        resultA3.andExpect(status().isOk())             
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
        ResultActions resultA4 = mockMvc.perform(delete("/api/article/{id}", articleId));
        resultA4.andExpect(status().isOk());
        
    }       
    
    @Test    
    public void testAllCategory() throws Exception {
    	
        // create
        String categoryJson = "{\"name\":\"test\"}";
        
        System.out.println(" creo questa categoria" + categoryJson);
        
        ResultActions resultC1 = mockMvc.perform(post("http://localhost:8080/api/category")
                				.contentType(MediaType.APPLICATION_JSON)
                				.content(categoryJson));
       
    
    	    	
        //read
        long categoryId = categoryRepository.selectMax();
        
        System.out.println("category id " + categoryId);

        ResultActions resultC2 = mockMvc.perform(get("http://localhost:8080/api/category/{id}", categoryId));
        
        System.out.println(resultC2.toString());
        
        resultC2.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))             
              .andExpect(jsonPath("$.name").value("test"));
    
        // update           	
        
        String updatedCategoryJson = "{\"name\":\"prova\"}";
        
        ResultActions resultC3 = mockMvc.perform(put("/api/category/{id}", categoryId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedCategoryJson));

        resultC3.andExpect(status().isOk())             
              .andExpect(jsonPath("$.name").value("prova"));
                   
        
        //delete
        ResultActions resultC4 = mockMvc.perform(delete("/api/category/{id}", categoryId));
        resultC4.andExpect(status().isOk());
        
    }       

}
