package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Candidature;
import com.GeekJob.concoursDEV.repository.CandidatureI;


@Service
@Transactional
public class CandidatureService {
	
	@Autowired
	private CandidatureI mesCdu;
	
	public List<Candidature> listAll() {
		return mesCdu.findAll();
	}
	
	public List<Candidature> listByCda(int id) {
		return mesCdu.findByCda(id);
	}
	
	public void save(Candidature maCdu) {
		mesCdu.save(maCdu);
	}
	
	public Candidature get(Integer id) {
		return mesCdu.findById(id).get();
	}
	
	public void delete(Integer id) {
		mesCdu.deleteById(id);
	}
}
