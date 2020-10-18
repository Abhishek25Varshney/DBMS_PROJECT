package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.MRNAExpression;

public interface MRNAExpressionRepository extends CrudRepository<MRNAExpression, Integer> {

}