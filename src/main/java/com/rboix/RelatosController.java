package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class RelatosController {
	private JdbcTemplate jdbcTemplate;

	public RelatosController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@RequestMapping("/relatos")
	String relatos(ModelMap model){
		model.addAttribute("relatos",
				jdbcTemplate.queryForList("select * from relatos order by titulo asc"));
		return "relatos";
	}
	@RequestMapping("/relatos/{titulo}")
	String textoPoesia (ModelMap model, @PathVariable String titulo){
		
		model.addAttribute("relato",
				jdbcTemplate.queryForMap("select* from relatos where titulo= ?",
						titulo));
	return "textoRelato";
	}
}
