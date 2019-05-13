package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroAnimalController {


	@RequestMapping("/LostPets/Cadastro_Animal_Perdido")
	public String cadastroAnimalPerdido() {
		return "cadastroAnimalPerdido";
	}
	
}
