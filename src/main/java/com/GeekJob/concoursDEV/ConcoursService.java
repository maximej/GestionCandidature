package com.GeekJob.concoursDEV;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConcoursService {
	
	@Autowired
	private ConcoursI ccs;
	
	public List<concours> listAll() {
		return ccs.findAll();
	}
	
	public void save(concours concour) {
		ccs.save(concour);
	}
	
	public concours get(Integer id) {
		return ccs.findById(id).get();
	}
	
	public void delete(Integer id) {
		ccs.deleteById(id);
	}
}
