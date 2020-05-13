package com.GeekJob.concoursDEV.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GeekJob.concoursDEV.entity.Candidat;
import com.GeekJob.concoursDEV.entity.Candidature;
import com.GeekJob.concoursDEV.entity.Recruteur;


public interface CandidatI extends JpaRepository<Candidat, Integer> {
	
	@Query(value = "SELECT * FROM candidat c WHERE c.utilisateur_id = ?1 ", nativeQuery = true)
	Optional<Candidat> findById(Integer id);
	
	//@Query(value = "SELECT * FROM candidat c WHERE c.utilisateurid = ?1 ", nativeQuery = true)
	//List<Candidat> findById(int id);
	
}
