package br.lostpets.project.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lostpets.project.domain.Usuario;
import br.lostpets.project.repository.ConsultaUsuario;

@Component
public class SegurancaAplicacao {

	private final ConsultaUsuario usuario;
	
	@Autowired
	public SegurancaAplicacao(ConsultaUsuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean permitirAcesso(Usuario credenciaisAcesso) {
		boolean usuarioExiste = usuario.contemUsuario(credenciaisAcesso);
	 
		return usuarioExiste;
	}
	
}
