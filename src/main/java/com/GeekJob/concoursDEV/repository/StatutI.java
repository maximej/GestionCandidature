package com.GeekJob.concoursDEV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GeekJob.concoursDEV.entity.Statut;

@Repository
public interface StatutI extends JpaRepository<Statut, Integer> {

	@Query(value = "SELECT statut FROM Statut statut where statut.statut_ID = ?1")
	Statut finfByStatutID(Integer id);

	@Query(value = "SELECT statut FROM Statut statut where statut.nom_statut like CONCAT('%',?1,'%')")
	List<Statut> finfStatutList(String entityName);
}
