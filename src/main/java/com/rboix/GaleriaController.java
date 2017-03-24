package com.rboix;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class GaleriaController {
	private JdbcTemplate jdbcTemplate;

	public GaleriaController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@RequestMapping("/galeria")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("ids", jdbcTemplate.queryForList("select id from fotos", Integer.class));
		return "galeria";
	}


}
