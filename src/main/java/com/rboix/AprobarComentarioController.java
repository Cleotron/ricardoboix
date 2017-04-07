package com.rboix;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AprobarComentarioController {
	private JdbcTemplate jdbcTemplate;

	public AprobarComentarioController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	

	@RequestMapping("/aprobar")
	public String aprobar (String[] comentarios){
		for(int i = 0; i < comentarios.length; i++){
			jdbcTemplate.update("update comentarios set aprobado = true where id = ?",  comentarios[i]);
		}
		return "redirect:/librodevisitas";
	}
}
