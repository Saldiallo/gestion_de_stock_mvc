package fr.creative.stock.export;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import fr.creative.stock.entities.Article;
import fr.creative.stock.service.IArticleService;
import fr.creative.stock.utils.ApplicationConstants;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("articleExporter")
public class ArticleExporter implements FileExporter {

	@Autowired
	private IArticleService articleService;

	private static final String FILE_NAME = "Liste_des_Articles";

	@Override
	public boolean exportData(HttpServletResponse response, String fileName, String encode) {
		if (StringUtils.isEmpty(fileName))
			fileName = FILE_NAME;
		if (StringUtils.isEmpty(encode)) {
			encode = ApplicationConstants.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachement; filename = " + fileName + ".xls");
		WorkbookSettings settings = new WorkbookSettings();
		settings.setEncoding(encode);
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(), settings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);

			/*
			 * Cellule pour l'entête
			 */
			Label labelCode = new Label(0, 0, ApplicationConstants.CODE_ARTICLE);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);

			Label labelDesignation = new Label(1, 0, ApplicationConstants.DESIGNATION);
			labelDesignation.setCellFeatures(new WritableCellFeatures());
			labelDesignation.getCellFeatures().setComment("");
			sheet.addCell(labelDesignation);

			Label labelPrixHT = new Label(2, 0, ApplicationConstants.PRIX_UNIT_HT);
			labelPrixHT.setCellFeatures(new WritableCellFeatures());
			labelPrixHT.getCellFeatures().setComment("");
			sheet.addCell(labelPrixHT);

			Label labelPrixTTC = new Label(3, 0, ApplicationConstants.PRIX_UNIT_TTC);
			labelPrixTTC.setCellFeatures(new WritableCellFeatures());
			labelPrixTTC.getCellFeatures().setComment("");
			sheet.addCell(labelPrixTTC);

			Label labelTaux = new Label(4, 0, ApplicationConstants.TVA);
			labelTaux.setCellFeatures(new WritableCellFeatures());
			labelTaux.getCellFeatures().setComment("");
			sheet.addCell(labelTaux);

			Label labelCategorie = new Label(5, 0, ApplicationConstants.CATEGORIE);
			labelCategorie.setCellFeatures(new WritableCellFeatures());
			labelCategorie.getCellFeatures().setComment("");
			sheet.addCell(labelCategorie);

			int CurrentRow = 1;

			List<Article> articles = articleService.selectAll();
			if (!articles.isEmpty() && articles != null) {
				/*
				 * Ecrire dans la feuille excel
				 */
				for (Article article : articles) {
					sheet.addCell(new Label(0, CurrentRow, article.getCodeArticle()));
					sheet.addCell(new Label(1, CurrentRow, article.getDesignation()));
					sheet.addCell(new Label(2, CurrentRow, article.getPrixUnitaireHT().toString()));
					sheet.addCell(new Label(3, CurrentRow, article.getPrixUnitaireTTC().toString()));
					sheet.addCell(new Label(4, CurrentRow, article.getTaux().toString()));
					sheet.addCell(new Label(5, CurrentRow, article.getCategorie().getCodeCat()));
					CurrentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);

				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				sheet.setColumnView(3, cellView);
				sheet.setColumnView(4, cellView);
				sheet.setColumnView(5, cellView);

				/*
				 * Ecrire dans la feuille excel
				 */
				workbook.write();

				workbook.close();

				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean importData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportDataPDF(HttpServletResponse response, String fileName) {
		if (StringUtils.isEmpty(fileName))
			fileName = FILE_NAME;
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachement; filename = " + fileName + ".pdf");
		Document doc = new Document(PageSize.A4, 15, 15, 30, 45);
		try {
			PdfWriter writer = PdfWriter.getInstance(doc,null);
			doc.open();

			Font font = FontFactory.getFont("Arial", 10, Color.BLACK);
			Paragraph paragraph = new Paragraph("Liste des Articles", font);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			doc.add(paragraph);

			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);

			docHeader(doc, table);

			List<Article> articles = articleService.selectAll();
			if (!articles.isEmpty() && articles != null) {
				for (Article article : articles) {
					docBody(doc, table, article);
				}
				doc.add(table);
			}
			doc.close();
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void docBody(Document doc, PdfPTable table, Article article) {
		Font tableBody = FontFactory.getFont("Arial", 9, Color.BLACK);

		PdfPCell codeArticle = new PdfPCell(new Paragraph(article.getCodeArticle(), tableBody));
		codeArticle.setBorderColor(Color.BLACK);
		codeArticle.setPaddingLeft(10);
		codeArticle.setHorizontalAlignment(Element.ALIGN_CENTER);
		codeArticle.setVerticalAlignment(Element.ALIGN_CENTER);
		codeArticle.setBackgroundColor(Color.GRAY);
		codeArticle.setExtraParagraphSpace(5f);
		table.addCell(codeArticle);

		PdfPCell designation = new PdfPCell(new Paragraph(article.getDesignation(), tableBody));
		designation.setBorderColor(Color.BLACK);
		designation.setPaddingLeft(10);
		designation.setHorizontalAlignment(Element.ALIGN_CENTER);
		designation.setVerticalAlignment(Element.ALIGN_CENTER);
		designation.setBackgroundColor(Color.GRAY);
		designation.setExtraParagraphSpace(5f);
		table.addCell(designation);

		PdfPCell prixUnitaireHT = new PdfPCell(new Paragraph(article.getPrixUnitaireHT().toString(), tableBody));
		prixUnitaireHT.setBorderColor(Color.BLACK);
		prixUnitaireHT.setPaddingLeft(10);
		prixUnitaireHT.setHorizontalAlignment(Element.ALIGN_CENTER);
		prixUnitaireHT.setVerticalAlignment(Element.ALIGN_CENTER);
		prixUnitaireHT.setBackgroundColor(Color.GRAY);
		prixUnitaireHT.setExtraParagraphSpace(5f);
		table.addCell(prixUnitaireHT);

		PdfPCell prixUnitaireTTC = new PdfPCell(new Paragraph(article.getPrixUnitaireTTC().toString(), tableBody));
		prixUnitaireTTC.setBorderColor(Color.BLACK);
		prixUnitaireTTC.setPaddingLeft(10);
		prixUnitaireTTC.setHorizontalAlignment(Element.ALIGN_CENTER);
		prixUnitaireTTC.setVerticalAlignment(Element.ALIGN_CENTER);
		prixUnitaireTTC.setBackgroundColor(Color.GRAY);
		prixUnitaireTTC.setExtraParagraphSpace(5f);
		table.addCell(prixUnitaireTTC);

		PdfPCell tva = new PdfPCell(new Paragraph(article.getTaux().toString(), tableBody));
		tva.setBorderColor(Color.BLACK);
		tva.setPaddingLeft(10);
		tva.setHorizontalAlignment(Element.ALIGN_CENTER);
		tva.setVerticalAlignment(Element.ALIGN_CENTER);
		tva.setBackgroundColor(Color.GRAY);
		tva.setExtraParagraphSpace(5f);
		table.addCell(tva);

		PdfPCell categorie = new PdfPCell(new Paragraph(article.getCategorie().getCodeCat(), tableBody));
		categorie.setBorderColor(Color.BLACK);
		categorie.setPaddingLeft(10);
		categorie.setHorizontalAlignment(Element.ALIGN_CENTER);
		categorie.setVerticalAlignment(Element.ALIGN_CENTER);
		categorie.setBackgroundColor(Color.GRAY);
		categorie.setExtraParagraphSpace(5f);
		table.addCell(categorie);

	}

	private void docHeader(Document doc, PdfPTable table) throws DocumentException {

		Font tableHeader = FontFactory.getFont("Arial", 10, Color.BLACK);

		PdfPCell codeArticle = new PdfPCell(new Paragraph("Code Article", tableHeader));
		codeArticle.setBorderColor(Color.BLACK);
		codeArticle.setPaddingLeft(10);
		codeArticle.setHorizontalAlignment(Element.ALIGN_CENTER);
		codeArticle.setVerticalAlignment(Element.ALIGN_CENTER);
		codeArticle.setBackgroundColor(Color.GRAY);
		codeArticle.setExtraParagraphSpace(5f);
		table.addCell(codeArticle);

		PdfPCell designation = new PdfPCell(new Paragraph("Désignation", tableHeader));
		designation.setBorderColor(Color.BLACK);
		designation.setPaddingLeft(10);
		designation.setHorizontalAlignment(Element.ALIGN_CENTER);
		designation.setVerticalAlignment(Element.ALIGN_CENTER);
		designation.setBackgroundColor(Color.GRAY);
		designation.setExtraParagraphSpace(5f);
		table.addCell(designation);

		PdfPCell prixUnitaireHT = new PdfPCell(new Paragraph("Prix UnitaireHT", tableHeader));
		prixUnitaireHT.setBorderColor(Color.BLACK);
		prixUnitaireHT.setPaddingLeft(10);
		prixUnitaireHT.setHorizontalAlignment(Element.ALIGN_CENTER);
		prixUnitaireHT.setVerticalAlignment(Element.ALIGN_CENTER);
		prixUnitaireHT.setBackgroundColor(Color.GRAY);
		prixUnitaireHT.setExtraParagraphSpace(5f);
		table.addCell(prixUnitaireHT);

		PdfPCell prixUnitaireTTC = new PdfPCell(new Paragraph("Prix UnitaireTTC", tableHeader));
		prixUnitaireTTC.setBorderColor(Color.BLACK);
		prixUnitaireTTC.setPaddingLeft(10);
		prixUnitaireTTC.setHorizontalAlignment(Element.ALIGN_CENTER);
		prixUnitaireTTC.setVerticalAlignment(Element.ALIGN_CENTER);
		prixUnitaireTTC.setBackgroundColor(Color.GRAY);
		prixUnitaireTTC.setExtraParagraphSpace(5f);
		table.addCell(prixUnitaireTTC);

		PdfPCell tva = new PdfPCell(new Paragraph("Tva", tableHeader));
		tva.setBorderColor(Color.BLACK);
		tva.setPaddingLeft(10);
		tva.setHorizontalAlignment(Element.ALIGN_CENTER);
		tva.setVerticalAlignment(Element.ALIGN_CENTER);
		tva.setBackgroundColor(Color.GRAY);
		tva.setExtraParagraphSpace(5f);
		table.addCell(tva);

		PdfPCell categorie = new PdfPCell(new Paragraph("Catégorie", tableHeader));
		categorie.setBorderColor(Color.BLACK);
		categorie.setPaddingLeft(10);
		categorie.setHorizontalAlignment(Element.ALIGN_CENTER);
		categorie.setVerticalAlignment(Element.ALIGN_CENTER);
		categorie.setBackgroundColor(Color.GRAY);
		categorie.setExtraParagraphSpace(5f);
		table.addCell(categorie);
	}

}
