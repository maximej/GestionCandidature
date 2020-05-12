package com.GeekJob.concoursDEV.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidature {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cdu_ID;
/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cda")
	private Candidat cda;
	*/
	private int cda;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ccs")
	private concours ccs;

	private String fichier_CV;
	private Date date_transmis;
	private Date date_traitement;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Statut_cdu")
	private StatutCandidature Statut_cdu;
	
	public Candidature() {
		
	}
	
	public Candidature(Candidat cda, concours ccs) {
		
		
		
	}

	public int getCdu_ID() {
		return cdu_ID;
	}

	public void setCdu_ID(int cdu_ID) {
		this.cdu_ID = cdu_ID;
	}

	public int getCda() {
		return cda;
	}

	public void setCda(int cda) {
		this.cda = cda;
	}



	public concours getCcs() {
		return ccs;
	}

	public void setCcs(concours ccs) {
		this.ccs = ccs;
	}

	public String getFichier_CV() {
		return fichier_CV;
	}

	public void setFichier_CV(String fichier_CV) {
		this.fichier_CV = fichier_CV;
	}

	public Date getDate_transmis() {
		return date_transmis;
	}

	public void setDate_transmis(Date date_transmis) {
		this.date_transmis = date_transmis;
	}

	public Date getDate_traitement() {
		return date_traitement;
	}

	public void setDate_traitement(Date date_traitement) {
		this.date_traitement = date_traitement;
	}

	public StatutCandidature getStatut_cdu() {
		return Statut_cdu;
	}

	public void setStatut_cdu(StatutCandidature statut_cdu) {
		Statut_cdu = statut_cdu;
	}
	
	
	
}