package br.lostpets.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.lostpets.project.domain.Credenciais;
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
	public String openLogin(Model model) {
		model.addAttribute(new Credenciais(null, null));
		return "loginPage";
	}

	@PostMapping("/LostPets")
	public String logar(@ModelAttribute Credenciais credenciais) {

		if (seguranca.permitirAcesso(credenciais)) {
			dataHora(credenciais);
			return "redirect:/Dashboard";
		} else {
			return "loginPage";
		}

	}

	public void dataHora(Credenciais credenciais) {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		acesso[0][0] = credenciais.getLogin();
		acesso[0][1] = data;
		acesso[0][2] = hora;
		new HistoricoAcessoLog().escreverLog(acesso);

	}

}
