package com.GeekJob.concoursDEV.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

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
	private int statut_css;
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
	public int getStatut_css() {
		return statut_css;
	}
	public void setStatut_css(int statut_css) {
		this.statut_css = statut_css;
	}
	public Blob getImage_css() {
		return image_css;
	}
	public void setImage_css(String URL) {
		try {
			System.out.print(URL);
			this.image_css = new SerialBlob(Files.readAllBytes(Paths.get(URL)));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		};
	}
	
	public Integer getRecruteur_ID() {
		System.out.print("-------------------------------------."+Recruteur_ID);
		return Recruteur_ID;
	}
	public void setRecruteur_ID(Integer recruteur_ID) {
		System.out.print(recruteur_ID);
		Recruteur_ID = recruteur_ID;
	}
	
	public concours() {
		super();
		date_css = new Date();
		nom_ccs = " ";
		description_ccs = " ";
		statut_css = 401;
		image_css = null;
		Recruteur_ID = 1;
	}	
	
}
