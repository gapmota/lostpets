package br.lostpets.findpet.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.findpet.model.AnimaisAchados;
import br.lostpets.findpet.service.AnimaisAchadosService;
import br.lostpets.findpet.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/animaisAchados")
public class AnimaisAchadosRestController {

	@Autowired
	private AnimaisAchadosService animaisAchadosService;
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<AnimaisAchados>> getByUsuario(@PathVariable("id") Integer idUsuario) {
		List<AnimaisAchados> list = animaisAchadosService.getByUsuario(idUsuario);
		return ResponseEntity.ok(list);
	}

	@GetMapping
	public ResponseEntity<List<AnimaisAchados>> getAllActive() {
		List<AnimaisAchados> list = animaisAchadosService.getAllActive();
		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<String> acharAnimal(@RequestBody AnimaisAchados animal) {
		String response = animaisAchadosService.acharAnimal(animal);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/confirmar/{id}/{confirma}")
	public ResponseEntity<String> acharPetPerdido(@PathVariable("confirma") int confirma, @PathVariable("id") UUID id) {
		if(confirma == 0) {  
			emailService.sendFind(id, false);
			return ResponseEntity.ok("animal não achado. por favor feche essa aba."); 
		}
		AnimaisAchados animal = animaisAchadosService.getAnimalById(id);
		AnimaisAchados animalConfirmado = animaisAchadosService.confirmarAnimalAchado(animal);
		if(animalConfirmado == null) { return ResponseEntity.ok("Ocorreu um erro. por favor feche essa aba."); }
		return ResponseEntity.ok("O Animal foi marcado como achado :D. por favor feche essa aba.");
	}
}
