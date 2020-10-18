package project.dbms.vo;

public class ClinicalSampleVO {
	private int id;
	private String sampleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public ClinicalSampleVO(int id, String sampleName) {
		super();
		this.id = id;
		this.sampleName = sampleName;
	}

	public ClinicalSampleVO() {
	}

}
