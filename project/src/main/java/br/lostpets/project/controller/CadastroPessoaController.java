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
public class CadastroPessoaController {
	
	@Autowired 
	private UsuarioService usuarioService;
	private ModelAndView modelAndView = new ModelAndView();
	
	@GetMapping("/LostPets/Cadastro")
	public ModelAndView cadastroPage() {
		Usuario usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}
	
	@PostMapping("/LostPets/Cadastro")
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult bindingResult){
		boolean existe = usuarioService.verificarEmail(usuario.getEmail());
		System.out.println("boolean existe = usuarioService.verificarEmail(usuario.getEmail());: "+existe);
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cadastroPessoa");
		} 
		else if(existe) {
			modelAndView.addObject("mensagemSucesso", "E-mail já cadastrado!");
			modelAndView.setViewName("cadastroPessoa");
		}
		else {
			usuarioService.salvarUsuario(usuario);
			modelAndView = new ModelAndView("redirect:/LostPets");
			modelAndView.addObject("mensagem", "Usuário cadastrado com sucesso!");
		}
		return modelAndView;
	}
	
}
