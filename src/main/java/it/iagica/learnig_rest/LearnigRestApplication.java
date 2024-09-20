package it.iagica.learnig_rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;



//indico i package da usare
@ConfigurationPropertiesScan({ "it.iagica.learning_rest", "it.iagica.learning_rest.entity", "it.iagica.learning_rest.service","it.iagica.learning_rest.repository","it.iagica.learning_rest.dto" })

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})

@SpringBootApplication
public class LearnigRestApplication {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnigRestApplication.class, args);
	}

}
