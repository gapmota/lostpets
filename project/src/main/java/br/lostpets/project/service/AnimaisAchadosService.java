package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.AnimaisAchados;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.AnimaisAchadosRepository;
import br.lostpets.project.repository.PetPerdidoRepository;
import br.lostpets.project.repository.UsuarioRepository;

@Service
public class AnimaisAchadosService {

	@Autowired
	private AnimaisAchadosRepository animaisRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PetPerdidoRepository petPerdidoRepository;
	
	public List<AnimaisAchados> getByUsuario(Integer idUsuario){
		Usuario usuario = usuarioRepository.getOne(idUsuario);
		if(usuario != null) {
			return animaisRepo.getAllByUsuario(usuario);
		}
		return null;
	}
	
	public List<AnimaisAchados> getAllActive(){
		return animaisRepo.getActive();
	}
	
	public AnimaisAchados acharAnimal(AnimaisAchados animal){		
		Usuario usuario = usuarioRepository.getOne(animal.getUsuarioAchou().getIdPessoa());
		PetPerdido petPerdido = petPerdidoRepository.getAtivosByIdAnimal(animal.getPetPerdido().getIdAnimal());
		
		animal.setStatus("W");//aguarda a confirmação do dono
		animal.setUsuarioAchou(usuario);	
		animal.setPetPerdido(petPerdido);
		animal.setPontos(0);
		
		AnimaisAchados insert = animaisRepo.save(animal);
		
		if(petPerdido.getUsuario().getIdPessoa() == animal.getUsuarioAchou().getIdPessoa()) {
			confirmarAnimalAchado(animal);
		}else {
			//manda email para o dono pedindo confirmação
		}
		
		return insert;
	}
	
	public AnimaisAchados confirmarAnimalAchado(AnimaisAchados animal){
		
		AnimaisAchados animalPersistido = animaisRepo.getOne(animal.getId());
		
		Usuario usuario = usuarioRepository.getOne(animalPersistido.getUsuarioAchou().getIdPessoa());
		PetPerdido petPerdido = petPerdidoRepository.getAtivosByIdAnimal(animalPersistido.getPetPerdido().getIdAnimal());
		
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
		
		PetPerdido petPerdidoAtualizado = petPerdidoRepository.save(petPerdido);
		animalPersistido.setPetPerdido(petPerdidoAtualizado);
		AnimaisAchados insert = animaisRepo.save(animalPersistido);
		return insert;
	}	
}
