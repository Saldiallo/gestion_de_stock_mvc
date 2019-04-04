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
public class CommandeClient implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCommandeClient;
	
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommandeClient;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	@OneToMany(mappedBy = "commandeClient")
	private Collection<LigneCommandeClient> ligneCommandeClients;

	public Long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(Long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(Collection<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}
}
