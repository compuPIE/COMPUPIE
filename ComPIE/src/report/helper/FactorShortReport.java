package report.helper;

import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.Factor1TableManipulation;
import daoBean.Factor1Bean;

public class FactorShortReport extends BaseReport {

	public FactorShortReport(PdfWriter writer) {
		super(writer);
	}

	private int clientId;
	private int followup;

	public void setFactorInfo(int clientId, int followUp, Document doc) throws DocumentException {
		checkLengthCosmetic(doc);
		this.clientId = clientId;
		this.followup = followUp;
		Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD | Font.UNDERLINE);
		float[] columnWidths = { 4f, 2f, 1f };
		PdfPTable table = new PdfPTable(3);
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Phrase problemc = new Phrase();
		problemc.add(new Chunk("", font1));
		PdfPCell cell0 = new PdfPCell(problemc);
		problemc = new Phrase();
		problemc.add(new Chunk("Recommendation", font1));
		PdfPCell cell1 = new PdfPCell(problemc);
		cell1.setBorder(0);
		cell0.setBorder(0);
		cell0.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingLeft(15);
		table.addCell(cell0);
		table.addCell(cell1);
		problemc = new Phrase();
		problemc.add(new Chunk("Priority", font1));
		PdfPCell cell2 = new PdfPCell(problemc);
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setBorder(0);
		table.addCell(cell2);
		PdfPTable wholeTable = new PdfPTable(1);
		wholeTable.setWidthPercentage(100);
		PdfPCell wholeCell = new PdfPCell(table);
		wholeCell.setBorder(0);
		wholeTable.addCell(wholeCell);
		try {
			doc.add(wholeTable);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param clientId
	 * @param followUp
	 * @param doc
	 * @param fontx
	 * @throws DocumentException
	 */
	public void createShortForFactor1(Document doc) throws DocumentException {
		Font fontx = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD | Font.UNDERLINE);
		ShortFormProblemHelper helper = new ShortFormProblemHelper();
		Paragraph heading = new Paragraph(new Phrase("Factor I: Social Role and Relationship", fontx));
		heading.setAlignment(0);
		doc.add(heading);

		Factor1TableManipulation mani = new Factor1TableManipulation();
		List<Factor1Bean> list = mani.getFactorInfoForFollowup(this.clientId, this.followup);

		for (Factor1Bean bean : list) {
			StringBuffer sb = new StringBuffer();
			sb.append(bean.getProblemType() + " Role,");
			sb.append(bean.getSocialRoleProblemType() + " Type,");
			sb.append(bean.getServerity() + " Severity,");
			sb.append(bean.getDuration() + " Duration,");
			sb.append(bean.getCopingAbitity() + " Coping Skills,");
			helper.createAProblem(sb.toString(), bean.getRecommendedInter(), bean.getPriority(), doc);
		}
		checkLengthCosmetic(doc);
	}

}
