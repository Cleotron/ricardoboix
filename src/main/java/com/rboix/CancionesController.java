package com.rboix;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CancionesController {
	@RequestMapping("/canciones")
		String canciones(ModelMap model){
			return "canciones";
		}
	

}
