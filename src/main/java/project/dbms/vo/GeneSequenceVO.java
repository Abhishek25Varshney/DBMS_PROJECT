package project.dbms.vo;

import java.util.HashSet;
import java.util.Set;

public class GeneSequenceVO {
	private int id;
	private String sequence;
	private Set<ArrayProbeVO> arrayProbes = new HashSet<ArrayProbeVO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Set<ArrayProbeVO> getArrayProbes() {
		return arrayProbes;
	}

	public void setArrayProbes(Set<ArrayProbeVO> arrayProbes) {
		this.arrayProbes = arrayProbes;
	}

}
