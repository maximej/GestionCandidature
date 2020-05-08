package com.GeekJob.concoursDEV.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GeekJob.concoursDEV.entity.Recruteur;
import com.GeekJob.concoursDEV.entity.Utilisateur;
import com.GeekJob.concoursDEV.repository.UtilisateurI;

@Service
@Transactional
public class UtilisateurService {

	@Autowired
	private UtilisateurI util;

	public List<Utilisateur> listAll() {
		return util.findAll();
	}

	public Utilisateur getlast() {
		List<Utilisateur> users = util.findAll();
		return users.get(users.size() - 1);
	}
	
	public Utilisateur save(Utilisateur utilisateur) {
		return util.save(utilisateur);
	}

	public Utilisateur getValidCda(String email, String mdp) {
		List<Utilisateur> listUtil = util.findAll();
		for (Utilisateur utilisateur : listUtil) {
			if ((utilisateur.getEmail().equalsIgnoreCase(email)) && (utilisateur.getMotdepasse().equals(mdp))
					&& (utilisateur.getStatut_util() == 201)) {
				return utilisateur;
			}
		}
		return null;
	}
	
	public Utilisateur getValidRcu(String email, String mdp) {
		List<Utilisateur> listUtil = util.findAll();
		for (Utilisateur utilisateur : listUtil) {
			if ((utilisateur.getEmail().equalsIgnoreCase(email)) && (utilisateur.getMotdepasse().equals(mdp))
					&& (utilisateur.getStatut_util() == 301)) {
				return utilisateur;
			}
		}
		return null;
	}
	
	public Utilisateur findByEmailIgnoreCaseAndMotdepasse(String email, String motdepasse) {
		return util.findByEmailIgnoreCaseAndMotdepasse(email, motdepasse);
		
	}
}
