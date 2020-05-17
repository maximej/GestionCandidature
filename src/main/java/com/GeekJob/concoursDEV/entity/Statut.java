package com.GeekJob.concoursDEV.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "statut") 
public class Statut {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statut_ID;
	private String nom_statut;
	private String description_statut;
	
    @OneToMany(targetEntity = Candidature.class, mappedBy = "Statut_cdu")
	private List<Candidature> mesCdu;

    
	public Statut() {
	}
	
    
	public Statut(int statut_ID) {
		super();
		this.statut_ID = statut_ID;
	}

	public int getStatut_ID() {
		return statut_ID;
	}

	public void setStatut_ID(int statut_ID) {
		this.statut_ID = statut_ID;
	}

	public String getNom_statut() {
		return nom_statut;
	}

	public void setNom_statut(String nom_statut) {
		this.nom_statut = nom_statut;
	}

	public String getDescription() {
		return description_statut;
	}

	public void setDescription(String description_statut) {
		this.description_statut = description_statut;
	}

	public List<Candidature> getMesCdu() {
		return mesCdu;
	}

	public void setMesCdu(List<Candidature> mesCdu) {
		this.mesCdu = mesCdu;
	}


	@Override
	public String toString() {
		return nom_statut;
	}
	
    
    
    
    
}