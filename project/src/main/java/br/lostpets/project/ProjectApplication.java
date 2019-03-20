package br.lostpets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lostpets.project.controller.HistoricoAcessoLog;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		/*String[][] acesso = new String[1][3];
		// Setar a matriz com os dados: acesso[dados][dados]
		for (int l = 0; l < acesso.length; l++) {
			for (int c = 0; c < acesso[l].length; c++) {
				new HistoricoAcessoLog(acesso[l][c]);
			}
		}*/
	}

}
