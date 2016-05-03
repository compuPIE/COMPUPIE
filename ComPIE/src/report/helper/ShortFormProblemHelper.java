package report.helper;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class ShortFormProblemHelper {
	
	public void createAProblem(String problem,String recommendation, String priority,Document doc){
		Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		Font font2 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
		float[] columnWidths = { 4f, 2f, 1f };
		
		
		
		PdfPTable table = new PdfPTable(3);
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// table.setLockedWidth(true);

		Phrase problemc = new Phrase();
		problemc.add(new Chunk(problem,font2));
		PdfPCell cell0 = new PdfPCell(problemc);
		
		problemc = new Phrase();
		problemc.add(new Chunk(recommendation,font2));
		
		PdfPCell cell1 = new PdfPCell(problemc);

		cell1.setBorder(2);
		cell1.setPaddingBottom(5);

		cell0.setPaddingBottom(5);
		cell0.setBorder(2);
		cell0.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell1.setPaddingLeft(10);
		table.addCell(cell0);
		table.addCell(cell1);

		
		problemc = new Phrase();
		problemc.add(new Chunk(priority,font2));
		PdfPCell cell2 = new PdfPCell(problemc);
		cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell2.setBorder(2);
		cell2.setPaddingBottom(5);
		table.addCell(cell2);
		
		PdfPTable wholeTable = new PdfPTable(1);
		wholeTable.setWidthPercentage(100);
		PdfPCell wholeCell = new PdfPCell(table);
		wholeCell.setBorder(0);
		wholeCell.setPaddingTop(8);
		wholeCell.setPaddingLeft(20);
		wholeTable.addCell(wholeCell);
		try {
			doc.add(wholeTable);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
