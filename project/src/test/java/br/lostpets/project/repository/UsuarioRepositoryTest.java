package br.lostpets.project.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.model.Usuario;

@Transactional
//@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {

	@Autowired 
	private UsuarioRepository usuarioRepository;	
	private Usuario usuario;
	
	@Test
	public void permitirUsuario() {
		usuario = new Usuario("nome", "email", "celular", "telefone");
		usuarioRepository.save(usuario);
		
		Usuario usuarioEncontrado = usuarioRepository.getOne(usuario.getIdPessoa());
		assertEquals(usuario, usuarioEncontrado);
	}
	
	@Test
	public void cadastraTodoUsuario() {
		usuario = new Usuario("Nome", "Fixo", "Celular","Email","Senha","Imagem","Cep","Rua","Bairro","Cidade","Uf",0,0);
		usuarioRepository.save(usuario);
		
		Usuario usuarioEmail = usuarioRepository.validarAcesso(usuario.getEmail(), usuario.getSenha());
		
		assertEquals(usuario.getEmail(), usuarioEmail.getEmail());
		assertEquals(usuario.getSenha(), usuarioEmail.getSenha());
	}
	
	
	
}
