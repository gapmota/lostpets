package br.lostpets.project.repository;

import org.springframework.stereotype.Repository;

import br.lostpets.project.domain.Usuario;

@Repository
public class ConsultaUsuario {

	public boolean contemUsuario(Usuario credencialAcesso) {
		
		if("guilherme.mota".equalsIgnoreCase(credencialAcesso.getEmail()) && "guilherme.mota".equalsIgnoreCase(credencialAcesso.getSenha())) {
			return true;
		}
		else if("gustavo.prince".equalsIgnoreCase(credencialAcesso.getEmail()) && "gustavo.prince".equalsIgnoreCase(credencialAcesso.getSenha())) {
			return true;
		}
		else if("juvencio.jose".equalsIgnoreCase(credencialAcesso.getEmail()) && "juvencio.jose".equalsIgnoreCase(credencialAcesso.getSenha())) {
			return true;
		}
		else if("mateus.covos".equalsIgnoreCase(credencialAcesso.getEmail()) && "mateus.covos".equalsIgnoreCase(credencialAcesso.getSenha())) {
			return true;
		}
		else if("natanael.weslley".equalsIgnoreCase(credencialAcesso.getEmail()) && "natanael.weslley".equalsIgnoreCase(credencialAcesso.getSenha())) {
			return true;
		}
		else {
			return false;
		}	
		
	
	}
	
}
