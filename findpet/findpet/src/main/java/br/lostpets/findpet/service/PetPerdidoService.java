package br.lostpets.findpet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.findpet.model.PetPerdido;
import br.lostpets.findpet.repository.PetPerdidoRepository;

@Service
public class PetPerdidoService {

	@Autowired
	PetPerdidoRepository petPerdidoRepository;
	
	public PetPerdido encontrarUnicoPet(int id) {
		return petPerdidoRepository.getAtivosByIdAnimal(id);
	}

	public void salvarPet(PetPerdido petPerdido) {
		petPerdidoRepository.save(petPerdido);
	}
	
}
