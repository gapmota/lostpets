package br.lostpets.project.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;

@Transactional
//@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class PetPerdidoRepositoryTest {

	@Autowired
	private PetPerdidoRepository petPerdidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private PetPerdido petPerdido;
	private Usuario usuario;
	
	
	@Before
	public void init() {
		usuario = new Usuario("mateus", "mateus@lost.com");
		usuarioRepository.save(usuario);
		
		petPerdido = new PetPerdido(usuario.getIdPessoa(), 0, "tobias", new Date(), 'S', "perdido", "Gato", "C://", "0000000", "-1", "-1",new Date());
		petPerdidoRepository.save(petPerdido);
	}
	
	@Test
	public void cadastrarPetPerdido() {
		PetPerdido pet = petPerdidoRepository.getOne(petPerdido.getIdAnimal());
		assertEquals(petPerdido, pet);
	}
	
	@Test
	public void getAnimalPorId() {
		PetPerdido pet = petPerdidoRepository.getAtivosByIdAnimal(petPerdido.getIdAnimal());
		assertEquals(petPerdido, pet);
	}
	
	@Test
	public void pegarTodosPetPerdido() {
		List<PetPerdido> list = petPerdidoRepository.findAll();
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void pegarTodosPetPerdidoAtivo() {
		List<PetPerdido> list = petPerdidoRepository.getAtivos();
		assertTrue(list.size() > 0);
	}
	
}
