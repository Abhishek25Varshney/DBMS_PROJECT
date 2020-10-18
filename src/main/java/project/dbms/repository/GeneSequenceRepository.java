package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.GeneSequence;

public interface GeneSequenceRepository extends CrudRepository<GeneSequence, Integer> {

}