package report.helper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import dao.MentalStatusExamManipulation;
import daoBean.MentalStatusExamBean;

public class MSEReport extends BaseReport {

	public MSEReport(PdfWriter writer) {
		super(writer);
		// TODO Auto-generated constructor stub
	}

	public void createMSEReport(int clientId, Document doc) throws DocumentException {
		Font font4 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		Font font5 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);

		Font font1 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD | Font.UNDERLINE);
		Paragraph heading = new Paragraph(new Phrase("Mental Status Exam:", font1));
		heading.setAlignment(0);
		doc.add(heading);
		

		MentalStatusExamManipulation mani = new MentalStatusExamManipulation();
		MentalStatusExamBean bean = mani.getStrength(clientId);
		if (bean != null) {
			String test = bean.getProblemStr();
			String[] sp = test.split("#");
			for (String s : sp) {
				String[] ss = s.split("_");
				if (ss.length > 1) {
					Phrase titl = new Phrase();
					titl.add(new Phrase(ss[0], font4));
					doc.add(new Paragraph(titl));

					Paragraph child = new Paragraph();
					if (ss[0].contains("RISK OF")) {

						String[] g = ss[1].split(":");
						if (g[0] != null && !g[0].equalsIgnoreCase("")) {
							child.add(new Phrase(g[0], font5));
							doc.add(child);
						}
						child = new Paragraph();
						child.add(new Phrase("Risk Level : " + g[1], font5));
						doc.add(child);

					} else {
						if (ss[1] != null && !ss[1].equalsIgnoreCase("")) {
							child.add(new Phrase(ss[1], font5));
							doc.add(child);
						}
					}
				}
			}
		}
		checkLengthCosmetic(doc);

	}

}
