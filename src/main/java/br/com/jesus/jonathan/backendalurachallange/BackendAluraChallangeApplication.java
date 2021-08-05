package br.com.jesus.jonathan.backendalurachallange;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendAluraChallangeApplication {
	
	@Value("${front.uri}")
	private String FRONT_URI;

	public static void main(String[] args) {
		SpringApplication.run(BackendAluraChallangeApplication.class, args);
	}
	
	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }
	 
	 @Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/*").allowedOrigins(FRONT_URI);
				}
			};
		}

}
