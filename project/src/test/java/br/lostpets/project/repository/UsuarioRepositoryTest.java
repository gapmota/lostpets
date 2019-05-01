package br.lostpets.project.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.model.Usuario;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	private Usuario usuario;
	
	@Before
	public void setup() {
		usuario = new Usuario("nome", "email");
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void permitirUsuario() {
		Usuario usuarioEncontrado = usuarioRepository.getOne(usuario.getIdPessoa());
		assertEquals(usuario, usuarioEncontrado);
	}
	
}
