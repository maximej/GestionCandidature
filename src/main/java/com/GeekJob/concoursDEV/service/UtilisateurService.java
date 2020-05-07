package com.GeekJob.concoursDEV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GeekJob.concoursDEV.entity.Utilisateur;
import com.GeekJob.concoursDEV.repository.UtilisateurI;

public class UtilisateurService {

	@Autowired
	private UtilisateurI util;
	
	public List<Utilisateur> listAll() {
		return util.findAll();
	}
	
	public Utilisateur getlast() {
		List<Utilisateur> users = util.findAll();
		return users.get(users.size()-1);
	}
	
}
