package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoesiaController {

	private JdbcTemplate jdbcTemplate;

	public PoesiaController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@RequestMapping("/poesias")
	String poesias(ModelMap model){
		model.addAttribute("poemas",
				jdbcTemplate.queryForList("select * from poemas order by titulo asc"));
		return "poesias";
	}
	@RequestMapping("/poesias/{titulo}")
	String textoPoesia (ModelMap model, @PathVariable String titulo){
		
		model.addAttribute("poema",
				jdbcTemplate.queryForMap("select* from poemas where titulo= ?",
						titulo));
	return "textoPoesia";
	}

	
}
