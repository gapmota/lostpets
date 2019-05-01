package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired private UsuarioRepository usuarioRepository;
	
	public List<Usuario> encontrarTodos(){
		return usuarioRepository.todosUsuario();
	}
	
	public Usuario encontrar(Long id) {
		return usuarioRepository.unicoUsuario(id);
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		System.out.println("USUARIO SALVO COM SUCESSO!");
		return usuarioRepository.save(usuario);		
    }

	public Usuario emailSenha(String email, String senha) {
		System.out.println("ATÉ AQUI CHEGOU VALIDAR ACESSO! USUARIO: "+usuarioRepository.validarAcesso(email)+" VALIDA ACESSO");
		//https://www.devmedia.com.br/controlando-o-spring-mvc/26265
		return usuarioRepository.validarAcesso(email);
	}
	
	/*
	public void delete(Long id) {
		usuarioRepository.delete(id);
	}
	*/
	
}
