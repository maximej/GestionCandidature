package com.GeekJob.concoursDEV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GeekJob.concoursDEV.entity.concours;


public interface ConcoursI extends JpaRepository<concours, Integer> {

	List<concours> findBystatutccs(int statutccs);

}
