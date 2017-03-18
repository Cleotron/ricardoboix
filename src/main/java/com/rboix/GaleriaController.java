package com.rboix;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class GaleriaController {
	
	
	@RequestMapping("/galeria")
	String galeria(ModelMap model){
		return "galeria";
	}


}
