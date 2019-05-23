package br.lostpets.project.service;

/**
 * @author gamota
 *
 */
import java.io.*;
import jxl.*;
import java.util.*;

import org.springframework.stereotype.Component;

import br.lostpets.project.model.PetPerdido;

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
			ImportarAnimais();
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public void ImportarAnimais() {
		Scanner in = null;

		try {
			in = new Scanner(new FileReader("animaisPerdidos/saida.txt")).useDelimiter(";|\\r\\n");
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Erro ao abrir arquivo.");
			System.exit(1);
		}

		PetPerdido pet = new PetPerdido(null, null, null, null, null, null, null, null, null);

		System.out.printf("%-24s%-60s%-15s%7s\n", "Nome do animal", "Descricao", "Tipo de animal", "CEP");

		try {
			while (in.hasNext()) {

				pet.setNomeAnimal(in.next());
				pet.setDescricao(in.next());
				pet.setTipoAnimal(in.next());
				pet.setCep(in.next());

				System.out.printf("%-24s%-60s%-17s%12s\n", pet.getNomeAnimal(), pet.getDescricao(), pet.getTipoAnimal(),
						pet.getCep());
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("Arquivo com problemas.");
			in.close();
			System.exit(1);
		} catch (IllegalStateException stateException) {
			System.err.println("Erro na leitura do arquivo.");
			System.exit(1);
		}

		if (in != null)
			in.close();
	}
}