package fr.creative.stock.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFournisseur;
	
	private String nom,prenom,adresse,mail,photo;
	
	@OneToMany(mappedBy = "fournisseur")
	Collection<CommandeFournisseur> commandeFournisseurs;

	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Collection<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(Collection<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}
	
	

}
