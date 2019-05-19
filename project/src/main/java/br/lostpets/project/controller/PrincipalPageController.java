package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalPageController {
	
	@RequestMapping("/Dashboard")
	public ModelAndView logado() {
		return new ModelAndView("principalPage");
	}
	
}
