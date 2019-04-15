package fr.creative.stock.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fr.creative.stock.entities.Article;
import fr.creative.stock.entities.Categorie;
import fr.creative.stock.export.FileExporter;
import fr.creative.stock.service.IArticleService;
import fr.creative.stock.service.ICategorieService;
import fr.creative.stock.service.IFlickrService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategorieService categorieService;
	@Autowired
	private IFlickrService flickrService;
	@Autowired
	@Qualifier("articleExporter")
	private FileExporter filexporter;

	@RequestMapping(value = "/article")
	public String article(Model model) {
		List<Article> articles = articleService.selectAll();
		if (null == articles) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);
		return "article/article";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterArticle(Model model) {
		Article article = new Article();
		List<Categorie> categories=categorieService.selectAll();
		if(categories.isEmpty()) {
			categories=new ArrayList<Categorie>();
		}
		model.addAttribute("categories",categories);
		model.addAttribute("article", article);
		return "article/ajouterArticle";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if (article != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, article.getCodeArticle());
					article.setPhoto(photoUrl);
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
			if(article.getIdArticle()!=null) {
				articleService.update(article);
			}else {
				articleService.save(article);
			}
		}

		return "redirect:/article/";
	}

	@RequestMapping(value = "/modifier/{id}")
	public String modifierArticle(Model model, @PathVariable("id") Long idArticle) {
		//
		if (idArticle != null) {
			Article article = articleService.getById(idArticle);
			List<Categorie> categories=categorieService.selectAll();
			if(categories.isEmpty()) {
				categories=new ArrayList<Categorie>();
			}
			model.addAttribute("categories",categories);
			if (article != null) {
				model.addAttribute("article", article);
			}
		}
		return "article/ajouterArticle";
	}
	
	@RequestMapping(value = "/supprimer/{id}")
	public String removeArticle(Model model,@PathVariable("id") Long idArticle) {
		if(idArticle!=null) {
			Article article=articleService.getById(idArticle);
			if(article!=null) {
				articleService.remove(idArticle);
			}
		}
		return  "redirect:/article/";
	}
	
	@RequestMapping(value = "/export")
	public String exportArticleToExcel(HttpServletResponse response) {
		filexporter.exportData(response, null, null);
		return "article/article";
	}
	
	@RequestMapping(value = "/exportToPDF")
	public String exportArticleToPDF(HttpServletResponse response) {
		filexporter.exportDataPDF(response, null);
		return "article/article";
	}
	
	@RequestMapping(value = "/import")
	public String importData(Model model, Article article, MultipartFile file) {
		
		
		return  "redirect:/article/";
	}

}
