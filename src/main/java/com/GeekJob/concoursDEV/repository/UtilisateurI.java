package com.GeekJob.concoursDEV.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GeekJob.concoursDEV.entity.Utilisateur;

public interface UtilisateurI extends JpaRepository<Utilisateur, Integer>{
	Utilisateur findByEmailIgnoreCaseAndMotdepasse(String email, String motdepasse);
}
