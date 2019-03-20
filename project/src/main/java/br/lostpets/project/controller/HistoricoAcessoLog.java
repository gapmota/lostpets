package br.lostpets.project.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class HistoricoAcessoLog {
	File arquivo;
	FileReader fileReader;
	BufferedReader bufferedReader;
	FileWriter fileWriter;
	BufferedWriter bufferedWriter;

	public HistoricoAcessoLog(String dados) {

		escreverLog(dados);
	}

	private void escreverLog(String historicoAcesso) {

		try {
			arquivo = new File("log/historico_acesso.log");
			fileReader = new FileReader(arquivo);
			bufferedReader = new BufferedReader(fileReader);
			Vector<String> texto = new Vector<String>();
			while (bufferedReader.ready()) {
				texto.add(bufferedReader.readLine());
			}
			fileWriter = new FileWriter(arquivo);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < texto.size(); i++) {
				bufferedWriter.write(texto.get(i).toString() + " | ");
			}
			bufferedWriter.write(historicoAcesso);
			bufferedWriter.close();
			bufferedReader.close();
			System.out.println("Arquivo gerado com sucesso!");
		} catch (FileNotFoundException e) {

			try {
				arquivo.createNewFile();
				escreverLog(historicoAcesso);
			} catch (IOException e1) {
				System.out.println("Deu ruim");
				System.exit(0);
			}
		} catch (IOException er) {
			System.out.println("Deu ruim");
			System.exit(0);
		}
	}
}
