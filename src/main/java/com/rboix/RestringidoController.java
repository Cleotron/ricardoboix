package com.rboix;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestringidoController {
	@RequestMapping("/restringido/anadircuadro")
	String restringido(ModelMap model) {
		return "restringido";
		
	}
}
