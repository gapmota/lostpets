package br.lostpets.project.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lostpets.project.controller.Credenciais;
import br.lostpets.project.repository.ConsultaUsuario;

@Component
public class SegurancaAplicacao {

	private final ConsultaUsuario usuario;
	
	@Autowired
	public SegurancaAplicacao(ConsultaUsuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean permitirAcesso(Credenciais credenciais) {
		boolean usuarioExiste = usuario.contemUsuario(credenciais);
	 
		return usuarioExiste;
	}
	
}
