package com.malak.medecins;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.malak.medecins.entities.Medecin;
import com.malak.medecins.repos.MedecinRepository;
import com.malak.medecins.service.MedecinService;

@SpringBootTest
class MedecinsApplicationTests {

	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private MedecinService medecinService;
	@Test
	public void testCreateMedecin() {
	Medecin med = new Medecin("imen","dentiste",new Date());
	medecinRepository.save(med);
	}
	@Test
	public void testFindMedecin()
	{
	Medecin m = medecinRepository.findById(1L).get();
	System.out.println(m);
	}
	@Test
	public void testUpdateMedecin()
	{
	Medecin m = medecinRepository.findById(1L).get();
	m.setSpecialite("generaliste");
	medecinRepository.save(m);
	}
	public void testDeleteMedecin()
	{
	medecinRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousMedecins()
	{
	List<Medecin> meds = medecinRepository.findAll();
	for (Medecin m : meds)
	{
	System.out.println(m);
	}
	
	}

	@Test
	public void testFindByNomMedecinContains() {
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(0, 2);
		System.out.println(meds.getSize());
		System.out.println(meds.getTotalElements());
		System.out.println(meds.getTotalPages());
		meds.getContent().forEach(m -> {
			System.out.println(m.toString());
		});
		/*
		 * ou bien for (Medecin m : meds) { System.out.println(m); }
		 */
	}


}
