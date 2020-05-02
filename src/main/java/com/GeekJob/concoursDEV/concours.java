package com.GeekJob.concoursDEV;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class concours {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ccs_ID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_css;
	private String nom_ccs;
	private String description_ccs;
	private int statut_css;
	private Blob image_css;
	private String Recruteur_ID;
	
	
	public int getCcs_ID() {
		return ccs_ID;
	}
	public void setCcs_ID(int ccs_ID) {
		this.ccs_ID = ccs_ID;
	}
	public Date getDate_css() {
		return date_css;
	}
	public void setDate_css(Date date_css) {
			this.date_css=date_css;
	}
	public String getNom_ccs() {
		return nom_ccs;
	}
	public void setNom_ccs(String nom_ccs) {
		this.nom_ccs = nom_ccs;
	}
	public String getDescription_ccs() {
		return description_ccs;
	}
	public void setDescription_ccs(String description_ccs) {
		this.description_ccs = description_ccs;
	}
	public int getStatut_css() {
		return statut_css;
	}
	public void setStatut_css(int statut_css) {
		this.statut_css = statut_css;
	}
	public Blob getImage_css() {
		return image_css;
	}
	public void setImage_css(Blob image_css) {
		this.image_css = image_css;
	}
	
	public String getRecruteur_ID() {
		return Recruteur_ID;
	}
	public void setRecruteur_ID(String recruteur_ID) {
		Recruteur_ID = recruteur_ID;
	}	
	
}
