package com.GeekJob.concoursDEV.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ville{
	
	@Id
	private int ville_id;
	private String ville_departement;
	private String ville_nom_reel;
	private String ville_code_postal;
	
    @OneToOne(targetEntity = Adresse.class, mappedBy = "maVille")
    private Adresse adresse;
	
	public Ville() {
		
	}

	public int getVille_id() {
		return ville_id;
	}

	public void setVille_ID(int ville_id) {
		this.ville_id = ville_id;
	}

	public String getVille_departement() {
		return ville_departement;
	}

	public void setVille_departement(String ville_departement) {
		this.ville_departement = ville_departement;
	}

	public String getVille_nom_reel() {
		return ville_nom_reel;
	}

	public void setVille_nom_reel(String ville_nom_reel) {
		this.ville_nom_reel = ville_nom_reel;
	}

	public String getVille_code_postal() {
		return ville_code_postal;
	}

	public void setVille_code_postal(String ville_code_postal) {
		this.ville_code_postal = ville_code_postal;
	}
}