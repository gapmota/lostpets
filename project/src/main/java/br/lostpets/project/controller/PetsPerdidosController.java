package br.lostpets.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.domain.PetsPerdidos;

@RestController
public class PetsPerdidosController {

	@RequestMapping("/animaisperdidos")
	public PetsPerdidos getAnimaisPerdidos() {
		return new PetsPerdidos(41.40338, 2.17403, "ChuchuBeleza");
	}
	
}
