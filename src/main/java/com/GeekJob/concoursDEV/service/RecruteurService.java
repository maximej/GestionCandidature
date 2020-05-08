package com.GeekJob.concoursDEV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.GeekJob.concoursDEV.entity.Recruteur;
import com.GeekJob.concoursDEV.repository.RecruteurI;

@Service
@Transactional
public class RecruteurService {
	
	@Autowired
	private RecruteurI RcuList;
	
	public List<Recruteur> listAll() {
		return RcuList.findAll();
	}
	
	public List<Recruteur> listAllCda() {
		return RcuList.Statutrcu(301);
	}
	
	public void save(Recruteur recruteur) {
		RcuList.save(recruteur);
	}
	
	public Recruteur get(Integer id) {
		return RcuList.findByRcuID(id).get();
	}
	
	public void delete(Integer id) {
		Recruteur recruteur = RcuList.findById(id).get();
		recruteur.setStatutrcu(303);
	}
	
	public Recruteur getlast() {
		int c = (int) RcuList.count();
		return RcuList.getOne(c);
	}

}
