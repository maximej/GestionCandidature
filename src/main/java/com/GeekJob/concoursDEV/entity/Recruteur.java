package com.GeekJob.concoursDEV.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recruteur")
public class Recruteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rcuID;
	private int statutrcu;
	private int utilisateur_ID;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_ID", insertable=false, updatable=false)
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
	public int getStatutrcu() {
		return statutrcu;
	}
	public void setStatutrcu(int statutrcu) {
		this.statutrcu = statutrcu;
	}
	public int getUtilisateur_ID() {
		return utilisateur_ID;
	}
	public void setUtilisateur_ID(int utilisateur_ID) {
		this.utilisateur_ID = utilisateur_ID;
	}
	
	public Recruteur(int rcu_ID, int statutrcu, int utilisateur_ID) {
		super();
		this.rcuID = rcu_ID;
		this.statutrcu = statutrcu;
		this.utilisateur_ID = utilisateur_ID;
	}
	public Recruteur() {
		super();
	}
	
}
