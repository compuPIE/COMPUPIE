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

public class FactorLongReport extends BaseReport{
	public FactorLongReport(PdfWriter writer) {
		super(writer);
	}

	private int clientId;
	private int followup;

	public void setFactorInfo(int clientId, int followUp, Document doc) throws DocumentException {
		checkLengthCosmetic(doc);
		this.clientId = clientId;
		this.followup = followUp;
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
		heading.setSpacingAfter(10);
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
			sb.append(bean.getCopingAbitity() + " Coping Skills.");
			helper.createALongProblem(sb.toString(), bean.getRecommendedInter(),bean.getExpectedOutcome(),bean.getGoal(), bean.getPriority(), doc);
		}
		checkLengthCosmetic(doc);
	}

}
