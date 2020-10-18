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
@javax.persistence.Table(name = "array_probe")
public class ArrayProbe implements Serializable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "array_probe")
	private String arrayProbe;

	@OneToOne
	@JoinColumn(name = "gene_sequence_id")
	private GeneSequence geneSequence;

	@OneToMany(mappedBy = "arrayProbe", fetch = FetchType.EAGER)
	private Set<MRNAExpression> mRNAExpression = new HashSet<MRNAExpression>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArrayProbe() {
		return arrayProbe;
	}

	public void setArrayProbe(String arrayProbe) {
		this.arrayProbe = arrayProbe;
	}

	public GeneSequence getGeneSequence() {
		return geneSequence;
	}

	public void setGeneSequence(GeneSequence geneSequence) {
		this.geneSequence = geneSequence;
	}

	public Set<MRNAExpression> getmRNAExpression() {
		return mRNAExpression;
	}

	public void setmRNAExpression(Set<MRNAExpression> mRNAExpression) {
		this.mRNAExpression = mRNAExpression;
	}
	
}