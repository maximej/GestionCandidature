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

@Entity
@Table(name = "Adresse") 
public class Adresse{
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adresse_ID;
	private String numero;
	private String rue;
	private String complement;
	
    @OneToOne(targetEntity = Candidat.class, mappedBy = "monAdresse")
    private Candidat monCandidat;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ville_id")
	private Ville maVille;
	
	public Adresse() {
		
	}
	
	public Adresse(int adresse_ID, String numero, String rue, String complement, Candidat monCandidat, Ville maVille) {
		super();
		this.adresse_ID = adresse_ID;
		this.numero = numero;
		this.rue = rue;
		this.complement = complement;
		this.monCandidat = monCandidat;
		this.maVille = maVille;
	}



	
	public Candidat getMonCandidat() {
		return monCandidat;
	}

	public void setMonCandidat(Candidat monCandidat) {
		this.monCandidat = monCandidat;
	}

	public Ville getMaVille() {
		return maVille;
	}

	public void setMaVille(Ville maVille) {
		this.maVille = maVille;
	}

	public int getAdresse_ID() {
		return adresse_ID;
	}

	public void setAdresse_ID(int adresse_ID) {
		this.adresse_ID = adresse_ID;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Ville getVille() {
		return maVille;
	}

	public void setVille(Ville maVille) {
		this.maVille = maVille;
	}

	public void setVille(int maVilleId) {
		this.maVille = new Ville(maVilleId);
	}

	
}
	