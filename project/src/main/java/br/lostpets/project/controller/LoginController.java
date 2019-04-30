package br.lostpets.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.HistoricoAcessoLog;
import br.lostpets.project.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired private UsuarioService usuarioService;
	@Autowired private HistoricoAcessoLog historicoAcessoLog;
	
	//private ConsultaUsuario consultaUsuario;
	private Usuario usuario;
	
	private ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = { "/", "/LostPets"}, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/LostPets")
	public ModelAndView logar(@Valid Usuario usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("login");
		}
		//verificação provisoria de acesso com email e senha sem db
		/*else if(consultaUsuario.contemUsuario(usuario)) {
			historicoAcessoLog.dataHora(usuario);
			modelAndView.setViewName("principalPage");
		}*/
		else if(usuarioService.emailSenha(usuario) != null) {
			historicoAcessoLog.dataHora(usuario);
			modelAndView.setViewName("principalPage");
		}
		else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}	

}
