package fr.creative.stock.model;

import java.util.Collection;
import java.util.Map;

import fr.creative.stock.entities.Article;
import fr.creative.stock.entities.Client;
import fr.creative.stock.entities.CommandeClient;
import fr.creative.stock.entities.LigneCommandeClient;

public interface ModelCommandeClient {
	
	void creerCommande();
	void modifierCommande(Client client);
	LigneCommandeClient ajouterLigneCommande(Article article);
	LigneCommandeClient supprimerLigneCommande(Article article);
	LigneCommandeClient modifierQuantite(Article article,double qte);
	String genererCode();
	CommandeClient getCommandeClient();

	Map<Long, LigneCommandeClient> getLigneCmde();
	
	Collection<LigneCommandeClient> getLignesCommandeClient(CommandeClient commande);
	
	void init();

}
