package project.dbms.service;

import java.util.List;

import project.dbms.vo.ClinicalSampleVO;
import project.dbms.vo.ExperimentVO;
import project.dbms.vo.MeasurementUnitVO;
import project.dbms.vo.OrganismVO;

public interface ProjectService {

	void createOrganism(OrganismVO organismVO);

	OrganismVO getOrganism(int organismId);

	List<OrganismVO> getOrganisms();

	void createMeasurementUnit(MeasurementUnitVO measurementUnitVO);

	void createClinicalSample(ClinicalSampleVO clinicalSampleVO);

	void createExperiment(ExperimentVO experimentVO);

	List<ExperimentVO> getExperiment();

	List<ClinicalSampleVO> getClinicalSample();

	List<MeasurementUnitVO> getMeasurementUnit();

	int getExperimentCount();

	int getSampleCount();

	int getOrganismCount();

	String getLatestOrganismRegisteredName();

	void delete();

	void deleteMeasurementUnit(int id);

	void deleteExperiment(int id);

	void deleteClinicalSample(int id);

	void deleteOrganism(int id);

	ExperimentVO getExperiment(int id);

	ClinicalSampleVO getClinicalSample(int id);

	MeasurementUnitVO getMeasurementUnit(int id);

}
