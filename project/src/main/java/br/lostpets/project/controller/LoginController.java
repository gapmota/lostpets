package br.lostpets.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;
import br.lostpets.project.service.PetPerdidoService;
import br.lostpets.project.service.SessionService;
import br.lostpets.project.service.UsuarioService;
import br.lostpets.project.utils.HistoricoAcessoLog;

@Controller
public class LoginController {

	@Autowired
	private PetPerdidoService petPerdidoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private HistoricoAcessoLog historicoAcessoLog;
	@Autowired
	private SessionService session;
	
	private Usuario usuario;
	private ModelAndView modelAndView;
	private boolean msn = false; 	
	
	@RequestMapping(value = { "/", "/LostPets" }, method = RequestMethod.GET)
	public String loginPage(Usuario usuario, Model model) {
		
		List<PetPerdido> pets;		
		pets = petPerdidoService.encontrarPetsAtivos();
		model.addAttribute("fotoAnimais", pets);
		
		if (session.existsSessionUsuario()) {
			historicoAcessoLog.dataHora(usuario.getNome());
			return "redirect:/Dashboard";
			
		} else {
			String mensagem;
			mensagem = msn ? "<span class=\"COLOCAR MATERIALIZE\">Email ou senha Incorretos</span>": "";
			
			model.addAttribute("mensagem", mensagem);
			return "login";	
		}		
	}

	@PostMapping("/LostPets")
	public ModelAndView logar(@Valid Usuario usuario) {
		
		usuario = usuarioService.emailSenha(usuario.getEmail(), usuario.getSenha());
		if (usuario != null) {
			modelAndView = new ModelAndView("redirect:/Dashboard");
			historicoAcessoLog.dataHora(usuario.getNome());
			session.setSessionUsuario(usuario);
			
		} else {
			modelAndView = new ModelAndView("redirect:/LostPets");
			msn = true;
		}
		return modelAndView;
	}

	@GetMapping("/logoff")
	public ModelAndView logoff() {
		session.setSessionUsuario(null);
		modelAndView = new ModelAndView();
		usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("redirect:/LostPets");
		return modelAndView;
	}

}
