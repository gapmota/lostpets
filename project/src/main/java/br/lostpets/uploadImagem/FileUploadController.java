/*package br.lostpets.uploadImagem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	public static String uploadDirectory = "C:\\Users\\juven\\Desktop\\IMAGEM";
	
	@RequestMapping("/")
	public String uploadPage(Model model) {
		return "uploadview";
	}
	
	@RequestMapping("/upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) throws IOException {
		 StringBuilder fileNames = new StringBuilder();
		 for(MultipartFile file : files) {
			 Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			 fileNames.append(file.getOriginalFilename()+" ");
			 Files.write(fileNameAndPath, file.getBytes());
		 }
		System.out.println("Arquivo carregado com sucesso "+fileNames.toString());
		return "redirect:/LostPets";
	}
	
}
*/