package project.dbms.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArrayProbeVO implements Comparable<ArrayProbeVO>{
	private int id;

	private String arrayProbe;

	private List<MRNAExpressionVO> mRNAExpression = new ArrayList<MRNAExpressionVO>();
	
	private int geneSequenceId;

	private String addMore="NO";
	
	private int counter;
	
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



	public List<MRNAExpressionVO> getmRNAExpression() {
		return mRNAExpression;
	}

	public void setmRNAExpression(List<MRNAExpressionVO> mRNAExpression) {
		this.mRNAExpression = mRNAExpression;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	@Override
	public int compareTo(ArrayProbeVO o) {
		if (this.getCounter() > o.getCounter()) {
			return 1;
		} else if (this.getCounter() < o.getCounter()) {
			return -1;
		} else {
			return 0;
		}
	}

}
