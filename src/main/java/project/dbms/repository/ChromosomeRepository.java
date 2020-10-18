package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.Chromosome;

public interface ChromosomeRepository extends CrudRepository<Chromosome, Integer> {

}