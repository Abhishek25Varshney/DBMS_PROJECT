package project.dbms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.dbms.service.ProjectService;
import project.dbms.vo.ArrayProbeVO;
import project.dbms.vo.ChromosomeVO;
import project.dbms.vo.ClinicalSampleVO;
import project.dbms.vo.ExperimentVO;
import project.dbms.vo.GeneSequenceVO;
import project.dbms.vo.MRNAExpressionVO;
import project.dbms.vo.MeasurementUnitVO;
import project.dbms.vo.OrganismVO;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService service;

	@GetMapping("/dashboard")
	public ModelAndView getDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("totalExperimentDone", service.getExperimentCount());
		mv.addObject("totalSamples", service.getSampleCount());
		mv.addObject("totalOrganisms", service.getOrganismCount());
		mv.addObject("latestOrganismName", service.getLatestOrganismRegisteredName());
		return mv;
	}

	@GetMapping("/experiment")
	public ModelAndView getExperimentPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("experiment");
		mv.addObject("experimentVO", new ExperimentVO());
		return mv;
	}

	@PostMapping("/experiment")
	public ModelAndView createExperiment(@ModelAttribute("experimentVO") ExperimentVO vo) {
		service.createExperiment(vo);
		return redirectToDashboard("/all/experiment");

	}

	@GetMapping("/delete/experiment/{id}")
	public ModelAndView deleteExperiment(@PathVariable("id") int id) {
		service.deleteExperiment(id);
		return redirectToDashboard("/all/experiment");
	}

	@GetMapping("/experiment/{id}")
	public ModelAndView getExperiment(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("experiment");
		mv.addObject("experimentVO", service.getExperiment(id));
		return mv;
	}

	@GetMapping("/all/experiment")
	public ModelAndView getExperiment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("experimentList");
		mv.addObject("experimentList", service.getExperiment());
		return mv;

	}

	@GetMapping("/clinicalSample")
	public ModelAndView getClinicalSamplePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clinicalSample");
		mv.addObject("clinicalSampleVO", new ClinicalSampleVO());
		return mv;
	}

	@PostMapping("/clinicalSample")
	public ModelAndView createSample(@ModelAttribute("clinicalSampleVO") ClinicalSampleVO vo) {
		service.createClinicalSample(vo);
		return redirectToDashboard("/all/clinicalSample");

	}

	@GetMapping("/delete/clinicalSample/{id}")
	public ModelAndView deleteClinicalSample(@PathVariable("id") int id) {
		service.deleteClinicalSample(id);
		return redirectToDashboard("/all/clinicalSample");
	}

	@GetMapping("/clinicalSample/{id}")
	public ModelAndView getClinicalSample(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clinicalSample");
		mv.addObject("clinicalSampleVO", service.getClinicalSample(id));
		return mv;
	}

	@GetMapping("/all/clinicalSample")
	public ModelAndView getClinicalSample() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sampleList");
		mv.addObject("sampleList", service.getClinicalSample());
		return mv;

	}

	@GetMapping("/measurementUnit")
	public ModelAndView getMeasurementUnitPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("measurementUnit");
		mv.addObject("measurementUnitVO", new MeasurementUnitVO());
		return mv;
	}

	@PostMapping("/measurementUnit")
	public ModelAndView createMeasurementUnit(@ModelAttribute("measurementUnitVO") MeasurementUnitVO vo) {
		service.createMeasurementUnit(vo);
		return redirectToDashboard("/all/measurementUnit");

	}

	@GetMapping("/delete/measurementUnit/{id}")
	public ModelAndView deleteMeasurementUnit(@PathVariable("id") int id) {
		service.deleteMeasurementUnit(id);
		return redirectToDashboard("/all/measurementUnit");
	}

	@GetMapping("/measurementUnit/{id}")
	public ModelAndView getMeasurementunit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("measurementUnit");
		mv.addObject("measurementUnitVO", service.getMeasurementUnit(id));
		return mv;
	}

	@GetMapping("/all/measurementUnit")
	public ModelAndView getMeasurementUnit() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("unitList");
		mv.addObject("unitList", service.getMeasurementUnit());
		return mv;

	}

	@GetMapping("/organism")
	public ModelAndView getOrganismPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("organism");
		mv.addObject("organismVO", new OrganismVO());
		return mv;
	}

//	
	@PostMapping("/organism")
	public ModelAndView createOrganism(@ModelAttribute("organismVO") OrganismVO organismVO) {
		service.createOrganism(organismVO);
		return redirectToDashboard("/chromosome");

	}

	@GetMapping("/chromosome")
	public ModelAndView getChromosomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chromosome");
		mv.addObject("chromosomeVO", new ChromosomeVO());
		mv.addObject("organismList", service.getOrganisms());
		List<String> allStatus = new ArrayList<String>();
		allStatus.add("YES");
		allStatus.add("NO");
		mv.addObject("allStatus", allStatus);
		return mv;
	}

	@PostMapping("/chromosome")
	public ModelAndView createChromosome(@ModelAttribute("chromosomeVO") ChromosomeVO vo) {
		service.createChromosme(vo);
		if (vo.getAddMore().equalsIgnoreCase("YES")) {
			return redirectToDashboard("/chromosome");
		} else {
			return redirectToDashboard("/gene");
		}
	}

	@GetMapping("/delete/organism/{id}")
	public ModelAndView deleteOrganism(@PathVariable("id") int id) {
		service.deleteOrganism(id);
		return redirectToDashboard("/all/organism");
	}

	@GetMapping("/organism/{id}")
	public ModelAndView viewOrganism(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("view-organism");
		mv.addObject("organismVO", service.getOrganism(id));
		return mv;
	}

	@GetMapping("/all/organism")
	public ModelAndView getOrganisms() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("organismList");
		mv.addObject("organismList", service.getOrganisms());
		return mv;
	}

	@GetMapping("/chromosome/{id}")
	public ModelAndView getChromosomePage(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chromosome");
		mv.addObject("vo", new ChromosomeVO());
		return mv;
	}

	@GetMapping("/delete")
	@ResponseBody
	public void ads() {
		service.delete();

	}

	private ModelAndView redirectToDashboard(String apiUrl) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + apiUrl);
		return mv;
	}

	@GetMapping("/gene")
	public ModelAndView getGenePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gene");
		mv.addObject("geneVO", new GeneSequenceVO());
		mv.addObject("chromosomeList", service.getChromosomeList());
		List<String> allStatus = new ArrayList<String>();
		allStatus.add("YES");
		allStatus.add("NO");
		mv.addObject("allStatus", allStatus);
		return mv;
	}

	@PostMapping("/gene")
	public ModelAndView createGenePage(@ModelAttribute("gene") GeneSequenceVO vo) {
		service.createGene(vo);
		if (vo.getAddMore().equalsIgnoreCase("YES")) {
			return redirectToDashboard("/gene");
		} else {
			return redirectToDashboard("/array");
		}

	}

	@GetMapping("/array")
	public ModelAndView getArrayPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("array");
		mv.addObject("arrayVO", new ArrayProbeVO());
		mv.addObject("geneList", service.getGeneList());
		List<String> allStatus = new ArrayList<String>();
		allStatus.add("YES");
		allStatus.add("NO");
		mv.addObject("allStatus", allStatus);
		return mv;
	}

	@PostMapping("/array")
	public ModelAndView createArrayPage(@ModelAttribute("array") ArrayProbeVO vo) {
		service.createArrayProbe(vo);
		if (vo.getAddMore().equalsIgnoreCase("YES")) {
			return redirectToDashboard("/array");
		} else {
			return redirectToDashboard("/mrna");
		}

	}

	@GetMapping("/mrna")
	public ModelAndView getMRNAPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mrna");
		mv.addObject("mrnaVO", new MRNAExpressionVO());
		mv.addObject("arrayList", service.getArrayList());
		mv.addObject("experimentList", service.getExperiment());
		mv.addObject("unitList", service.getMeasurementUnit());
		mv.addObject("sampleList", service.getClinicalSample());
		List<String> allStatus = new ArrayList<String>();
		allStatus.add("YES");
		allStatus.add("NO");
		mv.addObject("allStatus", allStatus);
		return mv;
	}

	@PostMapping("/mrna")
	public ModelAndView createMRNAPage(@ModelAttribute("mrnaVO") MRNAExpressionVO vo) {
		service.createMRNA(vo);
		if (vo.getAddMore().equalsIgnoreCase("YES")) {
			return redirectToDashboard("/mrna");
		} else {
			return redirectToDashboard("/dashboard");
		}

	}

	@GetMapping("/canvasjschart")
	public ModelAndView springMVC() {
		List<List<Map<Object, Object>>> canvasjsDataList = service.getCanvasjsChartData();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chart");
		mv.addObject("dataPointsList", canvasjsDataList);
		return mv;
	}

}