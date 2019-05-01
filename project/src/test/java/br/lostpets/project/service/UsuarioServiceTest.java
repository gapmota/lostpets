package br.lostpets.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.UsuarioRepository;

public class UsuarioServiceTest {

	private Usuario usuario;
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setup() {
		usuario = new Usuario("joao", "joao.joao");
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void usuarioCriado() {
		Usuario mesmoUsuario = usuarioRepository.getOne(usuario.getIdPessoa());
		assertEquals(usuario, mesmoUsuario);
	}
	
}
