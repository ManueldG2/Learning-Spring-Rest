package it.iagica.learnig_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan({ "it.iagica.learning_rest", "it.iagica.learning_rest.entity" })

@SpringBootApplication
public class LearnigRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnigRestApplication.class, args);
	}

}
