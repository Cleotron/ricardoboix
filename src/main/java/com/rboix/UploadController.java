package com.rboix;

import java.io.IOException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private JdbcTemplate jdbcTemplate;

	public UploadController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	@RequestMapping("/upload")
	
	public String upload(@RequestParam("foto") MultipartFile foto) throws IOException {
		jdbcTemplate.update("insert into fotos(foto) values (?)", foto.getBytes());
		return "redirect:/restringido/anadircuadro";
	}
	
}
