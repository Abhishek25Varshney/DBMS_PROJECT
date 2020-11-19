package project.dbms.service;

import java.util.List;
import java.util.Map;

import project.dbms.vo.ArrayProbeVO;
import project.dbms.vo.ChromosomeVO;
import project.dbms.vo.ClinicalSampleVO;
import project.dbms.vo.ExperimentVO;
import project.dbms.vo.GeneSequenceVO;
import project.dbms.vo.MRNAExpressionVO;
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

	void createChromosme(ChromosomeVO vo);

	List<ChromosomeVO> getChromosomeList();

	void createGene(GeneSequenceVO vo);

	List<GeneSequenceVO> getGeneList();

	void createArrayProbe(ArrayProbeVO vo);

	List<ArrayProbeVO> getArrayList();

	void createMRNA(MRNAExpressionVO vo);

	List<List<Map<Object, Object>>> getCanvasjsChartData();

	List<List<Map<Object, Object>>> getCanvasjsBarChartData();

	Map<String, Integer> getBarChartData();

	Map<String, Integer> getPieChartData();

}
