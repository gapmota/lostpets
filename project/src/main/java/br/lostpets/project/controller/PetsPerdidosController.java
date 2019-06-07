package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetsPerdidosController {

	@GetMapping("/lost/{idAnimal}")
	public ModelAndView getAnimaisPerdidos() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("animalPerfil");		
		return modelAndView;
	}
	
}
