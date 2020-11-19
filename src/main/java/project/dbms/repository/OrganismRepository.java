package project.dbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.Organism;

public interface OrganismRepository extends CrudRepository<Organism, Integer> {

	@Query("SELECT organism from Organism organism ORDER BY organism.id DESC")
	public List<Organism> findLastestOrganism();
	
	@Query("SELECT DISTINCT organism.species from Organism organism")
	public List<String> findAllOrganismSpecies();
	
	@Query("SELECT count(organism) from Organism organism where organism.species=?1")
	public int countOrganismOfSpecificSpecies(String species);
	
	@Query("SELECT count(organism) from Organism organism")
	public int countAllOrganism();

}