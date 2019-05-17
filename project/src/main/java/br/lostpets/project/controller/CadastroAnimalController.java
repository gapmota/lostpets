package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.lostpets.project.model.CadastroPessoaAnimalComponent;

@Controller
public class CadastroAnimalController {

	private CadastroPessoaAnimalComponent cadastroPessoaAnimal;
	
	@RequestMapping("/LostPets/CadastroAnimalPerdido")
	public String cadastroAnimalPerdido() {
		return "cadastroAnimalPerdido";
	}
	
}
