package report;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import dao.ClientTableManipulation;
import dao.FollowUpTableManipulation;
import daoBean.ClientBean;
import report.helper.CHDCReport;
import report.helper.ClientInfoReport;
import report.helper.FactorShortReport;
import report.helper.ReportFooter;
import report.helper.ShortFormProblemHelper;
import report.helper.StrengthResourcesReport;
import uiUtil.FolderSelector;

public class ShortReport {
	static Document document = new Document();

	public void addHeading() throws DocumentException {
		Font font1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
		Paragraph heading = new Paragraph(new Phrase("CompuPIE - PIE Assessment Summary", font1));
		heading.setAlignment(1);
		document.add(heading);
		// document.n
	}

	public void addAssessmentHeading() throws DocumentException {
		Font font1 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
		Paragraph heading = new Paragraph(new Phrase("All Assessments", font1));
		heading.setSpacingAfter(10);
		heading.setAlignment(1);
		document.add(heading);
	}

	public boolean createShortAssessment(int clientID, List<Integer> followUpIds) {
		ReportFooter event = new ReportFooter();
		ClientInfoReport cReport;
		StrengthResourcesReport rep;
		CHDCReport chdc;
		try {
			FolderSelector selector = new FolderSelector();
			String path = selector.getSelectedFolder();
			ClientTableManipulation cli = new ClientTableManipulation();
			ClientBean bean = cli.getClientInfo("" + clientID);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + "/" + bean.getLastname()
					+ "," + bean.getFirstname() + "_ShortReport.pdf"));
			cReport = new ClientInfoReport(writer);
			rep = new StrengthResourcesReport(writer);
			chdc = new CHDCReport(writer);
			document.setPageSize(PageSize.A4);
			document.setMargins(30, 45, 50, 60);
			document.setMarginMirroring(false);
			writer.setPageEvent(event);
			document.open();
			// addClientInformation(bean);;
			document.newPage();
			addHeading();
			addAssessmentHeading();
			cReport.generateShortClientInfo(clientID, document);
			chdc.generateClientCaseHistory(clientID, document);
			int availableSpace = (int) (writer.getVerticalPosition(false) - document.bottomMargin() - 2);
			if (availableSpace < 100)
				document.newPage();
			FactorShortReport fReport = new FactorShortReport(writer);
			FollowUpTableManipulation foll = new FollowUpTableManipulation();
			for (int i : followUpIds) {
				Font fontx = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD | Font.UNDERLINE);
				Paragraph heading = new Paragraph(new Phrase(" Assessed " + " on :"
						+ foll.getFollowUpInfo(clientID, i).get(0).getDate() , fontx));
				heading.setAlignment(0);
				document.add(heading);
				fReport.setFactorInfo(clientID, i, document);
				fReport.createShortForFactor1(document);
				fReport.createShortForFactor2(document);
				fReport.createShortForFactor3(document);
				fReport.createShortForFactor4(document);
			}

			rep.generateStrengthAndResources(clientID, document);
			document.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		ShortReport report = new ShortReport();
		// report.createShortAssessment();
		NativeInterface.open();

		NativeInterface.open(); // not sure what else may be needed for this

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JWebBrowser fileBrowser = new JWebBrowser();
				fileBrowser.setBarsVisible(false);
				fileBrowser.setStatusBarVisible(false);
				JFrame frame = new JFrame("generated pdf");
				frame.add(fileBrowser, BorderLayout.CENTER);
				fileBrowser.navigate("C:/Users/Praveenkumar/git/comp/ComPIE/short-form.pdf#zoom=100");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				frame.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
						// window is being closed
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// window is closed
						System.exit(0);
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
					}

				});

			}
		});

	}
}
