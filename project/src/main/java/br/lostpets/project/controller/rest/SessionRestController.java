package br.lostpets.project.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.SessionService;

@CrossOrigin
@RestController
@RequestMapping("/session")
public class SessionRestController {

	@Autowired
	private SessionService session;
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarioSession(){
		Usuario usuario = session.getUsuarioSession();
		return ResponseEntity.ok(usuario);
	}
	
}
