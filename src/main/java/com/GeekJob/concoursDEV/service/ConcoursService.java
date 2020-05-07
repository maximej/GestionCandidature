package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.concours;
import com.GeekJob.concoursDEV.repository.ConcoursI;

@Service
@Transactional
public class ConcoursService {
	
	@Autowired
	private ConcoursI ccs;
	
	public List<concours> listAll() {
		return ccs.findAll();
	}
	
	public List<concours> listAllCda() {
		return ccs.findBystatutccs(401);
	}
	
	public void save(concours concour) {
		ccs.save(concour);
	}
	
	public concours get(Integer id) {
		return ccs.findById(id).get();
	}
	
	public void delete(Integer id) {
		concours concour = ccs.findById(id).get();
		concour.setStatutccs(403);
	}
	
	public concours getlast() {
		int c = (int) ccs.count();
		return ccs.getOne(c);
	}
}
