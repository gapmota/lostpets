package br.lostpets.project.controller.service;

import java.io.File;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UploadPathServiceImpl implements UploadPathService {

	@Autowired
	private ServletContext context;
	
	@Override
	public File getFilePath(String modifiedFileName, String path) {
		boolean exists = new File(context .getRealPath("/"+path+"/")).exists();
		if(!exists) {
			new File(context.getRealPath("/"+path+"/")).mkdir();
		}
		String modifiedFilePath = context.getRealPath("/" + path + File.separator + modifiedFileName);
		File file = new File(modifiedFilePath);
		return file;
	}

}
