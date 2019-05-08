package br.lostpets.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.model.PetPerdido;

@RestController
public class PetsPerdidosController {

	@RequestMapping(value = "/animaisperdidos", method = RequestMethod.GET)
	public PetPerdido getAnimaisPerdidos() {
		
		//ira retornar json contendo todos animais perdidos;
		//return new PetPerdido(41.40338, 2.17403, "ChuchuBeleza");
		
		return null;
	}
	
}
