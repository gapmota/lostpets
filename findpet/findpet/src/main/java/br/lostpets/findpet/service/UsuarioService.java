package br.lostpets.findpet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lostpets.findpet.model.Usuario;
import br.lostpets.findpet.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	public Usuario encontrar(int id) {
		return usuarioRepository.unicoUsuario(id);
	}
	
}
