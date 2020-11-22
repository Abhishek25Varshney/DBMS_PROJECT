package project.dbms.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrganismVO {
	private int id;
	private String species;
	private String scientificName;
	private String genus;
	private String cellType;
	private List<ChromosomeVO> chromosomes = new ArrayList<ChromosomeVO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

	public List<ChromosomeVO> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(List<ChromosomeVO> chromosomes) {
		this.chromosomes = chromosomes;
	}


}
