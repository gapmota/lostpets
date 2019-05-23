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

@Controller
public class CadastroPessoaController {

	@Autowired
	private UsuarioService usuarioService;
	private ModelAndView modelAndView = new ModelAndView();

	@GetMapping("/LostPets/Cadastro")
	public ModelAndView cadastroPage() {
		Usuario usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("cadastroPessoa");
		return modelAndView;
	}

	@PostMapping("/LostPets/Cadastro")
	public ModelAndView cadastrar(@RequestParam(value = "files") MultipartFile[] files, @Valid Usuario usuario,
			BindingResult bindingResult) throws IOException, GeneralSecurityException {

		boolean existe = usuarioService.verificarEmail(usuario.getEmail());

		if (bindingResult.hasErrors()) {
			try {
				modelAndView.setViewName("cadastroPessoa");
			} catch (Exception ex) {
				System.err.println("EX: "+ex);
			}
		} else if (existe) {
			modelAndView.addObject("mensagemSucesso", "E-mail já cadastrado!");
			modelAndView.setViewName("cadastroPessoa");
		} else {
			System.out.println("SALVEEE");
			usuarioService.salvarUsuario(usuario);
			Usuario usuarioParaAtualizar = usuarioService.encontrar(usuario.getIdPessoa());

			//comentado devido a falhar ao não inserir imagem
			/*for (MultipartFile file : files) {
				usuarioParaAtualizar.setIdImagem(GoogleDriveConfig.uploadFile(GoogleDriveConfig.convert(file), GoogleDriveConfig.getService()));
			}*/

			usuarioService.salvarUsuario(usuarioParaAtualizar);

			modelAndView = new ModelAndView("redirect:/LostPets");
			modelAndView.addObject("mensagem", "Usuário cadastrado com sucesso!");
		}
		return modelAndView;
	}
}
