package br.lostpets.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.lostpets.project.infra.SegurancaAplicacao;


@Controller
public class LoginController {

	private SegurancaAplicacao seguranca;
	
	@Autowired
	public LoginController(SegurancaAplicacao seguranca) {
		this.seguranca = seguranca;
	}
	
	@GetMapping("/LostPets")
	public String openLogin(Model model) {
		model.addAttribute(new Credenciais(null, null));
		return "loginPage";
	}
	
	@PostMapping("/LostPets")
	public String logar(@ModelAttribute Credenciais credenciais, ModelMap model) {
		
		if(seguranca.permitirAcesso(credenciais)) {
			System.out.println(dataHora(credenciais));
			model.addAttribute("isTrue", false);
			return "/Dashboard";
		}
		else {
			model.addAttribute("isTrue", true);
			return "loginPage";
		}
		
	}
	
	public String dataHora(Credenciais credenciais) {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		return credenciais.getLogin()+" | "+data+" | "+hora;
		
	}
	
}
