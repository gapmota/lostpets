package br.lostpets.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@PostMapping("/login")
	public String logar(@ModelAttribute Credenciais credenciais) {
		
		if(seguranca.permitirAcesso(credenciais)) {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
			System.out.println("data: "+data);
			System.out.println("hora: "+hora);
			String log = credenciais.getLogin()+" | "+data+" | "+" | "+hora;
			System.out.println("log: "+log);
			return "paginaPrincipal";
		}
		else return "paginaErro";
		
	}
	
}
