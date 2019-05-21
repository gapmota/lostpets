package br.lostpets.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.service.PetPerdidoService;

@RestController
@RequestMapping("/lostpet/api/petsperdidos")
public class PetPerdidosRestController {

	@Autowired
	PetPerdidoService petPerdidoService;
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<List<PetPerdido>> getAllPetsPerdidosActive() {
		List<PetPerdido> listPets = petPerdidoService.getAllPetsPerdidosActive(); 		
		return ResponseEntity.ok(listPets);
	}
	
	@CrossOrigin
	@GetMapping("/{idAnimal}")
	public ResponseEntity<PetPerdido> getAllPetsPerdidosActiveById(@PathVariable("idAnimal") int idAnimal) {
		PetPerdido listPets = petPerdidoService.getAllPetsPerdidosActiveById(idAnimal); 		
		return ResponseEntity.ok(listPets);
	}
}
