package com.GeekJob.concoursDEV.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "ville") 
public class Ville{
	
	@Id
	private int ville_id;
	private String ville_departement;
	private String ville_nom_reel;
	private String ville_code_postal;
	
    @OneToMany(targetEntity = Adresse.class, mappedBy = "maVille")
    private List<Adresse> adresse;
	
	public Ville() {
			}	
	
	public Ville(int id) {
		this.ville_id = id;
	}	
	
	public Ville(int ville_id, String ville_departement, String ville_nom_reel, String ville_code_postal) {
		super();
		this.ville_id = ville_id;
		this.ville_departement = ville_departement;
		this.ville_nom_reel = ville_nom_reel;
		this.ville_code_postal = ville_code_postal;
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

	public List<Adresse> getAdresse() {
		return adresse;
	}

	public void setAdresse(List<Adresse> adresse) {
		this.adresse = adresse;
	}

	public void setVille_id(int ville_id) {
		this.ville_id = ville_id;
	}
	

	public int getVille_id() {
		return ville_id;
	}
	
	
}