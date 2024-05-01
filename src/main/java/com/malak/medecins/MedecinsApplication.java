package com.malak.medecins;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.malak.medecins.entities.Medecin;
import com.malak.medecins.service.MedecinService;

@SpringBootApplication
public class MedecinsApplication  implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	MedecinService medecinService;

	public static void main(String[] args) {
		SpringApplication.run(MedecinsApplication.class, args);
	}
	
	
		
	@Override
	public void run(String... args) throws Exception {
		medecinService.saveMedecin(new Medecin("selim", "chirurgien", new Date()));
		medecinService.saveMedecin(new Medecin("khaled", "pediatre", new Date()));
		medecinService.saveMedecin(new Medecin("othman", "generaliste", new Date()));
		repositoryRestConfiguration.exposeIdsFor(Medecin.class);
	}

}
