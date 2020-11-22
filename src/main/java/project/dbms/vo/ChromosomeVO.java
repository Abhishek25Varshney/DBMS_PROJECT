package project.dbms.vo;

import java.util.ArrayList;
import java.util.List;

public class ChromosomeVO implements Comparable<ChromosomeVO> {
	private int id;
	private int chromosomeNumber;
	private int totalPairs;
	private int noOfGenes;
	private List<GeneSequenceVO> geneSequences = new ArrayList<GeneSequenceVO>();
	private int organismId;
	private String addMore = "NO";
	int counter;

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

	public int getOrganismId() {
		return organismId;
	}

	public void setOrganismId(int organismId) {
		this.organismId = organismId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChromosomeNumber() {
		return chromosomeNumber;
	}

	public void setChromosomeNumber(int chromosomeNumber) {
		this.chromosomeNumber = chromosomeNumber;
	}

	public int getTotalPairs() {
		return totalPairs;
	}

	public void setTotalPairs(int totalPairs) {
		this.totalPairs = totalPairs;
	}

	public int getNoOfGenes() {
		return noOfGenes;
	}

	public void setNoOfGenes(int noOfGenes) {
		this.noOfGenes = noOfGenes;
	}



	public List<GeneSequenceVO> getGeneSequences() {
		return geneSequences;
	}

	public void setGeneSequences(List<GeneSequenceVO> geneSequences) {
		this.geneSequences = geneSequences;
	}

	@Override
	public int compareTo(ChromosomeVO o) {
		if (this.getCounter() > o.getCounter()) {
			return 1;
		} else if (this.getCounter() < o.getCounter()) {
			return -1;
		} else {
			return 0;
		}
	}

}
