package com.rboix;
import java.io.IOException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping("/upload")
	
	public String upload(@RequestParam("foto") MultipartFile foto) throws IOException {
		jdbcTemplate.update("insert into fotos(foto) values (?)", foto.getBytes());
		return "redirect:/restringido/anadircuadro";
	}
	
	@RequestMapping("/restringido/borrarcuadros")
	String borrarCuadros(ModelMap model) {
		model.addAttribute("cuadros",
				jdbcTemplate.queryForList("select * from fotos"));
		return "borrarCuadro";
	}
	
	@RequestMapping("/borrar")
	public String borrar (String[] cuadros){
		for(int i = 0; i < cuadros.length; i++){
			jdbcTemplate.update("delete from fotos where id = ?",  cuadros[i]);
		}
		return "redirect:/galeria";
	}		
	
	@RequestMapping("/restringido/aprobarcomentarios")
	String aprobarComentarios(ModelMap model) {
		model.addAttribute("comentarios",
				jdbcTemplate.queryForList("select * from comentarios where not aprobado"));
		return "aprobarComentarios";
		
	}
	
	@RequestMapping("/aprobar")
	public String aprobar (String[] comentarios){
		for(int i = 0; i < comentarios.length; i++){
			jdbcTemplate.update("update comentarios set aprobado = true where id = ?",  comentarios[i]);
		}
		return "redirect:/librodevisitas";
	}

}
