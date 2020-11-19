package project.dbms.vo;

public class MRNAExpressionVO {
	private int id;
	private String expression;
	private ExperimentVO experimentVO;
	private ClinicalSampleVO clinicalSampleVO;
	private MeasurementUnitVO measurementUnitVO;
	
	private int arrayProbeId;
	private int experimentId;
	private int clinicalSampleId;
	private int measurementUnitId;
	private String addMore="NO";
	
	public String getAddMore() {
		return addMore;
	}

	public void setAddMore(String addMore) {
		this.addMore = addMore;
	}
	public int getArrayProbeId() {
		return arrayProbeId;
	}

	public void setArrayProbeId(int arrayProbeId) {
		this.arrayProbeId = arrayProbeId;
	}

	public int getExperimentId() {
		return experimentId;
	}

	public void setExperimentId(int experimentId) {
		this.experimentId = experimentId;
	}

	public int getClinicalSampleId() {
		return clinicalSampleId;
	}

	public void setClinicalSampleId(int clinicalSampleId) {
		this.clinicalSampleId = clinicalSampleId;
	}

	public int getMeasurementUnitId() {
		return measurementUnitId;
	}

	public void setMeasurementUnitId(int measurementUnitId) {
		this.measurementUnitId = measurementUnitId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}


	public ExperimentVO getExperimentVO() {
		return experimentVO;
	}

	public void setExperimentVO(ExperimentVO experimentVO) {
		this.experimentVO = experimentVO;
	}

	public ClinicalSampleVO getClinicalSampleVO() {
		return clinicalSampleVO;
	}

	public void setClinicalSampleVO(ClinicalSampleVO clinicalSampleVO) {
		this.clinicalSampleVO = clinicalSampleVO;
	}

	public MeasurementUnitVO getMeasurementUnitVO() {
		return measurementUnitVO;
	}

	public void setMeasurementUnitVO(MeasurementUnitVO measurementUnitVO) {
		this.measurementUnitVO = measurementUnitVO;
	}

}
