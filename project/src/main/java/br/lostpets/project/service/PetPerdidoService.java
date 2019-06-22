package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.PetPerdidoRepository;

@Service
public class PetPerdidoService {

	@Autowired
	private PetPerdidoRepository petPerdidoRepository;

	@Autowired
	private UsuarioService usuarioService;

	public List<PetPerdido> encontrarPetsAtivos() {
		return petPerdidoRepository.getAtivos();
	}

	public PetPerdido encontrarUnicoPet(int id) {
		return petPerdidoRepository.getAtivosByIdAnimal(id);
	}

	public void salvarPet(PetPerdido petPerdido) {
		petPerdidoRepository.save(petPerdido);
	}

	public List<PetPerdido> encontrarTodos() {
		return petPerdidoRepository.findAll();
	}

	public List<PetPerdido> encontrarPetsAtivosNNull() {
		return petPerdidoRepository.getAtivosNNull();
	}

	/*
	 * public List<PetPerdido> encontrarTodosByUsuario(int id) { Usuario usuario =
	 * usuarioService.encontrar(id); if(usuario == null) { return null; } return
	 * petPerdidoRepository.encontrarTodosByUsuario(usuario); }
	 */

}
