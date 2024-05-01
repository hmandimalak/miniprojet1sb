package com.malak.medecins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.malak.medecins.entities.Faculte;
import com.malak.medecins.entities.Medecin;
import com.malak.medecins.repos.MedecinRepository;
@Service
public class MedecinServiceImpl implements MedecinService {
	@Autowired
	MedecinRepository medecinRepository;


	@Override
	public Medecin saveMedecin(Medecin m) {
		return medecinRepository.save(m);
	}

	@Override
	public Medecin updateMedecin(Medecin m) {
		return medecinRepository.save(m);
	}

	@Override
	public void deleteMedecin(Medecin m) {
		medecinRepository.delete(m);

		
	}

	@Override
	public void deleteMedecinById(Long id) {
		medecinRepository.deleteById(id);
		
	}

	@Override
	public Medecin getMedecin(Long id) {
		return medecinRepository.findById(id).get();
	}

	@Override
	public List<Medecin> getAllMedecins() {
		return medecinRepository.findAll();
	}

	@Override
	public Page<Medecin> getAllMedecinsParPage(int page, int size) {
		return medecinRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Medecin> findByNomMedecin(String nom) {
		return medecinRepository.findByNomMedecin(nom);
	}

	@Override
	public List<Medecin> findByNomMedecinContains(String nom) {
		return medecinRepository.findByNomMedecinContains(nom);
	}

	@Override
	public List<Medecin> findBySpecialite(String nom, String specialite) {
		return medecinRepository.findBySpecialite(nom, specialite);
	}

	@Override
	public List<Medecin> findByFaculte(Faculte faculte) {
		return medecinRepository.findByFaculte(faculte);
	}

	@Override
	public List<Medecin> findByFaculteId(Long id) {
		return medecinRepository.findByFaculteId(id);
	}

	@Override
	public List<Medecin> findByOrderByNomMedecinAsc() {
		return medecinRepository.findByOrderByNomMedecinAsc();
	}

	@Override
	public List<Medecin> trierMedecinsSpecialite() {
		return medecinRepository.trierProduitsSpecialite();
	}

}
