package report.helper;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ClientTableManipulation;
import dao.FollowUpTableManipulation;
import daoBean.ClientBean;
import daoBean.FollowUpBean;

public class ClientInfoReport  extends BaseReport{

	
	public ClientInfoReport(PdfWriter writer) {
		super(writer);
	}

	public Document generateShortClientInfo(int clientID,Document doc) throws DocumentException{
		ClientTableManipulation mani = new ClientTableManipulation();
		FollowUpTableManipulation follow = new FollowUpTableManipulation();
		FollowUpBean bean = follow.getFollowUpInfo(1, clientID).get(0);
		ClientBean info = mani.getClientInfo(""+clientID);
		Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		Font font2 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
		float[] columnWidths = { 1f, 3f, 1f };
		
		
		
		PdfPTable table = new PdfPTable(3);
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// table.setLockedWidth(true);

		Phrase client = new Phrase();
		client.add(new Chunk("Client:", font1));
		client.add(new Chunk(""+info.getLastname()+","+info.getFirstname(),font2));
		PdfPCell cell0 = new PdfPCell(client);
		
		client = new Phrase();
		client.add(new Chunk("Assessed By:", font1));
		client.add(new Chunk(""+bean.getAccessedBy(),font2));
		
		PdfPCell cell1 = new PdfPCell(client);

		cell0.setNoWrap(true);
		cell1.setNoWrap(true);
		cell1.setBorder(0);
		
		cell0.setBorder(0);
		cell0.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table.addCell(cell0);
		table.addCell(cell1);

		
		client = new Phrase();
		client.add(new Chunk("Assessed on:", font1));
		client.add(new Chunk(""+bean.getDate(),font2));
		PdfPCell cell2 = new PdfPCell(client);
		cell2.setNoWrap(true);
		cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell2.setBorder(0);
		table.addCell(cell2);
		
		PdfPTable wholeTable = new PdfPTable(1);
		wholeTable.setWidthPercentage(100);
		PdfPCell wholeCell = new PdfPCell(table);
		wholeCell.setPaddingBottom(5);
		wholeCell.setPaddingTop(5);
		wholeTable.addCell(wholeCell);
		doc.add(wholeTable);
		return doc;
	}
	
	
}
