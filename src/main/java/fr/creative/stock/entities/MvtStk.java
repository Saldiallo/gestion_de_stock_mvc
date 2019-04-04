package fr.creative.stock.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
public class MvtStk implements Serializable{
	
	public static final int ENTREE=1;
	public static final int SORTIE=2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMvtStk;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvt;
	
	private BigInteger quantite;
	
	private int typeMvt;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;

	public Long getIdMvtStk() {
		return idMvtStk;
	}

	public void setIdMvtStk(Long idMvtStk) {
		this.idMvtStk = idMvtStk;
	}

	public Date getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}

	public BigInteger getQuantite() {
		return quantite;
	}

	public void setQuantite(BigInteger quantite) {
		this.quantite = quantite;
	}

	public int getTypeMvt() {
		return typeMvt;
	}

	public void setTypeMvt(int typeMvt) {
		this.typeMvt = typeMvt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	

}
