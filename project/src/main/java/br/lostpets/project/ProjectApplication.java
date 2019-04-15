package br.lostpets.project;

//import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.context.annotation.ComponentScan;

import br.lostpets.uploadImagem.FileUploadController;*/

@SpringBootApplication
//@ComponentScan({"br.lostpets.project","br.lostpets.uploadImagem"})
public class ProjectApplication {

	public static void main(String[] args) {
		//new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(ProjectApplication.class, args);
	}
	
}
