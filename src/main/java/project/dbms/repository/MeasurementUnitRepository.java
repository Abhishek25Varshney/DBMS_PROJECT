package project.dbms.repository;

import org.springframework.data.repository.CrudRepository;

import project.dbms.entity.MeasurementUnit;

public interface MeasurementUnitRepository extends CrudRepository<MeasurementUnit, Integer> {

}