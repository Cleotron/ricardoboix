package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrarCuadroController {
	private JdbcTemplate jdbcTemplate;
	public BorrarCuadroController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	@RequestMapping("/borrar")
	public String borrar (String[] cuadros){
		for(int i = 0; i < cuadros.length; i++){
			jdbcTemplate.update("delete from fotos where id = ?",  cuadros[i]);
		}
		return "redirect:/galeria";
	}		
}
