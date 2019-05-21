package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.repository.PetPerdidoRepository;

@Service
<<<<<<< HEAD

public class PetPerdidoService {

	@Autowired
	PetPerdidoRepository petPerdidoRepository;
	
	public List<PetPerdido> getAllPetsPerdidosActive() {
		List<PetPerdido> listPets = petPerdidoRepository.getAtivos(); 		
		return listPets;
	}
	
	public PetPerdido getAllPetsPerdidosActiveById(int idAnimal) {
		PetPerdido listPets = petPerdidoRepository.getAtivosByIdAnimal(idAnimal); 		
		return listPets;
	}
=======
public class PetPerdidoService {

	@Autowired
	private PetPerdidoRepository petPerdidoRepository;
	
	public List<PetPerdido> encontrarPetsAtivos(){
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
	
>>>>>>> 827659c156082d1c5f124454c99531e351839dc8
}
