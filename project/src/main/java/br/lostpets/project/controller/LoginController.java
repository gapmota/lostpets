package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	private ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = { "/", "/LostPets"}, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/Dashboard")
	public String logar(@Valid Usuario usuario, BindingResult bindingResult) {
		
		String modelAndView;
		usuario = usuarioService.emailSenha(usuario.getEmail(), usuario.getSenha());
		
		if (bindingResult.hasErrors()) {
			modelAndView = ("redirect:/LostPets");
		}
		else if(usuario != null) {
			modelAndView = ("principalPage");
			historicoAcessoLog.dataHora(usuario.getNome());
		}
		else {
			modelAndView = ("redirect:/LostPets");
		}
		return modelAndView;
	}	

	@GetMapping("/LostPets/Cadastro")
	public ModelAndView cadastroPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}
	
	@RequestMapping("/LostPets/Cadastro_Animal_Perdido")
	public String cadastroAnimalPerdido() {
		return "cadastroAnimalPerdido";
	}
	
}
