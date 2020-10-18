package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.ClinicalSample;

public interface ClinicalSampleRepository extends CrudRepository<ClinicalSample, Integer>{
	
}