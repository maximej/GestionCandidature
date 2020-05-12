package com.GeekJob.concoursDEV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GeekJob.concoursDEV.entity.Candidature;


public interface CandidatureI extends JpaRepository<Candidature, Integer> {

	List<Candidature> findByCda(int id);
	
	
}
