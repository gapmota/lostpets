package br.lostpets.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin
	@GetMapping("/pontos/{id}")
	public ResponseEntity<Integer> getTotalPontos(@PathVariable("id") Integer idUsuario) {
		Integer total = usuarioService.totalPontosUsuario(idUsuario);
		return ResponseEntity.ok(total);
	}
	
}
