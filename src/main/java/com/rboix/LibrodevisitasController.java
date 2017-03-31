package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LibrodevisitasController {
	private JdbcTemplate jdbcTemplate;

	public LibrodevisitasController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@RequestMapping("/librodevisitas")
		String comentarios(ModelMap model){
		model.addAttribute("comentarios",
				jdbcTemplate.queryForList("select * from comentarios"));
			return "librodevisitas";
		}
	

}

