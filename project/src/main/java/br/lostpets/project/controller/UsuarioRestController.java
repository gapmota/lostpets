package br.lostpets.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.model.PontosUsuario;
import br.lostpets.project.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/pontos/{id}")
	public ResponseEntity<Integer> getTotalPontos(@PathVariable("id") Integer idUsuario) {
		Integer total = usuarioService.totalPontosUsuario(idUsuario);
		return ResponseEntity.ok(total);
	}
	
	@GetMapping("/pontos")
	public ResponseEntity<List<PontosUsuario>> getTotalPontosTodosUsuario() {
		List<PontosUsuario> pontosUsuario = usuarioService.totalPontosUsuarioTodosUsuario();
		return ResponseEntity.ok(pontosUsuario);
	}
	
}
