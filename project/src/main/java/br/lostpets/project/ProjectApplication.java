package br.lostpets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Importação da classe de conversão
//import br.lostpets.project.service.ConverterCSV;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		// Quando o usuário clicar em importar arquivo
		// new ConverterCSV();
	}

}
