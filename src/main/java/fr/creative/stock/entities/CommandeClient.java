package fr.creative.stock.entities;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Entity
public class CommandeClient implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCommandeClient;
	
	private String code;

	@Transient
	private BigDecimal totalCommande;
	
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

	@JsonIgnore
	public Collection<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(Collection<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	public BigDecimal getTotalCommande() {
		totalCommande=BigDecimal.ZERO;
		if(!ligneCommandeClients.isEmpty()) {
			for(LigneCommandeClient ligneCommandeClient:ligneCommandeClients) {
				if(ligneCommandeClient.getQuantite()!=null && ligneCommandeClient.getPrixUnitaire()!=null) {
					BigDecimal totaleLigne=ligneCommandeClient.getQuantite().multiply(ligneCommandeClient.getPrixUnitaire());
					totalCommande=totalCommande.add(totaleLigne);
				}
			}
		}
		return totalCommande;
	}
	
	@Transient
	public String getLigneCommandeJson() {
		if (!ligneCommandeClients.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(ligneCommandeClients);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
}
