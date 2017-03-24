package com.rboix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication //configuracion


public class RicardoboixApplication {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}

	@Bean
	public PoesiaController poesiaController() {
		return new PoesiaController(jdbcTemplate);
	}
	
	@Bean
	public GaleriaController galeriaController(){
		return new GaleriaController(jdbcTemplate);
	}

	@Bean
	public RelatosController relatosController(){
		return new RelatosController(jdbcTemplate);
	}
	
	@Bean 
	public CancionesController cancionesController(){
		return new CancionesController();
	}
	
	@Bean 
	public RestringidoController restringidoController(){
		return new RestringidoController();
	}
	@Bean
	public LoginController loginController(){
		return new LoginController();
	}
	
	@Bean
	public UploadController uploadController(){
		return new UploadController(jdbcTemplate);
	}
	
	@Bean
	public FotoController fotoController(){
		return new FotoController(jdbcTemplate);
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(RicardoboixApplication.class, args);
	}
}
