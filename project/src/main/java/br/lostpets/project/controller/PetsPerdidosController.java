package br.lostpets.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;

@Controller
public class PetsPerdidosController {

	@GetMapping("/lost/{idAnimal}")
	public ModelAndView getAnimaisPerdidos() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("animalPerfil");		
		return modelAndView;
	}
	
}
