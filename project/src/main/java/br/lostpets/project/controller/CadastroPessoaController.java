package br.lostpets.project.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.UsuarioService;
import br.lostpets.project.utils.GoogleDriveConfig;

@Controller
public class CadastroPessoaController {

	@Autowired
	private UsuarioService usuarioService;
	private ModelAndView modelAndView = new ModelAndView();

	private Usuario usuario;
	
	@Autowired
	private LoginController login;
	
	@GetMapping("/LostPets/Cadastro")
	public ModelAndView cadastroPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}

	@PostMapping("/LostPets/Cadastro")
	public ModelAndView cadastrar(@RequestParam(value = "files") MultipartFile[] files, @Valid Usuario usuario,
			BindingResult bindingResult) throws IOException, GeneralSecurityException  {

		Usuario usuario2 = usuarioService.verificarEmailUsuario(usuario.getEmail());
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cadastroPessoa");			
		} 
		else if (usuarioService.verificarEmail(usuario.getEmail())) {
			modelAndView.addObject("mensagemSucesso", "E-mail já cadastrado!");
			modelAndView.setViewName("cadastroPessoa");
		} 
		else {
			if(usuario2 == null) {
				
				for (MultipartFile file : files) {
					if(!file.isEmpty())
						usuario.setIdImagem("https://drive.google.com/uc?id="+GoogleDriveConfig.uploadFile(file));
				}
				
				usuarioService.salvarUsuario(usuario); 
				return login.logar(usuario);
			}
			else {
				
				for (MultipartFile file : files) {
					if(!file.isEmpty())
						usuario.setIdImagem("https://drive.google.com/uc?id="+GoogleDriveConfig.uploadFile(file));
				}
				
				usuario2.setBairro(usuario.getBairro());
				usuario2.setCep(usuario.getCep());
				usuario2.setCidade(usuario.getCidade());
				usuario2.setRua(usuario.getRua());
				usuario2.setUf(usuario.getSenha());
				usuario2.setSenha(usuario.getSenha());
				usuarioService.salvarUsuario(usuario2);
			}
			
			
			
		}
		return modelAndView;
	}
}
