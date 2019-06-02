package br.lostpets.findpet.service;

import java.util.List;
import java.util.UUID;

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
	
	@Autowired
	private EmailService emailService;
	
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
		
		animal.setStatus("E");//aguarda a confirmação do dono
		animal.setUsuarioAchou(usuario);	
		animal.setPetPerdido(petPerdido);
		animal.setPontos(0);
		
		animaisRepository.save(animal);
		
		if(petPerdido.getUsuario().getIdPessoa() == animal.getUsuarioAchou().getIdPessoa()) {
			confirmarAnimalAchado(animal);
			retorno = "Seu animal foi encontrado por você mesmo.";
		}else {
			String status = emailService.send(animal.getId());
			
			if(status.equalsIgnoreCase("ok"))
				retorno = "Aguardando confirmação do dono do pet.";
			else
				retorno = "erro ao enviar e-mail para o dono do pet. Tente novamente mais tarde.";
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
			emailService.sendFind(animalPersistido.getId(), true);
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

	public AnimaisAchados getAnimalById(UUID id) {
		return animaisRepository.getOne(id);
	}
	
}
