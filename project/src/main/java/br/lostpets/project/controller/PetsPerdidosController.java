package br.lostpets.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.domain.PetPerdido;

@RestController
public class PetsPerdidosController {

	@RequestMapping("/animaisperdidos")
	public PetPerdido getAnimaisPerdidos() {
		
		//ira retornar json contendo todos animais perdidos;
		//return new PetPerdido(41.40338, 2.17403, "ChuchuBeleza");
		
		return null;
	}
	
}
