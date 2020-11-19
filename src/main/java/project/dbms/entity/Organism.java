package project.dbms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name = "organism")
public class Organism implements Serializable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "species")
	private String species;

	@Column(name = "scientific_name")
	private String scientificName;
	@Column(name = "genus")
	private String genus;
	@Column(name = "cell_type")
	private String cellType;

	@OneToMany(mappedBy = "organism", fetch = FetchType.EAGER)
	private Set<Chromosome> chromosomes = new HashSet<Chromosome>();
	
	@Column(name = "date")
	private String registeredDate;


	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Set<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(Set<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

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

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

}