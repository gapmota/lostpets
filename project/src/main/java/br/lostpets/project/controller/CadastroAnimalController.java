package br.lostpets.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.components.CadastroPessoaAnimalComponent;
import br.lostpets.project.model.Endereco;
import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.UsuarioService;
import br.lostpets.project.service.ViaCep;

@Controller
public class CadastroAnimalController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PetPerdidoService petPerdidoService;
	private ModelAndView modelAndView = new ModelAndView();
	private Usuario usuario;
	private PetPerdido petPerdido;
	private CadastroPessoaAnimalComponent cadastroPessoaAnimal = new CadastroPessoaAnimalComponent();
	
	private ViaCep viaCep = new ViaCep();
	private Endereco endereco = new Endereco();
	
	@GetMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView PaginaCadastroAnimalPerdido() {
		modelAndView.addObject("pet", cadastroPessoaAnimal);
		modelAndView.setViewName("cadastroAnimalPerdido");
		return modelAndView;
	}
	
	@PostMapping("/LostPets/Cadastro_Animal_Perdido")
	public ModelAndView cadastroAnimalPerdido(@RequestParam(value = "files") MultipartFile[] files, CadastroPessoaAnimalComponent cadastroPessoaAnimal) {
		
		String email = cadastroPessoaAnimal.getUsuario().getEmail();
		usuario = usuarioService.verificarEmailUsuario(email);
		
		if(usuario != null) {
			petPerdido = cadastroPessoaAnimal.getPetPerdido();
			petPerdido.setStatus("P");
			petPerdido.setUsuario(usuario);
			
			String[] cepV = petPerdido.getCep().split("-");
			String cep = cepV[0].concat(cepV[1]);
			endereco = viaCep.buscarCep(cep);
			
			petPerdidoService.salvarPet(petPerdido);
			
		}else {
			usuario = cadastroPessoaAnimal.getUsuario();			
			petPerdido = cadastroPessoaAnimal.getPetPerdido();
			
			String[] cepV = petPerdido.getCep().split("-");
			String cep = cepV[0].concat(cepV[1]);
			endereco = viaCep.buscarCep(cep);
			
			petPerdido.setStatus("P");
			petPerdido.setUsuario(usuario);
			petPerdido.setLatitude(endereco.getLatitude());
			petPerdido.setLongitude(endereco.getLongitude());
			
			usuarioService.salvarUsuario(usuario);
			petPerdidoService.salvarPet(petPerdido);
			
			//comentado devido a falhar ao não inserir imagem
			/*
			petPerdidoAtualizar = petPerdidoService.encontrarTodos(petPerdido.getIdAnimal());
			
			for (MultipartFile file : files) {
				petPerdidoAtualizar.setPathImg(GoogleDriveConfig.uploadFile(GoogleDriveConfig.convert(file), GoogleDriveConfig.getService()));
			}
			
			petPerdidoService.salvarPet(petPerdidoAtualizar);
			*/
			
		}
		
		return new ModelAndView("redirect:/LostPets/Cadastro_Animal_Perdido");
	}
	
	
	
	
	
}
