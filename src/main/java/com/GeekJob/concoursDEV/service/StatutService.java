package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Statut;
import com.GeekJob.concoursDEV.repository.StatutI;

@Service
@Transactional
public class StatutService {
	
	@Autowired
	private StatutI mesStatuts;
	
	public List<Statut> listAll() {
		return mesStatuts.findAll();
	}
	
	public Statut get(Integer id) {
		return mesStatuts.findById(id).get();
	}

	public List<Statut> findStatutListe(String entityName) {
		return mesStatuts.finfStatutList(entityName);
	}
	
	public Statut finfByStatutID(Integer id) {
		return mesStatuts.finfByStatutID(id);
	}

}
