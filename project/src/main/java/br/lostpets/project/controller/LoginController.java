package br.lostpets.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.lostpets.project.domain.Usuario;
import br.lostpets.project.infra.HistoricoAcessoLog;
import br.lostpets.project.infra.SegurancaAplicacao;

@Controller
public class LoginController {

	String[][] acesso = new String[1][3];
	private SegurancaAplicacao seguranca;

	@Autowired
	public LoginController(SegurancaAplicacao seguranca) {
		this.seguranca = seguranca;
	}
	
	@GetMapping("/LostPets")
	public ModelAndView openLogin(Usuario usuario) {
		//model.addAttribute(new Usuario(is., null)); 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(usuario);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("/Dashboard")
	public ModelAndView logar(@Valid Usuario usuario, BindingResult bindingResult  /*@ModelAttribute Usuario credenciaisAcesso*/ ) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("login");
		}
		else if(seguranca.permitirAcesso(usuario)){
			modelAndView.setViewName("principalPage");
		}
		return modelAndView;
	}
	
	public void dataHora(Usuario credenciaisAcesso) {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		acesso[0][0] = credenciaisAcesso.getEmail();
		acesso[0][1] = data;
		acesso[0][2] = hora;
		new HistoricoAcessoLog().escreverLog(acesso);

	}

}
