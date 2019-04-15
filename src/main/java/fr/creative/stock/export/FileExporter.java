package fr.creative.stock.export;

import javax.servlet.http.HttpServletResponse;

public interface FileExporter {
	
	boolean exportData(HttpServletResponse response,String fileName,String encode);
	
	boolean exportDataPDF(HttpServletResponse response,String fileName);

	boolean importData();
}
