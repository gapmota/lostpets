package br.lostpets.project.controller.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.lostpets.project.domain.User;
import br.lostpets.project.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UploadPathService uploadPathService;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User save(User user) {
		user.setDataAdicionado(new Date());
		User dbUser = userRepository.save(user);
		if(dbUser != null && user.getFiles() != null && user.getFiles().size() > 0) {
			for(MultipartFile file : user.getFiles()) {
				String fileName = file.getOriginalFilename();
				String modifiedFileName = FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);
				File storeFile = uploadPathService.getFilePath(modifiedFileName, "images");
				if(storeFile != null) {
					try {
						FileUtils.writeByteArrayToFile(storeFile, file.getBytes());
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					
					//1:13:50 https://www.youtube.com/watch?v=XZdfUqZ0CG4&t=4495s continuar
				}
			}
		}
		return null;
	}
	
	
}
