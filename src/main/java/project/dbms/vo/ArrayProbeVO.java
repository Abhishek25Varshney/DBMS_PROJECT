package project.dbms.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import project.dbms.entity.Chromosome;
import project.dbms.entity.GeneSequence;
import project.dbms.entity.MRNAExpression;

public class ArrayProbeVO {
	private int id;

	private String arrayProbe;

	private Set<MRNAExpressionVO> mRNAExpression = new HashSet<MRNAExpressionVO>();
	
	private int geneSequenceId;

	private String addMore="NO";
	
	public String getAddMore() {
		return addMore;
	}

	public void setAddMore(String addMore) {
		this.addMore = addMore;
	}
	
	public int getGeneSequenceId() {
		return geneSequenceId;
	}

	public void setGeneSequenceId(int geneSequenceId) {
		this.geneSequenceId = geneSequenceId;
	}

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


	public Set<MRNAExpressionVO> getmRNAExpression() {
		return mRNAExpression;
	}

	public void setmRNAExpression(Set<MRNAExpressionVO> mRNAExpression) {
		this.mRNAExpression = mRNAExpression;
	}
	
	

}
