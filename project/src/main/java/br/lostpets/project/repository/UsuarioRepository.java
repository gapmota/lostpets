package br.lostpets.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.lostpets.project.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("from Usuario where email = ?1")
	public Usuario encontrarEmail(String email);

	@Query("from Usuario where email = ?1 and senha = ?2")
	public Usuario validarAcesso(String email, String senha);

	@Query("from Usuario")
	public List<Usuario> todosUsuario();

	@Query("from Usuario where idPessoa = ?1")
	public Usuario unicoUsuario(int id);

}
