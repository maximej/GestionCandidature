package com.GeekJob.concoursDEV.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int utilisateur_ID ;
	private String email;
	private String motdepasse;
	private int Statut_util;
	
	public int getUtilisateur_ID() {
		return utilisateur_ID;
	}
	public void setUtilisateur_ID(int utilisateur_ID) {
		this.utilisateur_ID = utilisateur_ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String mot_de_passe) {
		this.motdepasse = mot_de_passe;
	}
	public int getStatut_util() {
		return Statut_util;
	}
	public void setStatut_util(int statut_util) {
		Statut_util = statut_util;
	}
	
	public Utilisateur(String email, String motdepasse, int statut_util) {
		super();
		this.email = email;
		this.motdepasse = motdepasse;
		Statut_util = statut_util;
	}
	public Utilisateur() {
		super();
	}
	
	
}
