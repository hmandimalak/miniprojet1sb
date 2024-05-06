package com.malak.medecins.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomMedecin;
	@NotNull
	@Size (min = 4,max = 15)
	private String specialite;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateDiplome;
	@ManyToOne
	private Faculte faculte;
	
	public Medecin() {
		super();
		
	}
	
	public Medecin(String nomMedecin, String specialite, Date dateDiplome) {
		super();
		this.nomMedecin = nomMedecin;
		this.specialite = specialite;
		this.dateDiplome = dateDiplome;
	}

	public Long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Date getDateDiplome() {
		return dateDiplome;
	}
	public void setDateDiplome(Date dateDiplome) {
		this.dateDiplome = dateDiplome;
	}

	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", specialite=" + specialite
				+ ", dateDiplome=" + dateDiplome + "]";
	}

	public Faculte getFaculte() {
		return faculte;
	}

	public void setFaculte(Faculte faculte) {
		this.faculte = faculte;
	}
	
	
}
