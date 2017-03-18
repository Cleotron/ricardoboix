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
		return new GaleriaController();
	}

	@Bean
	public RelatosController relatosController(){
		return new RelatosController(jdbcTemplate);
	}
	
	@Bean 
	public CancionesController cancionesController(){
		return new CancionesController();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RicardoboixApplication.class, args);
	}
}
