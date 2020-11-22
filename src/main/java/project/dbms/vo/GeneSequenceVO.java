package project.dbms.vo;

import java.util.ArrayList;
import java.util.List;

public class GeneSequenceVO implements Comparable<GeneSequenceVO>{
	private int id;
	private String sequence;
	private List<ArrayProbeVO> arrayProbes = new ArrayList<ArrayProbeVO>();
	private int chromosomeId;
	private String addMore="NO";
	private int counter;
	
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getAddMore() {
		return addMore;
	}

	public void setAddMore(String addMore) {
		this.addMore = addMore;
	}

	public int getChromosomeId() {
		return chromosomeId;
	}

	public void setChromosomeId(int chromosomeId) {
		this.chromosomeId = chromosomeId;
	}

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

	public List<ArrayProbeVO> getArrayProbes() {
		return arrayProbes;
	}

	public void setArrayProbes(List<ArrayProbeVO> arrayProbes) {
		this.arrayProbes = arrayProbes;
	}
	@Override
	public int compareTo(GeneSequenceVO o) {
		if (this.getCounter() > o.getCounter()) {
			return 1;
		} else if (this.getCounter() < o.getCounter()) {
			return -1;
		} else {
			return 0;
		}
	}

}
