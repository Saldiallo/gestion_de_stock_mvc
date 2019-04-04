package fr.creative.stock.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneVente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneVente;
	
	
	  @ManyToOne
	  @JoinColumn(name = "idVente") 
	  private Vente vente;
	 
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;

	public Long getIdLigneVente() {
		return idLigneVente;
	}

	public void setIdLigneVente(Long idLigneVente) {
		this.idLigneVente = idLigneVente;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}
