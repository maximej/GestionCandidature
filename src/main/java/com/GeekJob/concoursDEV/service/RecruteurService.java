package com.GeekJob.concoursDEV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.GeekJob.concoursDEV.entity.Recruteur;
import com.GeekJob.concoursDEV.repository.RecruteurI;
import com.GeekJob.concoursDEV.repository.StatutI;

@Service
@Transactional
public class RecruteurService {
	
	@Autowired
	private RecruteurI RcuList;
	
	@Autowired
	private StatutI stuList;
	
	public List<Recruteur> listAll() {
		return RcuList.findAll();
	}
	
	public List<Recruteur> listAllCda() {
		return RcuList.Statutrcu(301);
	}
	
	public List<Recruteur> listByEmail() {
		return RcuList.sortByEmail();
	}
	
	public List<Recruteur> listByStatut() {
		return RcuList.sortByStatut();
	}
	
	public List<Recruteur> listByID() {
		return RcuList.sortByID();
	}
	
	public void save(Recruteur recruteur) {
		RcuList.save(recruteur);
	}
	
	public Recruteur get(Integer id) {
		return RcuList.findByRcuID(id);
	}
	
	public void delete(Integer id) {
		Recruteur recruteur = RcuList.findById(id).get();
		recruteur.setStatutrcu(stuList.finfByStatutID(303));
	}
	
	public Recruteur getlast() {
		int c = (int) RcuList.count();
		return RcuList.getOne(c);
	}

	public Recruteur findByRcuID(int rcuID) {
		if(rcuID != 0) {
		return RcuList.findByRcuID(rcuID);
		}
		return null;
	}

	public Recruteur finfByUtilID(int utilId){
		return RcuList.finfByUtilID(utilId);
	}
	
}
