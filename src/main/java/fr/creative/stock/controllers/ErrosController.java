package fr.creative.stock.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/403")
public class ErrosController {
	
	private static final String REFERER="referer";
	
	@RequestMapping(value = "/")
	public String errorPage(Model model,HttpServletRequest request) {
		String lastUrl=request.getHeader(REFERER);
		if(!StringUtils.isEmpty(lastUrl)) {
			model.addAttribute("backUrl", lastUrl);
		}
		
		return "error/403";
	}

}
