package project.dbms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dbms.entity.ArrayProbe;
import project.dbms.entity.Chromosome;
import project.dbms.entity.ClinicalSample;
import project.dbms.entity.Experiment;
import project.dbms.entity.GeneSequence;
import project.dbms.entity.MRNAExpression;
import project.dbms.entity.MeasurementUnit;
import project.dbms.entity.Organism;
import project.dbms.repository.ArrayProbeRepository;
import project.dbms.repository.ChromosomeRepository;
import project.dbms.repository.ClinicalSampleRepository;
import project.dbms.repository.ExperimentRepository;
import project.dbms.repository.GeneSequenceRepository;
import project.dbms.repository.MRNAExpressionRepository;
import project.dbms.repository.MeasurementUnitRepository;
import project.dbms.repository.OrganismRepository;
import project.dbms.service.ProjectService;
import project.dbms.vo.ArrayProbeVO;
import project.dbms.vo.ChromosomeVO;
import project.dbms.vo.ClinicalSampleVO;
import project.dbms.vo.ExperimentVO;
import project.dbms.vo.GeneSequenceVO;
import project.dbms.vo.MRNAExpressionVO;
import project.dbms.vo.MeasurementUnitVO;
import project.dbms.vo.OrganismVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	private static Logger log = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private OrganismRepository organismRepo;

	@Autowired
	private ExperimentRepository experimentRepo;

	@Autowired
	private ClinicalSampleRepository clinicalSampleRepo;

	@Autowired
	private MeasurementUnitRepository measurementUnitRepo;

	@Autowired
	private ChromosomeRepository chromosomeRepository;

	@Autowired
	private GeneSequenceRepository geneSequenceRepository;

	@Autowired
	private ArrayProbeRepository arrayProbeRepository;

	@Autowired
	private MRNAExpressionRepository mrnaExpressionRepository;

	@Override
	public void createOrganism(OrganismVO organismVO) {
		Organism organism = new Organism();
		organism.setSpecies(organismVO.getSpecies());
		organism.setScientificName(organismVO.getScientificName());
		organism.setGenus(organismVO.getGenus());
		organism.setCellType(organismVO.getCellType());
		organism.setRegisteredDate(formatDate(new Date()));
		organismRepo.save(organism);

	}

	public static String formatDate(Date date) {
		String pattern = "dd-MMM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	@Override
	public void createChromosme(ChromosomeVO vo) {
		Chromosome chromosome = new Chromosome();
		chromosome.setChromosomeNumber(vo.getChromosomeNumber());
		chromosome.setTotalPairs(vo.getTotalPairs());
		chromosome.setNoOfGenes(vo.getNoOfGenes());
		Organism organism = organismRepo.findOne(vo.getOrganismId());
		chromosome.setOrganism(organism);
		chromosomeRepository.save(chromosome);

	}

	@Override
	public void createGene(GeneSequenceVO vo) {
		GeneSequence entity = new GeneSequence();
		entity.setSequence(vo.getSequence());
		Chromosome chromosome = chromosomeRepository.findOne(vo.getChromosomeId());
		entity.setChromosome(chromosome);
		geneSequenceRepository.save(entity);

	}

	@Override
	public void createArrayProbe(ArrayProbeVO vo) {
		ArrayProbe entity = new ArrayProbe();
		entity.setArrayProbe(vo.getArrayProbe());
		GeneSequence gene = geneSequenceRepository.findOne(vo.getGeneSequenceId());
		entity.setGeneSequence(gene);
		arrayProbeRepository.save(entity);

	}

	@Override
	public void createMRNA(MRNAExpressionVO vo) {
		MRNAExpression entity = new MRNAExpression();
		entity.setExpression(vo.getExpression());
		ArrayProbe array = arrayProbeRepository.findOne(vo.getArrayProbeId());
		entity.setArrayProbe(array);
		Experiment experiment = experimentRepo.findOne(vo.getExperimentId());
		entity.setExperiment(experiment);
		ClinicalSample sample = clinicalSampleRepo.findOne(vo.getClinicalSampleId());
		entity.setClinicalSample(sample);
		MeasurementUnit unit = measurementUnitRepo.findOne(vo.getMeasurementUnitId());
		entity.setMeasurementUnit(unit);
		mrnaExpressionRepository.save(entity);

	}

	@Override
	public OrganismVO getOrganism(int organismId) {
		Organism organism = organismRepo.findOne(organismId);

		OrganismVO organismVO = new OrganismVO();
		organismVO.setSpecies(organism.getSpecies());
		organismVO.setScientificName(organism.getScientificName());
		organismVO.setGenus(organism.getGenus());
		organismVO.setCellType(organism.getCellType());
		organismVO.setId(organism.getId());

		int chromosomeCounter = 0;
		for (Chromosome chromosome : organism.getChromosomes()) {
			ChromosomeVO chromosomeVO = new ChromosomeVO();
			chromosomeVO.setChromosomeNumber(chromosome.getChromosomeNumber());
			chromosomeVO.setTotalPairs(chromosome.getTotalPairs());
			chromosomeVO.setNoOfGenes(chromosome.getNoOfGenes());
			chromosomeVO.setId(chromosome.getId());
			chromosomeCounter = chromosomeCounter + 1;
			System.out.println(chromosomeCounter);
			chromosomeVO.setCounter(chromosomeCounter);
			organismVO.getChromosomes().add(chromosomeVO);

			int geneCounter = 0;
			for (GeneSequence geneSequence : chromosome.getGeneSequences()) {
				GeneSequenceVO geneSequenceVO = new GeneSequenceVO();
				geneSequenceVO.setSequence(geneSequence.getSequence());
				geneSequenceVO.setId(geneSequence.getId());
				geneCounter = geneCounter + 1;
				geneSequenceVO.setCounter(geneCounter);
				chromosomeVO.getGeneSequences().add(geneSequenceVO);

				int arrayCounter = 0;
				for (ArrayProbe arrayProbe : geneSequence.getArrayProbes()) {
					ArrayProbeVO arrayProbeVO = new ArrayProbeVO();
					arrayProbeVO.setArrayProbe(arrayProbe.getArrayProbe());
					arrayProbeVO.setId(arrayProbe.getId());
					arrayCounter = arrayCounter + 1;
					arrayProbeVO.setCounter(arrayCounter);
					geneSequenceVO.getArrayProbes().add(arrayProbeVO);
					int mrnaCounter = 0;

					for (MRNAExpression mRNAExpression : arrayProbe.getmRNAExpression()) {
						MRNAExpressionVO mRNAExpressionVO = new MRNAExpressionVO();
						mRNAExpressionVO.setExpression(mRNAExpression.getExpression());
						mrnaCounter = mrnaCounter + 1;
						mRNAExpressionVO.setCounter(mrnaCounter);

						mRNAExpressionVO.setId(mRNAExpression.getId());
						if (mRNAExpression.getExperiment() != null) {
							mRNAExpressionVO.setExperimentVO(new ExperimentVO(mRNAExpression.getExperiment().getId(),
									mRNAExpression.getExperiment().getName()));
						}

						if (mRNAExpression.getClinicalSample() != null) {
							mRNAExpressionVO.setClinicalSampleVO(
									new ClinicalSampleVO(mRNAExpression.getClinicalSample().getId(),
											mRNAExpression.getClinicalSample().getSampleName()));
						}

						if (mRNAExpression.getMeasurementUnit() != null) {
							mRNAExpressionVO.setMeasurementUnitVO(
									new MeasurementUnitVO(mRNAExpression.getMeasurementUnit().getId(),
											mRNAExpression.getMeasurementUnit().getName()));
						}
						arrayProbeVO.getmRNAExpression().add(mRNAExpressionVO);
						Collections.sort(arrayProbeVO.getmRNAExpression());
					}
					Collections.sort(geneSequenceVO.getArrayProbes());
				}
				Collections.sort(chromosomeVO.getGeneSequences());
			}
		}
		Collections.sort(organismVO.getChromosomes());
		return organismVO;
	}

	@Override
	public List<OrganismVO> getOrganisms() {
		List<OrganismVO> organismVOList = new ArrayList<OrganismVO>();
		List<Organism> organisms = (List<Organism>) organismRepo.findAll();

		for (Organism organism : organisms) {

			OrganismVO organismVO = new OrganismVO();
			organismVOList.add(organismVO);

			organismVO.setSpecies(organism.getSpecies());
			organismVO.setScientificName(organism.getScientificName());
			organismVO.setGenus(organism.getGenus());
			organismVO.setCellType(organism.getCellType());
			organismVO.setId(organism.getId());

			for (Chromosome chromosome : organism.getChromosomes()) {
				ChromosomeVO chromosomeVO = new ChromosomeVO();
				chromosomeVO.setChromosomeNumber(chromosome.getChromosomeNumber());
				chromosomeVO.setTotalPairs(chromosome.getTotalPairs());
				chromosomeVO.setNoOfGenes(chromosome.getNoOfGenes());
				chromosomeVO.setId(chromosome.getId());
				organismVO.getChromosomes().add(chromosomeVO);

				for (GeneSequence geneSequence : chromosome.getGeneSequences()) {
					GeneSequenceVO geneSequenceVO = new GeneSequenceVO();
					geneSequenceVO.setSequence(geneSequence.getSequence());
					geneSequenceVO.setId(geneSequence.getId());
					chromosomeVO.getGeneSequences().add(geneSequenceVO);

					for (ArrayProbe arrayProbe : geneSequence.getArrayProbes()) {
						ArrayProbeVO arrayProbeVO = new ArrayProbeVO();
						arrayProbeVO.setArrayProbe(arrayProbe.getArrayProbe());
						arrayProbeVO.setId(arrayProbe.getId());
						geneSequenceVO.getArrayProbes().add(arrayProbeVO);

						for (MRNAExpression mRNAExpression : arrayProbe.getmRNAExpression()) {
							MRNAExpressionVO mRNAExpressionVO = new MRNAExpressionVO();
							mRNAExpressionVO.setExpression(mRNAExpression.getExpression());
							mRNAExpressionVO.setId(mRNAExpression.getId());

							if (mRNAExpression.getExperiment() != null) {
								mRNAExpressionVO
										.setExperimentVO(new ExperimentVO(mRNAExpression.getExperiment().getId(),
												mRNAExpression.getExperiment().getName()));
							}

							if (mRNAExpression.getClinicalSample() != null) {
								mRNAExpressionVO.setClinicalSampleVO(
										new ClinicalSampleVO(mRNAExpression.getClinicalSample().getId(),
												mRNAExpression.getClinicalSample().getSampleName()));
							}

							if (mRNAExpression.getMeasurementUnit() != null) {
								mRNAExpressionVO.setMeasurementUnitVO(
										new MeasurementUnitVO(mRNAExpression.getMeasurementUnit().getId(),
												mRNAExpression.getMeasurementUnit().getName()));
							}
							arrayProbeVO.getmRNAExpression().add(mRNAExpressionVO);
						}
					}
				}
			}
		}
		return organismVOList;
	}

	@Override
	public void createExperiment(ExperimentVO experimentVO) {

		Experiment experiment = experimentRepo.findOne(experimentVO.getId());
		if (experiment == null) {
			experiment = new Experiment();
		}
		experiment.setName(experimentVO.getName());
		experimentRepo.save(experiment);

	}

	@Override
	public List<ExperimentVO> getExperiment() {
		List<ExperimentVO> list = new ArrayList<ExperimentVO>();
		List<Experiment> expList = (List<Experiment>) experimentRepo.findAll();

		for (Experiment experiment : expList) {

			ExperimentVO vo = new ExperimentVO(experiment.getId(), experiment.getName());
			list.add(vo);
		}
		return list;
	}

	@Override
	public void createClinicalSample(ClinicalSampleVO clinicalSampleVO) {

		ClinicalSample sample = clinicalSampleRepo.findOne(clinicalSampleVO.getId());
		if (sample == null) {
			sample = new ClinicalSample();
		}
		sample.setSampleName(clinicalSampleVO.getSampleName());
		clinicalSampleRepo.save(sample);

	}

	@Override
	public List<ClinicalSampleVO> getClinicalSample() {
		List<ClinicalSampleVO> list = new ArrayList<ClinicalSampleVO>();
		List<ClinicalSample> sampleList = (List<ClinicalSample>) clinicalSampleRepo.findAll();

		for (ClinicalSample sample : sampleList) {

			ClinicalSampleVO vo = new ClinicalSampleVO(sample.getId(), sample.getSampleName());
			list.add(vo);
		}
		return list;
	}

	@Override
	public void createMeasurementUnit(MeasurementUnitVO measurementUnitVO) {
		MeasurementUnit unit = measurementUnitRepo.findOne(measurementUnitVO.getId());
		if (unit == null) {
			unit = new MeasurementUnit();
		}
		unit.setName(measurementUnitVO.getName());
		measurementUnitRepo.save(unit);

	}

	@Override
	public List<MeasurementUnitVO> getMeasurementUnit() {
		List<MeasurementUnitVO> list = new ArrayList<MeasurementUnitVO>();
		List<MeasurementUnit> unitList = (List<MeasurementUnit>) measurementUnitRepo.findAll();

		for (MeasurementUnit unit : unitList) {

			MeasurementUnitVO vo = new MeasurementUnitVO(unit.getId(), unit.getName());
			list.add(vo);
		}
		return list;
	}

	@Override
	public int getExperimentCount() {
		List<Experiment> list = (List<Experiment>) experimentRepo.findAll();
		return list.size();
	}

	@Override
	public int getSampleCount() {
		List<ClinicalSample> list = (List<ClinicalSample>) clinicalSampleRepo.findAll();
		return list.size();
	}

	@Override
	public int getOrganismCount() {
		List<Organism> list = (List<Organism>) organismRepo.findAll();
		return list.size();
	}

	@Override
	public String getLatestOrganismRegisteredName() {
		if (organismRepo.findLastestOrganism().isEmpty()) {
			return "NA";
		} else {
			return organismRepo.findLastestOrganism().get(0).getScientificName();
		}
	}

	@Override
	public void delete() {

		mrnaExpressionRepository.deleteAll();
		arrayProbeRepository.deleteAll();
		geneSequenceRepository.deleteAll();
		chromosomeRepository.deleteAll();
		organismRepo.deleteAll();

	}

	@Override
	public void deleteMeasurementUnit(int id) {
		measurementUnitRepo.delete(id);

	}

	@Override
	public void deleteExperiment(int id) {
		experimentRepo.delete(id);

	}

	@Override
	public void deleteClinicalSample(int id) {
		clinicalSampleRepo.delete(id);

	}

	@Override
	public void deleteOrganism(int id) {
		Organism organism = organismRepo.findOne(id);
		Set<Chromosome> chromosomes = organism.getChromosomes();
		List<GeneSequence> geneSequences = new ArrayList<GeneSequence>();
		for (Chromosome chromosome : chromosomes) {
			geneSequences.addAll(chromosome.getGeneSequences());
		}

		List<ArrayProbe> arrayProbes = new ArrayList<ArrayProbe>();
		for (GeneSequence geneSequence : geneSequences) {
			arrayProbes.addAll(geneSequence.getArrayProbes());
		}

		List<MRNAExpression> mRNAExpressions = new ArrayList<MRNAExpression>();
		for (ArrayProbe arrayProbe : arrayProbes) {
			mRNAExpressions.addAll(arrayProbe.getmRNAExpression());
		}

		organismRepo.delete(organism);
		chromosomeRepository.delete(chromosomes);
		geneSequenceRepository.delete(geneSequences);
		arrayProbeRepository.delete(arrayProbes);
		mrnaExpressionRepository.delete(mRNAExpressions);
	}

	@Override
	public ExperimentVO getExperiment(int id) {
		Experiment exp = experimentRepo.findOne(id);
		ExperimentVO expVO = new ExperimentVO(exp.getId(), exp.getName());
		return expVO;
	}

	@Override
	public MeasurementUnitVO getMeasurementUnit(int id) {
		MeasurementUnit unit = measurementUnitRepo.findOne(id);
		MeasurementUnitVO vo = new MeasurementUnitVO(unit.getId(), unit.getName());
		return vo;
	}

	@Override
	public ClinicalSampleVO getClinicalSample(int id) {
		ClinicalSample sample = clinicalSampleRepo.findOne(id);
		ClinicalSampleVO vo = new ClinicalSampleVO(sample.getId(), sample.getSampleName());
		return vo;
	}

	@Override
	public List<ChromosomeVO> getChromosomeList() {
		List<ChromosomeVO> list = new ArrayList<ChromosomeVO>();
		List<Chromosome> dbList = (List<Chromosome>) chromosomeRepository.findAll();

		for (Chromosome entity : dbList) {

			ChromosomeVO vo = new ChromosomeVO();
			vo.setChromosomeNumber(entity.getChromosomeNumber());
			vo.setId(entity.getId());
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<GeneSequenceVO> getGeneList() {
		List<GeneSequenceVO> list = new ArrayList<GeneSequenceVO>();
		List<GeneSequence> dbList = (List<GeneSequence>) geneSequenceRepository.findAll();

		for (GeneSequence entity : dbList) {

			GeneSequenceVO vo = new GeneSequenceVO();
			vo.setSequence(entity.getSequence());
			vo.setId(entity.getId());
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<ArrayProbeVO> getArrayList() {
		List<ArrayProbeVO> list = new ArrayList<ArrayProbeVO>();
		List<ArrayProbe> dbList = (List<ArrayProbe>) arrayProbeRepository.findAll();

		for (ArrayProbe entity : dbList) {

			ArrayProbeVO vo = new ArrayProbeVO();
			vo.setArrayProbe(entity.getArrayProbe());
			vo.setId(entity.getId());
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		Map<Object, Object> map = null;
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

		List<String> species = organismRepo.findAllOrganismSpecies();
		for (String string : species) {
			map = new HashMap<Object, Object>();
			map.put("name", string);
			map.put("y", 100 * organismRepo.countOrganismOfSpecificSpecies(string) / organismRepo.countAllOrganism());
			dataPoints1.add(map);
		}

		return list;
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsBarChartData() {
		Map<Object, Object> map = null;
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

		List<Organism> allOrganism = (List<Organism>) organismRepo.findAll();
		Map<String, Integer> dateWiseCountMap = new HashMap<String, Integer>();
		for (Organism organism : allOrganism) {
			if (!dateWiseCountMap.containsKey(organism.getRegisteredDate())) {
				dateWiseCountMap.put(organism.getRegisteredDate(), 0);
			}
			dateWiseCountMap.put(organism.getRegisteredDate(), dateWiseCountMap.get(organism.getRegisteredDate()) + 1);
		}

		for (Map.Entry<String, Integer> entry : dateWiseCountMap.entrySet()) {
			map = new HashMap<Object, Object>();
			map.put("x", parseDate(entry.getKey()).getTime());
			map.put("y", entry.getValue());
			dataPoints1.add(map);
		}

		list.add(dataPoints1);
		return list;
	}

	private Date parseDate(String registeredDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MMM-yyyy").parse(registeredDate);
		} catch (ParseException e) {
			log.error("Error while parsing date.");
		}
		return date;
	}

	@Override
	public Map<String, Integer> getBarChartData() {
		List<Organism> allOrganism = (List<Organism>) organismRepo.findAll();
		Map<String, Integer> dateWiseCountMap = new HashMap<String, Integer>();
		for (Organism organism : allOrganism) {
			if (!dateWiseCountMap.containsKey(organism.getRegisteredDate())) {
				dateWiseCountMap.put(organism.getRegisteredDate(), 0);
			}
			dateWiseCountMap.put(organism.getRegisteredDate(), dateWiseCountMap.get(organism.getRegisteredDate()) + 1);
		}

		return dateWiseCountMap;
	}

	@Override
	public Map<String, Integer> getPieChartData() {
		List<String> species = organismRepo.findAllOrganismSpecies();
		Map<String, Integer> pieChartMap = new HashMap<String, Integer>();
		for (String string : species) {
			if (!pieChartMap.containsKey(string)) {
				pieChartMap.put(string, organismRepo.countOrganismOfSpecificSpecies(string));
			}
		}

		return pieChartMap;
	}
}
