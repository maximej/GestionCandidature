package com.GeekJob.concoursDEV.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur",schema = "targetSchemaName")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int utilisateurId;
	private String email;
	private String motdepasse;
	private int Statut_util;

	@Override
	public String toString() {
		return "Utilisateur [utilisateurId=" + utilisateurId + ", email=" + email + ", motdepasse=" + motdepasse
				+ ", Statut_util=" + Statut_util + "]";
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateur_ID) {
		this.utilisateurId = utilisateur_ID;
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

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public int getStatut_util() {
		return Statut_util;
	}

	public void setStatut_util(int statut_util) {
		Statut_util = statut_util;
	}

	public Utilisateur(int utilisateur_ID, String email, String motdepasse, int statut_util) {
		super();
		this.utilisateurId = utilisateur_ID;
		this.email = email;
		this.motdepasse = motdepasse;
		Statut_util = statut_util;
	}

	public Utilisateur() {
		super();
	}

}
