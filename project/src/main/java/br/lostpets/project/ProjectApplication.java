package br.lostpets.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importação da classe de conversão
// import br.lostpets.project.service.ConverterCSV;

// Importação da classe de gerar cartaz de procurado em PDF
import br.lostpets.project.service.ExportarPDF;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProjectApplication.class, args);

		// Quando o usuário clicar em importar arquivo
		// new ConverterCSV();
		
		// Quando o usuário terminar o cadastro e clicar em "Imprimir cartaz de procurado"
		new ExportarPDF("procurado_nomeAnimal_idAnimal", "https://localAnimalPerdidoNoSite.com.br", "caminhoImgAnimal");
	}

}
