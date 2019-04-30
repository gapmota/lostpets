package br.lostpets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lostpets.project.service.ImportarAnimais;
import br.lostpets.project.service.ConverterCSV;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		// new ImportarAnimais();
		// new ConverterCSV();
	}

}
