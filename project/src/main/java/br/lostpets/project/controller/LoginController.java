package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.HistoricoAcessoLog;
import br.lostpets.project.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired 
	private UsuarioService usuarioService;
	@Autowired
	private HistoricoAcessoLog historicoAcessoLog;
	
	private Usuario usuario;
	private ModelAndView modelAndView;
	
	@RequestMapping(value = { "/", "/LostPets"}, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		modelAndView = new ModelAndView();
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/Dashboard")
	public ModelAndView logar(@Valid Usuario usuario, BindingResult bindingResult) {
		
		usuario = usuarioService.emailSenha(usuario.getEmail(), usuario.getSenha());
		
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("redirect:/LostPets");
		}
		else if(usuario != null) {
			modelAndView.setViewName("principalPage");
			historicoAcessoLog.dataHora(usuario.getNome());
		}
		else {
			modelAndView = new ModelAndView("redirect:/LostPets");
			modelAndView.addObject("mensagem", "E-mail ou senha inválido");
		}
		return modelAndView;
	}	
	
}
