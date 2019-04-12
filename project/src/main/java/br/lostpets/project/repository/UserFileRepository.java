package br.lostpets.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.lostpets.project.domain.UserFiles;

@Repository
public interface UserFileRepository extends CrudRepository<UserFiles, Long> {

}
