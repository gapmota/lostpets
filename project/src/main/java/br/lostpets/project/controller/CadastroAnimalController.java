package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.CadastroPessoaAnimalComponent;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.UsuarioService;

@Controller
public class CadastroAnimalController {

	private UsuarioService usuarioService;
	private CadastroPessoaAnimalComponent cadastroPessoaAnimal;
	private ModelAndView modelAndView = new ModelAndView();
	private PetPerdidoService petPerdidoService;
	
	@GetMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView paginaadastroAnimalPerdido() {
		modelAndView.addObject("form", cadastroPessoaAnimal);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}
	
	@PostMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView cadastroAnimalPerdido(@Valid CadastroPessoaAnimalComponent cadastroPessoaAnimal) {
		
		String email = cadastroPessoaAnimal.getUsuario().getEmail();
		boolean existe = usuarioService.verificarEmail(email);
		
		if(existe) {
				
		}else {
			Usuario usuario = cadastroPessoaAnimal.getUsuario();
			PetPerdido petPerdido1 = cadastroPessoaAnimal.getPetPerdido();
			//petPerdido = new PetPerdido(usuario, nomeAnimal, dataPerdido, descricao, tipoAnimal, pathImg, cep, latitude, longitude)
			usuarioService.salvarUsuario();
			petPerdidoService.salvarPet();
		}
		
		return modelAndView;
	}
	
	
}
