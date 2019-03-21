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
		acesso[0][0] = "Josue";
		acesso[0][1] = "21/03/2019";
		acesso[0][2] = "10:30";

		hal.escreverLog(acesso);
	}

}
