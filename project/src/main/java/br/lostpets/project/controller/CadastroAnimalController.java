package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.CadastroPessoaAnimalComponent;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.UsuarioService;

@Controller
public class CadastroAnimalController {

	private UsuarioService usuarioService;
	private CadastroPessoaAnimalComponent cadastroPessoaAnimal;
	private ModelAndView modelAndView = new ModelAndView();
	private Usuario usuario;
	private PetPerdido petPerdido;
	
	@GetMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView paginaadastroAnimalPerdido() {
		modelAndView.addObject("form", cadastroPessoaAnimal);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}
	
	@PostMapping("/LostPets/Cadastro_Animal_Perdido")
	public void cadastroAnimalPerdido(@Valid CadastroPessoaAnimalComponent cadastroPessoaAnimal) {
		
		String email = cadastroPessoaAnimal.getUsuario().getEmail();
		boolean existe = usuarioService.verificarEmail(email);
		
		if(existe) {
			System.err.println("CHEGOU AQUI");
		}else {
			usuario = cadastroPessoaAnimal.getUsuario();
			petPerdido = cadastroPessoaAnimal.getPetPerdido();
			
			//petPerdido = new PetPerdido(usuario, nomeAnimal, dataPerdido, descricao, tipoAnimal, pathImg, cep, latitude, longitude)
			//usuarioService.salvarUsuario();
			//petPerdidoService.salvarPet();
			
			System.err.print("USUARIO: ");
			System.out.println(usuario.toString());
			System.err.print("PETPERDIDO: ");
			System.out.println(petPerdido.toString());
			System.err.println("CHEGOU AQUI");
		}
		
		//return new ModelAndView("/");
	}
	
	
}
