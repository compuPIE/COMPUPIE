package pages.helper;

import java.io.FileOutputStream;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class DrawLineUsingPdfContentBytePDF {

  public static void main(String[] args) throws Exception{
      Rectangle pageSize = new Rectangle(780, 525);
      Document document = new Document();

      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("DrawLineUsingPdfContentBytePDF.pdf"));
      document.open();

      PdfContentByte cb = writer.getDirectContent();
      cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
      cb.moveTo(370, 0);
      cb.lineTo(370, 525);
      cb.moveTo(410, 525);
      cb.lineTo(410, 0);
      //cb.stroke();

      document.close();
  }
}