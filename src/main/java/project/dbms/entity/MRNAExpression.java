package project.dbms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@javax.persistence.Table(name = "mrna_expression")
public class MRNAExpression implements Serializable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "expression")
	private String expression;

	@OneToOne
	@JoinColumn(name = "array_probe_id")
	private ArrayProbe arrayProbe;
	
	@OneToOne
	@JoinColumn(name = "experiment_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Experiment experiment;
	
	@OneToOne
	@JoinColumn(name = "clinical_sample_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private ClinicalSample clinicalSample;
	
	@OneToOne
	@JoinColumn(name = "measurement_unit_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private MeasurementUnit measurementUnit;

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

	public ArrayProbe getArrayProbe() {
		return arrayProbe;
	}

	public void setArrayProbe(ArrayProbe arrayProbe) {
		this.arrayProbe = arrayProbe;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public ClinicalSample getClinicalSample() {
		return clinicalSample;
	}

	public void setClinicalSample(ClinicalSample clinicalSample) {
		this.clinicalSample = clinicalSample;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}


	
	
}