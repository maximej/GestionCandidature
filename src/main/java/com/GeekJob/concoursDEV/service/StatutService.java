package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.StatutCandidature;
import com.GeekJob.concoursDEV.repository.StatutI;

@Service
@Transactional
public class StatutService {
	
	@Autowired
	private StatutI mesStatuts;
	
	public List<StatutCandidature> listAll() {
		return mesStatuts.findAll();
	}
	
	public StatutCandidature get(Integer id) {
		return mesStatuts.findById(id).get();
	}

}
