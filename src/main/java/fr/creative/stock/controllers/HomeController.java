package fr.creative.stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String home() {
		
		return "home/home";
	}
	
	@RequestMapping(value = "/blank")
	public String blank() {
		return "blank/blank";
	}

}
