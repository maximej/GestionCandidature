package com.GeekJob.concoursDEV.entity;


import java.sql.Blob;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Concours") 
public class concours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ccs_ID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_css;
	private String nom_ccs;
	private String description_ccs;
	private int statutccs;
	private Blob image_css;
	private Integer Recruteur_ID;
	
	
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
	public int getStatutccs() {
		return statutccs;
	}
	public void setStatutccs(int statut_css) {
		this.statutccs = statut_css;
	}
	public Blob getImage_css() {
		return image_css;
	}
	public void setImage_css(Blob image_css) {
		this.image_css = image_css;
	}
	
	public Integer getRecruteur_ID() {
		return Recruteur_ID;
	}
	public void setRecruteur_ID(Integer recruteur_ID) {
		Recruteur_ID = recruteur_ID;
	}
	
	public concours() {
		super();
		date_css = new Date();
		nom_ccs = " ";
		description_ccs = " ";
		statutccs = 401;
		image_css = null;
		Recruteur_ID = 1;
	}	
	
}
