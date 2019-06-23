package br.lostpets.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.service.SessionService;

@Controller
public class PrincipalPageController {
	
	@Autowired
	SessionService session;
	
	@GetMapping("/Dashboard")
	public ModelAndView logado() {
		if(session.existsSessionUsuario()) {	
			return new ModelAndView("principalPage");
		}else {
			return new ModelAndView("redirect:/LostPets");
		}
	}
	
	@GetMapping("/perfil/{id}")
	public String abrirPerfilUsuario() {
		return "usuarioPerfil";
	}
	
}
