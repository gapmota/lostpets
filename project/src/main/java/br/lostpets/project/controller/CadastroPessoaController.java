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

import br.lostpets.project.model.Endereco;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.UsuarioService;
import br.lostpets.project.service.ViaCep;
import br.lostpets.project.utils.GoogleDriveConfig;

@Controller
public class CadastroPessoaController {

	@Autowired
	private UsuarioService usuarioService;
	private ModelAndView modelAndView = new ModelAndView();

	private Usuario usuario;
	
	@GetMapping("/LostPets/Cadastro")
	public ModelAndView cadastroPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}

	@PostMapping("/LostPets/Cadastro")
<<<<<<< HEAD
	public ModelAndView cadastrar(/*@RequestParam(value = "files") MultipartFile[] files,*/ @Valid Usuario usuario,
			BindingResult bindingResult) throws IOException, GeneralSecurityException {
=======
	public ModelAndView cadastrar(@RequestParam(value = "files") MultipartFile[] files, @Valid Usuario usuario,
			BindingResult bindingResult) throws IOException, GeneralSecurityException  {
>>>>>>> origin/develop
			
		boolean existe = usuarioService.verificarEmail(usuario.getEmail());

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cadastroPessoa");
			
		} else if (existe) {
			modelAndView.addObject("mensagemSucesso", "E-mail já cadastrado!");
			modelAndView.setViewName("cadastroPessoa");
		} else {
			
			/*
			for (MultipartFile file : files) {
				if(!file.isEmpty())
					usuario.setIdImagem(GoogleDriveConfig.uploadFile(file));
			}
			*/
			usuarioService.salvarUsuario(usuario);
      
			modelAndView = new ModelAndView("redirect:/LostPets");
			modelAndView.addObject("mensagem", "Usuário cadastrado com sucesso!");
		}
		return modelAndView;
	}
}
