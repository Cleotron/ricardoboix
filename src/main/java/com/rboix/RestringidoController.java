package com.rboix;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestringidoController {
	private JdbcTemplate jdbcTemplate;

	public RestringidoController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@RequestMapping("/restringido/anadircuadro")
	String anadirCuadro(ModelMap model) {
		return "anadirCuadro";
		
	}
	
	@RequestMapping("/restringido/aprobarcomentarios")
	String aprobarComentarios(ModelMap model) {
		model.addAttribute("comentarios",
				jdbcTemplate.queryForList("select * from comentarios where not aprobado"));
		return "aprobarComentarios";
		
	}
}
