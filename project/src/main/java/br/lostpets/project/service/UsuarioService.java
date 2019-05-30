package br.lostpets.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.Usuario;
import br.lostpets.project.repository.AnimaisAchadosRepository;
import br.lostpets.project.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private AnimaisAchadosRepository animaisAchados;
	
	public List<Usuario> encontrarTodos(){
		return usuarioRepository.findAll();
	}
	
	public Usuario encontrar(int id) {
		return usuarioRepository.unicoUsuario(id);
	}
	
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);		
    }

	public Usuario emailSenha(String email, String senha) {
		return usuarioRepository.validarAcesso(email, senha);
	}

	public Usuario verificarEmailUsuario(String email) {
		Usuario usuario = usuarioRepository.encontrarEmail(email);
		return usuario;		
	}
	
	public boolean verificarEmail(String email) {
		Usuario usuario = usuarioRepository.encontrarEmail(email);
		if(usuario != null) {
			return (usuario.getCep() != null) && (usuario.getSenha() != null);
		}
		return false;		
	}
	
	public int totalPontosUsuario(Integer idUsuario) {
		Usuario usuario = usuarioRepository.getOne(idUsuario);
		Integer total = animaisAchados.totalPontosUsuario(usuario);
		if(total == null) { return 0; }
		return total;
	}
	
	/*
	public void delete(Long id) {
		usuarioRepository.delete(id);
	}
	*/
	
}
