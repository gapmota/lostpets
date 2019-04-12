 package br.lostpets.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.lostpets.project.domain.Usuario;

@Repository
public interface UserRepositoryFile extends CrudRepository<Usuario, Long> {

	
	
}
