package fr.creative.stock.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommandeFournisseur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCommandeFournisseur;
	
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommandeClient;
	
	@ManyToOne
	@JoinColumn(name = "idFournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "commandeFournisseur")
	private Collection<LigneCommandeFournisseur> ligneCommandeFournisseurs;

	public Long getIdCommandeFournisseur() {
		return idCommandeFournisseur;
	}

	public void setIdCommandeFournisseur(Long idCommandeFournisseur) {
		this.idCommandeFournisseur = idCommandeFournisseur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateCommandeClient() {
		return dateCommandeClient;
	}

	public void setDateCommandeClient(Date dateCommandeClient) {
		this.dateCommandeClient = dateCommandeClient;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Collection<LigneCommandeFournisseur> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(Collection<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}

	
}
