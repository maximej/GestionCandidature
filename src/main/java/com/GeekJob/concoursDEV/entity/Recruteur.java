package com.GeekJob.concoursDEV.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruteur", schema = "targetSchemaName")
public class Recruteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rcuID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statutrcu")
	private Statut statutrcu;
	
	private int utilisateurId;
	
	@ManyToOne
	@JoinColumn(name = "utilisateurId", insertable=false, updatable=false)
	private Utilisateur utilRcu;
	
	public Utilisateur getUtilRcu() {
		return utilRcu;
	}
	public void setUtilRcu(Utilisateur utilRcu) {
		this.utilRcu = utilRcu;
	}
	
	public int getRcuID() {
		return rcuID;
	}
	public void setRcuID(int rcuID) {
		this.rcuID = rcuID;
	}
	public Statut getStatutrcu() {
		return statutrcu;
	}
	
	public void setStatutrcu(Statut stu) {
		this.statutrcu = stu;
	}
	public int getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(int utilisateur_ID) {
		this.utilisateurId = utilisateur_ID;
	}
	
	public Recruteur(int rcu_ID, int statutrcu, int utilisateur_ID) {
		super();
		this.rcuID = rcu_ID;
		this.statutrcu.setStatut_ID(statutrcu);
		this.utilisateurId = utilisateur_ID;
	}
	
	public Recruteur() {
		super();
	}
	
}
