package br.com.jesus.jonathan.backendalurachallange;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendAluraChallangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAluraChallangeApplication.class, args);
	}
	
	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }

}
