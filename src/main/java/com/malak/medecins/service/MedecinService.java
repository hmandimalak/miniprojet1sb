package com.malak.medecins.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.malak.medecins.entities.Faculte;
import com.malak.medecins.entities.Medecin;

public interface MedecinService {
	Medecin saveMedecin(Medecin m);
	Medecin updateMedecin(Medecin m);
	void deleteMedecin(Medecin m);
	 void deleteMedecinById(Long id);
	Medecin getMedecin(Long id);
	List<Medecin> getAllMedecins();
	Page<Medecin> getAllMedecinsParPage(int page, int size);
	List<Medecin> findByNomMedecin(String nom);
	List<Medecin> findByNomMedecinContains(String nom);
	List<Medecin> findBySpecialite (String nom, String specialite);
	List<Medecin> findByFaculte (Faculte faculte);
	List<Medecin> findByFaculteId(Long id);
	List<Medecin> findByOrderByNomMedecinAsc();
	List<Medecin> trierMedecinsSpecialite();
}
