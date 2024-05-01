package com.malak.Medecins.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malak.medecins.entities.Medecin;
import com.malak.medecins.service.MedecinService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class MedecinRESTController {
	
	@Autowired
	MedecinService medecinService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Medecin> getAllMedecins() {
		return medecinService.getAllMedecins();
		}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Medecin getMedecinById(@PathVariable("id") Long id) {
	return medecinService.getMedecin(id);
	 }

	@RequestMapping(method = RequestMethod.POST)
	public Medecin createMedecin(@RequestBody Medecin medecin) {
	return medecinService.saveMedecin(medecin);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Medecin updateMedecin(@RequestBody Medecin medecin) {
	return medecinService.updateMedecin(medecin);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteMedecin(@PathVariable("id") Long id)
	{
	medecinService.deleteMedecinById(id);
	}
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Medecin> getMedecinsByFacId(@PathVariable("id") Long id) {
	return medecinService.findByFaculteId(id);
	}

}
