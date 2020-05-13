package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Ville;
import com.GeekJob.concoursDEV.repository.VilleI;

@Service
@Transactional
public class VilleService {
	
	@Autowired
	private VilleI mesVilles;
	
	public List<Ville> listAll() {
		return mesVilles.findAll();
	}
	
	public Ville get(Integer id) {
		return mesVilles.findById(id).get();
	}
	
	public Ville get(String nom) {
		return mesVilles.findByName(nom).get(0);
	}

}
