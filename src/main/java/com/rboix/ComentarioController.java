package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComentarioController {
	private JdbcTemplate jdbcTemplate;

	public ComentarioController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@RequestMapping("/comentario")
	String guardarComentario(String nombre,String texto){
		jdbcTemplate.update("insert into comentarios (nombre, texto) values (?,?)", nombre, texto
				);
	return "redirect:/librodevisitas";
	}
}
