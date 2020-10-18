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

@Entity
@javax.persistence.Table(name = "chromosome")
public class Chromosome implements Serializable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "chromosome_number")
	private int chromosomeNumber;

	@Column(name = "total_pairs")
	private int totalPairs;
	@Column(name = "no_of_genes")
	private int noOfGenes;
	
	@OneToOne
	@JoinColumn(name = "organism_id")
	private Organism organism;

	@OneToMany(mappedBy = "chromosome", fetch = FetchType.EAGER)
	private Set<GeneSequence> geneSequences = new HashSet<GeneSequence>();
	
	public Set<GeneSequence> getGeneSequences() {
		return geneSequences;
	}

	public void setGeneSequences(Set<GeneSequence> geneSequences) {
		this.geneSequences = geneSequences;
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

	public Organism getOrganism() {
		return organism;
	}

	public void setOrganism(Organism organism) {
		this.organism = organism;
	}
	
	
	


	
	
}