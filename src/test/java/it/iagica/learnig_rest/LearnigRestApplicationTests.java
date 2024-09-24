package it.iagica.learnig_rest;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest(classes = LearnigRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LearnigRestApplicationTests {
	
	private Long id ;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ArticleRepository articleRepository;	

	@Test
	void contextLoads() {
	}
	

    @Test
    public void testGetArticleById() throws Exception {
    	    	
        // Arrange
        long productId = articleRepository.selectMax();
        System.out.println("pId " + productId);

        // Act
        ResultActions result = mockMvc.perform(get("http://localhost:8080/api/article/{id}", productId));

        // Assert
        result.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$[0]['id']").value(productId))
              .andExpect(jsonPath("$[0]['title']").value("risme carta per fotocopie Buffetti Superior"))
              .andExpect(jsonPath("$[0]['description']").value("Carta multifunzione, utilizzabile in base alle proprie necessità (stampe, fotocopie, fax,...). . Prodotta con cellulosa ECF e in conformità con la norma ISO 9706 (Long Life). Certificata PEFC™"));
    }
    
    
    // inserimento
    @Test
    public void testCreateAndDeleteWarehouse() throws Exception {
    	
        // Arrange
        String articleJson = "{\"amount\":2,\"position\":\"prova\"}";

        // Act
        ResultActions result = mockMvc.perform(post("http://localhost:8080/api/warehouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleJson));
        
        long productId = articleRepository.selectMax();

       String out =  result.andReturn().getResponse().getContentAsString();      
       
       System.out.println( "id:" + out.substring(6, out.indexOf(",\"")));
       
       id = Long.parseLong( out.substring(6, out.indexOf(",\"") ) );
       
      
        // Assert
        //result.andExpect(status().isCreated());
        /*
        ResultActions resultD = mockMvc.perform(delete("/api/warehouse/{id}", productId));

        // Assert
        result.andExpect(status().is2xxSuccessful());*/
        		
              //se mi aspetto un certo header .andExpect(header().string("", "http://localhost/api/users/2"));
    }   

/*
    public void testGetUserById() throws Exception {
        // Arrange
        long productId = 10L;

        // Act
        ResultActions result = mockMvc.perform(get("/api/product/{id}", productId));

        // Assert
        result.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.id").value(productId))
              .andExpect(jsonPath("$.title").value("test"))
              .andExpect(jsonPath("$.description").value("prova"));
    }*/
    
    
    
    
    @Test //aggiornamento
    public void testUpdateWareHouse() throws Exception {
        // Arrange
        //long id = articleRepository.selectMax();
    	long id = 28L;
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
    /*
    @Test //delete
    public void testDeleteUser() throws Exception {
        // Arrange
        long userId = 22L;

        // Act
        ResultActions result = mockMvc.perform(delete("/api/product/{id}", userId));

        // Assert
        result.andExpect(status().isOk());
    }*/

    

}
