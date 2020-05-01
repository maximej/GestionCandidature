package com.GeekJob.concoursDEV;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class concours {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ccs_ID;
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
	public String getDate_css() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		return formater.format(date_css);
	}
	public void setDate_css(String date_css) {
		try {
			this.date_css=new SimpleDateFormat("dd/MM/yyyy").parse(date_css);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
