package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.repository.PetPerdidoRepository;

@Service

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
}
