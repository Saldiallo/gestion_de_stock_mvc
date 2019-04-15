package fr.creative.stock.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fr.creative.stock.entities.Fournisseur;
import fr.creative.stock.service.IFournisseurService;
import fr.creative.stock.service.IFlickrService;

@Controller
@RequestMapping(value = "/fournisseur")
public class FournisseurController {

	@Autowired
	private IFournisseurService fournisseurService;
	@Autowired
	private IFlickrService flickrService;

	@RequestMapping(value = "/fournisseur")
	public String fournisseur(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if (null == fournisseurs) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs", fournisseurs);
		return "fournisseur/fournisseur";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterFournisseur(Model model) {
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/ajouterFournisseur";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Fournisseur fournisseur, MultipartFile file) {
		String photoUrl = null;
		if (fournisseur != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, fournisseur.getNom());
					fournisseur.setPhoto(photoUrl);
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
			if(fournisseur.getIdFournisseur()!=null) {
				fournisseurService.update(fournisseur);
			}else {
				fournisseurService.save(fournisseur);
			}
		}

		return "redirect:/fournisseur/";
	}

	@RequestMapping(value = "/modifier/{id}")
	public String modifierFournisseur(Model model, @PathVariable("id") Long idFournisseur) {
		//
		if (idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if (fournisseur != null) {
				model.addAttribute("fournisseur", fournisseur);
			}
		}
		return "fournisseur/ajouterFournisseur";
	}
	
	@RequestMapping(value = "/supprimer/{id}")
	public String removeFournisseur(Model model,@PathVariable("id") Long idFournisseur) {
		if(idFournisseur!=null) {
			Fournisseur fournisseur=fournisseurService.getById(idFournisseur);
			if(fournisseur!=null) {
				fournisseurService.remove(idFournisseur);
			}
		}
		return  "redirect:/fournisseur/";
	}

}
