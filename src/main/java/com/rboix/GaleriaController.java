package com.rboix;

import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	@RequestMapping(value = "/foto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] showFile(@PathVariable int id) {
		return jdbcTemplate.queryForObject("select foto from fotos where id = ?", new byte[] {}.getClass(), id);
	}

}
