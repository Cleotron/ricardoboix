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
	public LibrodevisitasController librodevisitasController(){
		return new LibrodevisitasController(jdbcTemplate);
	}
	
	@Bean 
	public RestringidoController restringidoController(){
		return new RestringidoController(jdbcTemplate);
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
	
	@Bean
	public ComentarioController comentarioController(){
		return new ComentarioController(jdbcTemplate);
	}
	
	@Bean
	public AprobarComentarioController aprobarComentarioController(){
		return new AprobarComentarioController(jdbcTemplate);
	}
	
	@Bean
	public BorrarCuadroController borrarCuadroController(){
		return new BorrarCuadroController(jdbcTemplate);
	}
		
	public static void main(String[] args) {
		SpringApplication.run(RicardoboixApplication.class, args);
	}
}
