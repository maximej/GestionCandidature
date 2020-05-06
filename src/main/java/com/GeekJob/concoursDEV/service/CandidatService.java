package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Candidat;
import com.GeekJob.concoursDEV.repository.CandidatI;


@Service
@Transactional
public class CandidatService {
	
	@Autowired
	private CandidatI mesCda;
	
	public List<Candidat> listAll() {
		return mesCda.findAll();
	}
	
	public void save(Candidat monCda) {
		mesCda.save(monCda);
	}
	
	public Candidat get(Integer id) {
		return mesCda.findById(id).get();
	}
	
	public void delete(Integer id) {
		mesCda.deleteById(id);
	}
}
