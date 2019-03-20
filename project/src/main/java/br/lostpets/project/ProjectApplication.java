package br.lostpets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lostpets.project.controller.HistoricoAcessoLog;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		HistoricoAcessoLog hal = new HistoricoAcessoLog();
		String[][] acesso = new String[1][3];
		// Setar a matriz com os dados: acesso[dados][dados]
		acesso[0][0] = "Nome";
		acesso[0][1] = "Data";
		acesso[0][2] = "Hora";
		for (int l = 0; l < acesso.length; l++) {
			hal.pularLinha();
			for (int c = 0; c < acesso[l].length; c++) {
				hal.escreverLog(acesso[l][c]);
			}
		}
	}

}
