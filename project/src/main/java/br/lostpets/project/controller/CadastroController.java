package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.UsuarioService;

@Controller
public class CadastroController {
	
	@Autowired 
	private UsuarioService usuarioService;
	@Autowired 
	private LoginController loginController;
	 
	private ModelAndView modelAndView = new ModelAndView();
	private Usuario usuario;
		
	@GetMapping("/Cadastro")
	public ModelAndView cadastroPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}
	
	@PostMapping("/salvarUsuario")
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cadastroPessoa");
			return modelAndView;
		} else {
			usuarioService.salvarUsuario(usuario);
			modelAndView.addObject("mensagemSucesso", "Usuário cadastrado com sucesso!");
			loginController.logar(usuario, bindingResult);
			modelAndView.setViewName("principalPage");
			return modelAndView;
		}
	}
	
}
