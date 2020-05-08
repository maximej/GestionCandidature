package com.GeekJob.concoursDEV.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GeekJob.concoursDEV.entity.Recruteur;

public interface RecruteurI extends JpaRepository<Recruteur, Integer>{

	List<Recruteur> Statutrcu(int i);
	Optional<Recruteur> findByRcuID(Integer id);

}
