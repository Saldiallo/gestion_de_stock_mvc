package fr.creative.stock.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeClient implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneCdeClt;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idCommandeClient")
	private CommandeClient commandeClient;

	public Long getIdLigneCdeClt() {
		return idLigneCdeClt;
	}

	public void setIdLigneCdeClt(Long idLigneCdeClt) {
		this.idLigneCdeClt = idLigneCdeClt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

}
