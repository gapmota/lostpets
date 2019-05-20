package br.lostpets.project.model;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.UsuarioService;

@Transactional
//@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class CadastroPessoaAnimalComponentTest {
	
	@Autowired
	private PetPerdidoService petPerdidoService;
	@Autowired
	private UsuarioService usuarioService;
	
	private CadastroPessoaAnimalComponent cadastroPessoaAnimal;
	private PetPerdido petPerdido;
	private Usuario usuario;
	
	@Before
	public void init() {
		usuario = new Usuario("mateus", "mateus@lost.com", "(11) 91234-1234", "(11) 1234-1234");
		//usuarioService.salvarUsuario(usuario);
		petPerdido = new PetPerdido(usuario,"tobias", "12/12/2018", "Descrição perdido","Gato","C://Path","00.000.000","Latitude","Longitude");
		//petPerdidoService.salvarPet(petPerdido);
	}
	
	@Test
	public void salvarPessoaAnimal() {
		cadastroPessoaAnimal.setUsuario(usuario);
		cadastroPessoaAnimal.setPetPerdido(petPerdido);
		
	}
	
}
