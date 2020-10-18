package project.dbms.vo;

public class MRNAExpressionVO {
	private int id;
	private String expression;
	private ExperimentVO experimentVO;
	private ClinicalSampleVO clinicalSampleVO;
	private MeasurementUnitVO measurementUnitVO;

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
