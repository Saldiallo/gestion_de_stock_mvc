package fr.creative.stock.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;
	
	private String nom,prenom,adresse,mail,photo;
	
	@OneToMany(mappedBy = "client")
	Collection<CommandeClient> commandeClients;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	@JsonIgnore
	public Collection<CommandeClient> getCommandeClients() {
		return commandeClients;
	}

	public void setCommandeClients(Collection<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

}
