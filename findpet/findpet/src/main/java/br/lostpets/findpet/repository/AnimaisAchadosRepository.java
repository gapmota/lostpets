package br.lostpets.findpet.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.lostpets.findpet.model.AnimaisAchados;
import br.lostpets.findpet.model.Usuario;

@Repository
public interface AnimaisAchadosRepository  extends JpaRepository<AnimaisAchados, UUID>{

	@Query("from AnimaisAchados where usuarioAchou = ?1")
	List<AnimaisAchados> getAllByUsuario(Usuario usuario);
	
	@Query("from AnimaisAchados where status = 'A'")
	List<AnimaisAchados> getActive();

	@Query("select sum(pontos) from AnimaisAchados where usuarioAchou = ?1")
	Integer totalPontosUsuario(Usuario usuario);
	
}
