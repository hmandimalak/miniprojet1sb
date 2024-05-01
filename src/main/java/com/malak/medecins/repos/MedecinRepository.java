package com.malak.medecins.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.malak.medecins.entities.Faculte;
import com.malak.medecins.entities.Medecin;
@RepositoryRestResource(path = "rest")

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	List<Medecin> findByNomMedecin(String nom);
	List<Medecin> findByNomMedecinContains(String nom);
	/*@Query("select m from Medecin m where m.nomMedecin like %?1 and m.specialite > ?2")
	List<Medecin> findBySpecialite (String nom, String specialite);*/
	
	@Query("select m from Medecin m where m.nomMedecin like %:nom and m.specialite > :specialite")
	List<Medecin> findBySpecialite (@Param("nom") String nom,@Param("specialite") String specialite);
	
	@Query("select m from Medecin m where m.faculte = ?1")
	List<Medecin> findByFaculte (Faculte faculte);
	
	List<Medecin> findByFaculteId(Long id);
	
	List<Medecin> findByOrderByNomMedecinAsc();
	
	@Query("select m from Medecin m order by m.nomMedecin ASC, m.specialite DESC")
	List<Medecin> trierProduitsSpecialite ();

}
