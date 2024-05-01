package com.malak.medecins.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Faculte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomFac;
	private String descriptionFac;
	@OneToMany(mappedBy = "faculte")
	@JsonIgnore
	private List<Medecin> medecins;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomFac() {
		return nomFac;
	}
	public void setNomFac(String nomFac) {
		this.nomFac = nomFac;
	}
	public String getDescriptionFac() {
		return descriptionFac;
	}
	public void setDescriptionFac(String descriptionFac) {
		this.descriptionFac = descriptionFac;
	}
	public List<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	
}
