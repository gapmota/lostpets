package br.lostpets.project.repository;

import org.springframework.stereotype.Repository;

import br.lostpets.project.model.Usuario;

@Repository
public class ConsultaUsuario {

	//Para fins de funcionamento momentanel esta sendo utilizado para login if de verificar se email e senha são compativeis
	
	public boolean contemUsuario(Usuario usuario) {
		
		if("guilherme.mota".equalsIgnoreCase(usuario.getEmail()) && "guilherme.mota".equalsIgnoreCase(usuario.getSenha())) {
			return true;
		}
		else if("gustavo.prince".equalsIgnoreCase(usuario.getEmail()) && "gustavo.prince".equalsIgnoreCase(usuario.getSenha())) {
			return true;
		}
		else if("juvencio.jose".equalsIgnoreCase(usuario.getEmail()) && "juvencio.jose".equalsIgnoreCase(usuario.getSenha())) {
			return true;
		}
		else if("mateus.covos".equalsIgnoreCase(usuario.getEmail()) && "mateus.covos".equalsIgnoreCase(usuario.getSenha())) {
			return true;
		}
		else if("natanael.weslley".equalsIgnoreCase(usuario.getEmail()) && "natanael.weslley".equalsIgnoreCase(usuario.getSenha())) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	
}
