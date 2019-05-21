package br.lostpets.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.lostpets.project.model.AnimaisAchados;
import br.lostpets.project.model.Usuario;

@Repository
public interface AnimaisAchadosRepository  extends JpaRepository<AnimaisAchados, Integer>{

	@Query("from AnimaisAchados where usuarioAchou = ?1")
	List<AnimaisAchados> getAllByUsuario(Usuario usuario);
	
	@Query("from AnimaisAchados where status = 'A'")
	List<AnimaisAchados> getActive();

	@Query("select sum(pontos) from AnimaisAchados where usuarioAchou = ?1")
	Integer totalPontosUsuario(Usuario usuario);
	
}
