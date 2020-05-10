package com.GeekJob.concoursDEV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GeekJob.concoursDEV.entity.concours;


public interface ConcoursI extends JpaRepository<concours, Integer> {

	@Query(value = "SELECT ccs FROM concours ccs WHERE ccs.statutccs = ?1 ORDER BY date_css")
	List<concours> findBystatutccs(int statutccs);
	
	@Query(value = "SELECT ccs FROM concours ccs WHERE ccs.statutccs = ?1 ORDER BY nom_ccs")
	List<concours> findBystatutccsNom(int statutccs);
	
	@Query(value = "SELECT ccs FROM concours ccs ORDER BY nom_ccs")
	List<concours> findAllccsSortnom();
	
	@Query(value = "SELECT ccs FROM concours ccs ORDER BY date_css")
	List<concours> sortBydate();
	
	@Query(value = "SELECT ccs FROM concours ccs ORDER BY statutccs")
	List<concours> sortByStatut();
}
