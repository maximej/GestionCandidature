package com.GeekJob.concoursDEV.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Adresse;
import com.GeekJob.concoursDEV.repository.AdresseI;


@Service
@Transactional
public class AdresseService {
	
	@Autowired
	private AdresseI mesAdresses;
	
	
	
	public Adresse save(Adresse monAdresse) {
		monAdresse = mesAdresses.save(monAdresse);
		return monAdresse;
	}

}
