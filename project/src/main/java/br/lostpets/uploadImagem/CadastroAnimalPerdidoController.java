package br.lostpets.uploadImagem;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.lostpets.project.repository.UserRepositoryFile;

@Controller
public class CadastroAnimalPerdidoController {
	
	private final UserRepositoryFile uploadFile;
	
	//private static String UPLOAD_FOLDER = "C:\\Users\\Aluno\\Desktop\\lostpets\\project\\src\\main\\resources\\static\\img\\animalPerdido";

	@Autowired
	public CadastroAnimalPerdidoController(UserRepositoryFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@GetMapping("/upload")
	public String listPageUpload(Model model) {
		/*
		model.addAttribute("files", uploadFile.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(CadastroAnimalPerdidoController.class, 
						"serveFile", path.getFileName().toString()).build().toString()).collect(Collectors.toList()));
						*/
		return "upload";
	}
	/*
	@GetMapping("/files/{filename:.+}") //-- /LostPets/animalPerdido
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		
		Resource file = uploadFile.loadResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\""+file.getFilename()+"\"").body(file);
		
	}
	*/
	@PostMapping("/LostPets/animalPerdido")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAtrributes) {
		
		//uploadFile.store(file);
		redirectAtrributes.addFlashAttribute("message", "You sucessfully uploaded " + file.getOriginalFilename() + "!");
		
		return "redirect:/upload";
	}
	
	/*
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc){
	
		return ResponseEntity.notFound().build();
	}
	*/
	
}
