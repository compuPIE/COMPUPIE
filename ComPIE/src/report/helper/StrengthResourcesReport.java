package report.helper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import dao.StrengthResourceManipulation;
import daoBean.StrengthAndResourcesBean;

public class StrengthResourcesReport extends BaseReport {

	public StrengthResourcesReport(PdfWriter writer) {
		super(writer);
	}

	public void generateStrengthAndResources(int clientid, Document doc) throws DocumentException {
		checkLengthCosmetic(doc);
		StrengthResourceManipulation mani = new StrengthResourceManipulation();
		StrengthAndResourcesBean bean = mani.getStrength(clientid);
		Font font1 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD | Font.UNDERLINE);
		Paragraph heading = new Paragraph(new Phrase("Strength and Resources", font1));
		heading.setAlignment(0);
		doc.add(heading);
		generateFactor1Strengths(clientid, doc, bean.getFactor1(), "Factor I: Social Role and Relationship");
		checkLengthCosmetic(doc);
		generateFactor1Strengths(clientid, doc, bean.getFactor2(), "Factor II - Environmental");
		checkLengthCosmetic(doc);
		generateFactor34Strengths(clientid, doc, bean.getFactor3(), "Factor III - Mental Health Functioning");
		checkLengthCosmetic(doc);
		generateFactor34Strengths(clientid, doc, bean.getFactor4(), "Factor IV - Physical Health Functioning");
		checkLengthCosmetic(doc);

	}

	private void generateFactor1Strengths(int clientid, Document doc, String value, String title)
			throws DocumentException {
		Font font3 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
		Font font4 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		Font font5 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
		String[] splits = value.split(":");
		Phrase titl = new Phrase();
		titl.add(new Phrase(title, font4));
		doc.add(new Paragraph(titl));
		Paragraph child = new Paragraph();
		for (String s1 : splits) {
			String[] s = s1.split("-");
			if (s.length > 1) {
				child.add(new Phrase((s[0] + ": "), font5));
				String sp[] = s[1].split(",");
				for (String str : sp) {
					if (child.isEmpty()) {
						child.add(new Phrase(str, font3));
					} else {
						child.add(new Phrase((" ," + str), font3));
					}
				}
				if (!child.isEmpty()) {
					child.add(new Phrase(("\n"), font3));
					child.setAlignment(Element.ALIGN_JUSTIFIED);
					child.setIndentationLeft(10);
					doc.add(child);
					child = new Paragraph();
				}
			}
		}
	}

	private void generateFactor34Strengths(int clientid, Document doc, String value, String title)
			throws DocumentException {
		Font font3 = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
		Font font4 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		String[] splits = value.split(":");
		Phrase titl = new Phrase();
		titl.add(new Phrase(title, font4));
		doc.add(new Paragraph(titl));
		Paragraph child = new Paragraph();
		for (String s1 : splits) {
			String[] s = s1.split("-");
			String sp[] = s[0].split(",");
			for (String str : sp) {
				if (child.isEmpty()) {
					child.add(new Phrase(str, font3));
				} else {
					child.add(new Phrase((" ," + str), font3));
				}
			}
			child.setAlignment(Element.ALIGN_JUSTIFIED);
			child.setIndentationLeft(10);
			doc.add(child);
		}

	}

}
