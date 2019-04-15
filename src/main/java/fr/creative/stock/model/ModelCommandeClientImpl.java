package fr.creative.stock.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import fr.creative.stock.entities.Article;
import fr.creative.stock.entities.Client;
import fr.creative.stock.entities.CommandeClient;
import fr.creative.stock.entities.LigneCommandeClient;

@Component
public class ModelCommandeClientImpl implements ModelCommandeClient {

	private CommandeClient commandeClient;
	private Map<Long, LigneCommandeClient> ligneCmde = new HashMap<Long, LigneCommandeClient>();

	@Override
	public void init() {
		commandeClient=null;
		ligneCmde.clear();
	}
	
	@Override
	public Collection<LigneCommandeClient> getLignesCommandeClient(CommandeClient commande) {
		for(LigneCommandeClient commandeClient:ligneCmde.values())
			commandeClient.setCommandeClient(commande);
		return ligneCmde.values();
	}
	
	@Override
	public void creerCommande() {
		commandeClient = new CommandeClient();
		commandeClient.setDateCommandeClient(new Date());
		commandeClient.setCode(genererCode());

	}
	
	@Override
	public void modifierCommande(Client client) {
		if (client == null) {
			return;
		}
		if (commandeClient != null) {
			commandeClient.setClient(client);
		}		
	}


	@Override
	public LigneCommandeClient ajouterLigneCommande(Article article) {
		if (article == null) {
			return null;
		}
		LigneCommandeClient lc = ligneCmde.get(article.getIdArticle());
		if (lc != null) {
			BigDecimal qte = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			ligneCmde.put(article.getIdArticle(), lc);
			return lc;
		} else {
			LigneCommandeClient ligne = new LigneCommandeClient();
			ligne.setCommandeClient(commandeClient);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaire(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneCmde.put(article.getIdArticle(), ligne);
			return ligne;
		}
	}

	@Override
	public LigneCommandeClient supprimerLigneCommande(Article article) {
		if (article == null) {
			return null;
		}
		return ligneCmde.remove(article.getIdArticle());
	}

	@Override
	public LigneCommandeClient modifierQuantite(Article article, double qte) {
		if (article == null) {
			return null;
		}
		LigneCommandeClient lc = ligneCmde.get(article.getIdArticle());
		if(lc == null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(qte));
		return lc;
	}

	@Override
	public String genererCode() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	@Override
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}
	
	
	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	@Override
	public Map<Long, LigneCommandeClient> getLigneCmde() {
		return ligneCmde;
	}

	public void setLigneCmde(Map<Long, LigneCommandeClient> ligneCmde) {
		this.ligneCmde = ligneCmde;
	}


}
