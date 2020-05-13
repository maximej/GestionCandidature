
package com.GeekJob.concoursDEV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GeekJob.concoursDEV.entity.Candidature;
import com.GeekJob.concoursDEV.entity.Ville;

@Repository
public interface VilleI extends JpaRepository<Ville, Integer> {

	@Query(value = "SELECT * FROM ville v WHERE v.ville_nom_reel = ?1", nativeQuery = true)
	List<Ville> findByName(String name);
}
