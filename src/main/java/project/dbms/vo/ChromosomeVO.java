package project.dbms.vo;

import java.util.HashSet;
import java.util.Set;

public class ChromosomeVO {
	private int id;
	private int chromosomeNumber;
	private int totalPairs;
	private int noOfGenes;
	private Set<GeneSequenceVO> geneSequences = new HashSet<GeneSequenceVO>();
	private int organismId;
	private String addMore="NO";
	
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
	public Set<GeneSequenceVO> getGeneSequences() {
		return geneSequences;
	}
	public void setGeneSequences(Set<GeneSequenceVO> geneSequences) {
		this.geneSequences = geneSequences;
	}
	
	
	
	
}
