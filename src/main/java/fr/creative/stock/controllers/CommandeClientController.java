package fr.creative.stock.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.creative.stock.entities.Article;
import fr.creative.stock.entities.Client;
import fr.creative.stock.entities.CommandeClient;
import fr.creative.stock.entities.LigneCommandeClient;
import fr.creative.stock.model.ModelCommandeClient;
import fr.creative.stock.model.StringResponse;
import fr.creative.stock.service.IArticleService;
import fr.creative.stock.service.IClientService;
import fr.creative.stock.service.ICommandeClientService;
import fr.creative.stock.service.ILigneCommandeClientService;

@Controller
@RequestMapping(value = "/commandeClient")
public class CommandeClientController {
	@Autowired
	ICommandeClientService commandeClientService;
	@Autowired
	ILigneCommandeClientService lignecommandeClientService;
	@Autowired
	IArticleService articleService;	
	@Autowired
	private IClientService clientService;
	@Autowired
	private ModelCommandeClient modelCommandeClient;
	
	@RequestMapping(value = "/commandeClient")
	public String commandeClient(Model model) {
		List<CommandeClient> commandeClients=commandeClientService.selectAll();
		if(commandeClients.isEmpty()) {
			commandeClients=new ArrayList<CommandeClient>();
		}else {
			for(CommandeClient commandeClient:commandeClients) {
				List<LigneCommandeClient> ligneCommandeClients=
						lignecommandeClientService.getByIdCommande(commandeClient.getIdCommandeClient());
 				commandeClient.setLigneCommandeClients(ligneCommandeClients);
			}
		}
		model.addAttribute("commandeClients", commandeClients);		
		return "commandeClient/commandeClient";
	}
	
	@RequestMapping(value = "/nouveau")
	public String newCommande(Model model) {
		List<Client> clients=clientService.selectAll();
		if(clients.isEmpty())
			clients=new ArrayList<Client>();
		modelCommandeClient.creerCommande();
		model.addAttribute("code",modelCommandeClient.getCommandeClient().getCode());
		model.addAttribute("dateCommande", modelCommandeClient.getCommandeClient().getDateCommandeClient());
		model.addAttribute("clients", clients);
		return "commandeClient/nouvelleCommande";
	}
	
	@RequestMapping(value = "/creerCommande")
	@ResponseBody
	public String creerCommande(final Long idClient) {
		if(idClient==null) {
			return null;
		}
		Client client=clientService.getById(idClient);
		if(client==null) {
			return null;
		}
		return "OK";
	}
	
	@RequestMapping(value = "/ajouterLigne")
	@ResponseBody
	public LigneCommandeClient getArticleByCode(final String codeArticle) {
		if(codeArticle==null)
			return null;
		Article article=articleService.findOne("codeArticle", codeArticle);
		if(codeArticle==null)
			return null;
		return modelCommandeClient.ajouterLigneCommande(article);
		
	}
	
	@RequestMapping(value = "/supprimerLigne")
	@ResponseBody
	public LigneCommandeClient supprimerLigneCommande(final Long idArticle) {
		if (idArticle == null) {
			return null;
		}
		Article article = articleService.getById(idArticle);
		if (article == null) {
			return null;
		}
		return modelCommandeClient.supprimerLigneCommande(article);
	}
	
	@RequestMapping(value = "/enregisterCammande",produces = "application/json")
	@ResponseBody
	public StringResponse enregistrerCommande(HttpServletRequest request) {
		CommandeClient nouvelleCommande = null;
		if (modelCommandeClient.getCommandeClient() != null) {
			nouvelleCommande = commandeClientService.save(modelCommandeClient.getCommandeClient());
		}
		if (nouvelleCommande != null) {
			Collection<LigneCommandeClient> ligneCommandes = modelCommandeClient.getLignesCommandeClient(nouvelleCommande);
			if (ligneCommandes != null && !ligneCommandes.isEmpty()) {
				for (LigneCommandeClient ligneCommandeClient : ligneCommandes) {
					lignecommandeClientService.save(ligneCommandeClient);
				}
				modelCommandeClient.init();
			}
		}
		
		return new StringResponse(request.getContextPath() + "/commandeClient");
	}
}
