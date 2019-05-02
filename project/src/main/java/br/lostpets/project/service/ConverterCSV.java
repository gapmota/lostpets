package br.lostpets.project.service;

/**
 * @author gamota
 *
 */
import java.io.*;
import jxl.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class ConverterCSV {
	public ConverterCSV() {
		try {
			File f = new File("animaisPerdidos/saida.txt");

			OutputStream os = (OutputStream) new FileOutputStream(f);
			String encoding = "UTF8";
			OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
			BufferedWriter bw = new BufferedWriter(osw);

			String filename = "animaisPerdidos/entrada.xls";
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("br", "BR"));
			Workbook w = Workbook.getWorkbook(new File(filename), ws);

			for (int sheet = 0; sheet < w.getNumberOfSheets(); sheet++) {
				Sheet s = w.getSheet(sheet);

				Cell[] row = null;

				for (int i = 0; i < s.getRows(); i++) {
					row = s.getRow(i);

					if (row.length > 0) {
						bw.write(row[0].getContents());
						for (int j = 1; j < row.length; j++) {
							bw.write(';');
							bw.write(row[j].getContents());
						}
					}
					bw.newLine();
				}
			}
			bw.flush();
			bw.close();
			new ImportarAnimais();
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}