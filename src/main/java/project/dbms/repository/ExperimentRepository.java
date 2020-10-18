package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.Experiment;

public interface ExperimentRepository extends CrudRepository<Experiment, Integer> {

}