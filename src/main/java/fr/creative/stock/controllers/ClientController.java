package fr.creative.stock.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fr.creative.stock.entities.Client;
import fr.creative.stock.service.IClientService;
import fr.creative.stock.service.IFlickrService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/client")
	public String client(Model model) {
		List<Client> clients = clientService.selectAll();
		if (null == clients) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "client/client";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "client/ajouterClient";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Client client, MultipartFile file) {
		String photoUrl = null;
		if (client != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			if(client.getIdClient()!=null) {
				clientService.update(client);
			}else {
				clientService.save(client);
			}
		}

		return "redirect:/client/";
	}

	@RequestMapping(value = "/modifier/{id}")
	public String modifierClient(Model model, @PathVariable("id") Long idClient) {
		//
		if (idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null) {
				model.addAttribute("client", client);
			}
		}
		return "client/ajouterClient";
	}
	
	@RequestMapping(value = "/supprimer/{id}")
	public String removeClient(Model model,@PathVariable("id") Long idClient) {
		if(idClient!=null) {
			Client client=clientService.getById(idClient);
			if(client!=null) {
				clientService.remove(idClient);
			}
		}
		return  "redirect:/client/";
	}

}
