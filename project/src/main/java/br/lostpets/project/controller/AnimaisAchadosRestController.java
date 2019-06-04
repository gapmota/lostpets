package br.lostpets.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.model.AnimaisAchados;
import br.lostpets.project.service.AnimaisAchadosService;
@CrossOrigin
@RestController
@RequestMapping("/animaisAchados")
public class AnimaisAchadosRestController {

	@Autowired
	private AnimaisAchadosService animaisAchadosService;
	
	@GetMapping("/byUsuario/{id}")
	public ResponseEntity<List<AnimaisAchados>> getByUsuario(@PathVariable("id") Integer idUsuario){
		List<AnimaisAchados> list = animaisAchadosService.getByUsuario(idUsuario);
		return ResponseEntity.ok(list);		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AnimaisAchados>> getAllActive(){
		List<AnimaisAchados> list = animaisAchadosService.getAllActive();
		return ResponseEntity.ok(list);		
	}
	
	@PostMapping("/")
	public ResponseEntity<String> acharAnimal(@RequestBody AnimaisAchados animal){
		String response = animaisAchadosService.acharAnimal(animal);
		return ResponseEntity.ok(response);
	}
	
}
