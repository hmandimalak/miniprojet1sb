package com.malak.medecins.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malak.medecins.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
