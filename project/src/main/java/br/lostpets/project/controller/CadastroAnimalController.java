package br.lostpets.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.components.CadastroPessoaAnimalComponent;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.UsuarioService;

@Controller
public class CadastroAnimalController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PetPerdidoService petPerdidoService;
	private ModelAndView modelAndView = new ModelAndView();
	private Usuario usuario;
	private PetPerdido petPerdido;
	private CadastroPessoaAnimalComponent cadastroPessoaAnimal = new CadastroPessoaAnimalComponent();
	
	@GetMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView PaginaCadastroAnimalPerdido() {
		modelAndView.addObject("pet", cadastroPessoaAnimal);
		modelAndView.setViewName("cadastroAnimalPerdido");
		return modelAndView;
	}
	
	@PostMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView cadastroAnimalPerdido(CadastroPessoaAnimalComponent cadastroPessoaAnimal) {
		
		String email = cadastroPessoaAnimal.getUsuario().getEmail();
		usuario = usuarioService.verificarEmailUsuario(email);
		
		if(usuario != null) {
			petPerdido = cadastroPessoaAnimal.getPetPerdido();
			petPerdido.setStatus("P");
			petPerdido.setUsuario(usuario);
			
			petPerdidoService.salvarPet(petPerdido);
			
		}else {
			usuario = cadastroPessoaAnimal.getUsuario();
			
			petPerdido = cadastroPessoaAnimal.getPetPerdido();
			petPerdido.setStatus("P");
			petPerdido.setUsuario(usuario);
			
			usuarioService.salvarUsuario(usuario);
			petPerdidoService.salvarPet(petPerdido);
			
		}
		
		return new ModelAndView("redirect:/LostPets/Cadastro_Animal_Perdido");
	}
	
	
	
	
	
}
