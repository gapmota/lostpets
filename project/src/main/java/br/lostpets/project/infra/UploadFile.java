 package br.lostpets.project.infra;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface UploadFile {

	void init();
	void store(MultipartFile file);
	Stream<Path> loadAll();
	Path load(String fileName);
	Resource loadResource(String fileName);
	void deleteAll();
	
}
