package br.lostpets.project.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.model.AnimaisAchados;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnimaisAchadosRepositoryTest {

	@Autowired
	private AnimaisAchadosRepository animaisAchadosRepository;
	
	@Autowired
	private PetPerdidoRepository petPerdidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private PetPerdido petPerdido;
	private Usuario usuario;
	private AnimaisAchados achados;
	
	
	@Before
	public void init() {
		usuario = new Usuario("mateus", "mateus@lost.com", "(11) 91234-1234", "(11) 1234-1234");
		usuarioRepository.save(usuario);
		petPerdido = new PetPerdido(usuario,"tobias", "12/12/2018", "Descrição perdido","Gato","C://Path","00.000.000",0,0);
		petPerdidoRepository.save(petPerdido);
		achados = new AnimaisAchados(usuario, petPerdido, new Date(), 10, "latitude", "longitude");
		animaisAchadosRepository.save(achados);
	}
	
	@Test
	public void cadastrarAnimalAchado() {
		AnimaisAchados pet = animaisAchadosRepository.getOne(achados.getId());
		assertEquals(achados, pet);
	}
	
}
