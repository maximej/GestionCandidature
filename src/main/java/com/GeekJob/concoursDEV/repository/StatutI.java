package com.GeekJob.concoursDEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GeekJob.concoursDEV.entity.StatutCandidature;

@Repository
public interface StatutI extends JpaRepository<StatutCandidature, Integer> {

}
