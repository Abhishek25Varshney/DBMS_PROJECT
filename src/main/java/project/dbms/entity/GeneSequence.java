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
@javax.persistence.Table(name = "gene_sequence")
public class GeneSequence implements Serializable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "sequence")
	private String sequence;

	@OneToOne
	@JoinColumn(name = "chromosome_id")
	private Chromosome chromosome;
	
	@OneToMany(mappedBy = "geneSequence", fetch = FetchType.EAGER)
	private Set<ArrayProbe> arrayProbes = new HashSet<ArrayProbe>();

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

	public Chromosome getChromosome() {
		return chromosome;
	}

	public void setChromosome(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	public Set<ArrayProbe> getArrayProbes() {
		return arrayProbes;
	}

	public void setArrayProbes(Set<ArrayProbe> arrayProbes) {
		this.arrayProbes = arrayProbes;
	}
	
	
}