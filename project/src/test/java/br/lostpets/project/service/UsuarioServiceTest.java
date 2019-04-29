package br.lostpets.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.UsuarioRepository;

public class UsuarioServiceTest {

	private Usuario usuario;
	private UsuarioService usuarioService;
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setup() {
		usuario = new Usuario("Joao", "78946123","978456321","joao.joao", "joao", "../path", "13.456-897","rua do joao", "joaos", "joaos", "ja", "4567895", "4789123", "28/04/2019","20/02/2019");
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void usuarioCriado() {
		Usuario mesmoUsuario = usuarioRepository.getOne(usuario.getIdPessoa());
		assertEquals(usuario, mesmoUsuario);
	}
	
}
