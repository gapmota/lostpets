package br.lostpets.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.lostpets.project.model.PetPerdido;

@Repository
public interface PetPerdidoRepository extends JpaRepository<PetPerdido, Integer>{ 

	@Query("from PetPerdido where status = 'P'")
	public List<PetPerdido> getAtivos();

	@Query("from PetPerdido where status = 'P' and idAnimal = ?1")
	public PetPerdido getAtivosByIdAnimal(int idAnimal);
	
}
