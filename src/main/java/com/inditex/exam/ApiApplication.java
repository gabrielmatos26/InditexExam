package com.inditex.exam;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@SpringBootApplication
public class ApiApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

    @Bean
    public ObjectMapper objectMapper() {
    	ObjectMapper mm = new ObjectMapper()
    			   .registerModule(new ParameterNamesModule())
    			   .registerModule(new Jdk8Module())
    			   .registerModule(new JavaTimeModule());
        return mm;
    }
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mm =  new ModelMapper();
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mm;
    }
    
    @PostConstruct
    public void init(){
      // Setting Spring Boot SetTimeZone
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
