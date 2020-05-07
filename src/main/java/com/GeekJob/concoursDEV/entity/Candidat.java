package com.GeekJob.concoursDEV.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Candidat {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cda_ID;
	private String nom_cda;
	private String prenom_cda;
	private int securite_sociale;
	private String genre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_naissance;
	private String telephone;
	private String facebook;
	private String instagram;
	private String twitter;
	private String cv;
	private String biographie;
	private int etude;
	private int Statut_cda;
	private int Utilisateur_ID;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id")
	private Adresse monAdresse;
	
	public Candidat() {
		
	}
	
	
	
	public int getStatut_cda() {
		return Statut_cda;
	}



	public void setStatut_cda(int statut_cda) {
		Statut_cda = statut_cda;
	}



	public int getUtilisateur_ID() {
		return Utilisateur_ID;
	}



	public void setUtilisateur_ID(int utilisateur_ID) {
		Utilisateur_ID = utilisateur_ID;
	}



	public int getCda_ID() {
		return cda_ID;
	}
	public void setCda_ID(int cda_ID) {
		this.cda_ID = cda_ID;
	}
	public String getNom_cda() {
		return nom_cda;
	}
	public void setNom_cda(String nom_cda) {
		this.nom_cda = nom_cda;
	}
	public String getPrenom_cda() {
		return prenom_cda;
	}
	public void setPrenom_cda(String prenom_cda) {
		this.prenom_cda = prenom_cda;
	}
	public int getSecurite_sociale() {
		return securite_sociale;
	}
	public void setSecurite_sociale(int securite_sociale) {
		this.securite_sociale = securite_sociale;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public int getEtude() {
		return etude;
	}
	public void setEtude(int etude) {
		this.etude = etude;
	}
	public Adresse getMonAdresse() {
		return monAdresse;
	}
	public void setMonAdresse(Adresse monAdresse) {
		this.monAdresse = monAdresse;
	}



	public Date getDate_naissance() {
		return date_naissance;
	}



	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getBiographie() {
		return biographie;
	}



	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}
	
	public String getCv() {
		return cv;
	}



	public void setCv(String cv) {
		this.cv = cv;
	}

	
	
	
}