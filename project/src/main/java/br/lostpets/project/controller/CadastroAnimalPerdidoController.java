package br.lostpets.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import br.lostpets.project.infra.UploadFile;

@Controller
public class CadastroAnimalPerdidoController {
	
	private final UploadFile uploadFile;
	
	private static String UPLOAD_FOLDER = "C:\\Users\\juven\\Desktop\\lostpets\\project\\src\\main\\resources\\static\\img\\imgAnimaisPerdidos";

	@Autowired
	public CadastroAnimalPerdidoController(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@GetMapping("/upload")
	public String listPageUpload(Model model) {
		
		model.addAttribute("files", uploadFile.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(CadastroAnimalPerdidoController.class, 
						"serveFile", path.getFileName().toString()).build().toString()).collect(Collectors.toList()));
		return "upload";
	}
	
	
	
}
