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

	public boolean emailSenha(Usuario usuario) {
		return usuarioRepository.validarAcesso(usuario.getEmail(), usuario.getSenha());
	}
	
	/*
	public void delete(Long id) {
		usuarioRepository.delete(id);
	}
	*/
	
}
