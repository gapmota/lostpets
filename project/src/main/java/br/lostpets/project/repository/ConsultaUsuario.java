package br.lostpets.project.repository;

import org.springframework.stereotype.Repository;

import br.lostpets.project.domain.Credenciais;

@Repository
public class ConsultaUsuario {

	public boolean contemUsuario(Credenciais credenciais) {
		
		if("guilherme.mota".equalsIgnoreCase(credenciais.getLogin()) && "guilherme.mota".equalsIgnoreCase(credenciais.getSenha())) {
			return true;
		}
		else if("gustavo.prince".equalsIgnoreCase(credenciais.getLogin()) && "gustavo.prince".equalsIgnoreCase(credenciais.getSenha())) {
			return true;
		}
		else if("juvencio.jose".equalsIgnoreCase(credenciais.getLogin()) && "juvencio.jose".equalsIgnoreCase(credenciais.getSenha())) {
			return true;
		}
		else if("mateus.covos".equalsIgnoreCase(credenciais.getLogin()) && "mateus.covos".equalsIgnoreCase(credenciais.getSenha())) {
			return true;
		}
		else if("natanael.weslley".equalsIgnoreCase(credenciais.getLogin()) && "natanael.weslley".equalsIgnoreCase(credenciais.getSenha())) {
			return true;
		}
		else {
			return false;
		}	
		
	
	}
	
}
