package br.lostpets.project.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.UsuarioService;

@Transactional
//@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class PetPerdidoRepositoryTest {

	@Autowired
	private PetPerdidoService petPerdidoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private PetPerdido petPerdido;
	private Usuario usuario;
	
	
	@Before
	public void init() {
		usuario = new Usuario("mateus", "mateus@lost.com", "(11) 91234-1234", "(11) 1234-1234");
		usuarioService.salvarUsuario(usuario);
		petPerdido = new PetPerdido(usuario,"tobias", "12/12/2018", "Descrição perdido","Gato","C://Path","00.000.000","Latitude","Longitude");
		petPerdidoService.salvarPet(petPerdido);
	}
	
	@Test
	public void getAnimalPorId() {
		PetPerdido pet = petPerdidoService.encontrarUnicoPet(petPerdido.getIdAnimal());
		assertEquals(petPerdido, pet);
	}
	
	@Test
	public void pegarTodosPetPerdido() {
		List<PetPerdido> list = petPerdidoService.encontrarTodos();
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void pegarTodosPetPerdidoAtivo() {
		List<PetPerdido> list = petPerdidoService.encontrarPetsAtivos();
		assertTrue(list.size() > 0);
	}
	
}
