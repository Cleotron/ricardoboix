package com.rboix;

import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class FotoController {
	private JdbcTemplate jdbcTemplate;

	public FotoController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@ResponseBody
	@RequestMapping(value = "/foto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] showFile(@PathVariable int id) {
		return jdbcTemplate.queryForObject("select foto from fotos where id = ?", new byte[] {}.getClass(), id);
	}

}
