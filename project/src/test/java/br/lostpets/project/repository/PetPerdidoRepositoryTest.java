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
@Commit
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
		usuario = new Usuario("mateus", "mateus@lost.com", "(11) 91234-1234", "(11) 1234-1234");
		usuarioRepository.save(usuario);
		petPerdido = new PetPerdido(usuario,"tobias", "12/12/2018", "Descrição perdido","Gato","C://Path","00.000.000","Latitude","Longitude");
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
