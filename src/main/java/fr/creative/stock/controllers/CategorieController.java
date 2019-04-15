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

import fr.creative.stock.entities.Categorie;
import fr.creative.stock.service.ICategorieService;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

	@Autowired
	private ICategorieService categorieService;

	@RequestMapping(value = "/categorie")
	public String categorie(Model model) {
		List<Categorie> categories = categorieService.selectAll();
		if (null == categories) {
			categories = new ArrayList<Categorie>();
		}
		model.addAttribute("categories", categories);
		return "categorie/categorie";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCategorie(Model model) {
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "categorie/ajouterCategorie";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Categorie categorie) {
		if (categorie != null) {
			if(categorie.getIdCategorie()!=null) {
				categorieService.update(categorie);
			}else {
				categorieService.save(categorie);
			}
		}

		return "redirect:/categorie/";
	}

	@RequestMapping(value = "/modifier/{id}")
	public String modifierCategorie(Model model, @PathVariable("id") Long idCategorie) {
		//
		if (idCategorie != null) {
			Categorie categorie = categorieService.getById(idCategorie);
			if (categorie != null) {
				model.addAttribute("categorie", categorie);
			}
		}
		return "categorie/ajouterCategorie";
	}
	
	@RequestMapping(value = "/supprimer/{id}")
	public String removeCategorie(Model model,@PathVariable("id") Long idCategorie) {
		if(idCategorie!=null) {
			Categorie categorie=categorieService.getById(idCategorie);
			if(categorie!=null) {
				categorieService.remove(idCategorie);
			}
		}
		return  "redirect:/categorie/";
	}

}
