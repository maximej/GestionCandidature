package com.GeekJob.concoursDEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GeekJob.concoursDEV.entity.concours;


public interface ConcoursI extends JpaRepository<concours, Integer> {

}
