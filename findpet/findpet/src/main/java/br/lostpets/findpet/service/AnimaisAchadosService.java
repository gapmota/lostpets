package br.lostpets.findpet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.findpet.model.AnimaisAchados;
import br.lostpets.findpet.model.PetPerdido;
import br.lostpets.findpet.model.Usuario;
import br.lostpets.findpet.repository.AnimaisAchadosRepository;

@Service
public class AnimaisAchadosService {

	@Autowired
	private AnimaisAchadosRepository animaisRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PetPerdidoService petPerdidoService;
	
	public List<AnimaisAchados> getByUsuario(Integer idUsuario){
		Usuario usuario = usuarioService.encontrar(idUsuario);
		if(usuario != null) {
			return animaisRepository.getAllByUsuario(usuario);
		}
		return null;
	}
	
	public List<AnimaisAchados> getAllActive(){
		return animaisRepository.getActive();
	}
	
	public String acharAnimal(AnimaisAchados animal){		
		String retorno = "";
		Usuario usuario = usuarioService.encontrar(animal.getUsuarioAchou().getIdPessoa());
		PetPerdido petPerdido = petPerdidoService.encontrarUnicoPet(animal.getPetPerdido().getIdAnimal());
		
		animal.setStatus("W");//aguarda a confirmação do dono
		animal.setUsuarioAchou(usuario);	
		animal.setPetPerdido(petPerdido);
		animal.setPontos(0);
		
		animaisRepository.save(animal);
		
		if(petPerdido.getUsuario().getIdPessoa() == animal.getUsuarioAchou().getIdPessoa()) {
			confirmarAnimalAchado(animal);
			retorno = "Seu animal foi encontrado por você mesmo.";
		}else {
			//manda email para o dono pedindo confirmação
			retorno = "Aguardando confirmação do dono do pet.";
		}
		
		return retorno;
	}
	
	public AnimaisAchados confirmarAnimalAchado(AnimaisAchados animal){
		
		AnimaisAchados animalPersistido = animaisRepository.getOne(animal.getId());
		
		Usuario usuario = usuarioService.encontrar(animalPersistido.getUsuarioAchou().getIdPessoa());
		PetPerdido petPerdido = petPerdidoService.encontrarUnicoPet(animalPersistido.getPetPerdido().getIdAnimal());
		
		animalPersistido.setStatus("A");//animal achado
		animalPersistido.setUsuarioAchou(usuario);
		
		if(petPerdido.getStatus() == "P") {
			petPerdido.setStatus("A");
		}else {
			return null;
		}		
		
		if(petPerdido.getUsuario().getIdPessoa() == animalPersistido.getUsuarioAchou().getIdPessoa()) {
			animalPersistido.setPontos(0);
		} else {
			animalPersistido.setPontos(10);
		}
		
		petPerdidoService.salvarPet(petPerdido);
		PetPerdido petPerdidoAtualizado = petPerdidoService.encontrarUnicoPet(petPerdido.getIdAnimal());
		animalPersistido.setPetPerdido(petPerdidoAtualizado);
		AnimaisAchados insert = animaisRepository.save(animalPersistido);
		return insert;
	}
	
}
