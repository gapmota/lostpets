package br.lostpets.project.service;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportarPDF {

	public ExportarPDF(String nomeCartaz, String siteAnimalPerdido) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream("animaisPerdidos/Cartazes/" + nomeCartaz + ".pdf"));
			document.open();

			Paragraph pTitulo = (new Paragraph(
					new Phrase(30F, "Animal perdido", FontFactory.getFont(FontFactory.HELVETICA, 28F))));
			pTitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(pTitulo);

			Paragraph pData = (new Paragraph("Perdido no dia: 13/05/2019",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
			pData.setAlignment(Element.ALIGN_CENTER);
			document.add(pData);

			BarcodeQRCode barcodeQRCode = new BarcodeQRCode(siteAnimalPerdido, 1000, 1000, null);
			Image codeQrImage = barcodeQRCode.getImage();
			codeQrImage.setAbsolutePosition(490, 0);
			codeQrImage.scaleAbsolute(100, 100);
			document.add(codeQrImage);

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}
}