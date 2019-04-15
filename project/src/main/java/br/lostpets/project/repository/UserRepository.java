package br.lostpets.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.lostpets.project.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
	
}
