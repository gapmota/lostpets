package br.lostpets.project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.Usuario;

@Service
public class SessionService {

	private final static String SESSION_USUARIO = "objUsuario";
	
	@Autowired
	private HttpSession session;
	
	public void setSessionUsuario(Usuario usuario) {
		this.session.setAttribute(SESSION_USUARIO, usuario);		
	}
	
	public boolean existsSessionUsuario() {
		Object obj = this.session.getAttribute(SESSION_USUARIO);
		return obj != null;
	}
	
	public Usuario getUsuarioSession() {
		if(!this.existsSessionUsuario()) { return null;}		
		Usuario usuario = (Usuario)this.session.getAttribute(SESSION_USUARIO);
		return usuario;
	}
	
}
