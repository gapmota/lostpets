/*package br.lostpets.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.lostpets.project.controller.service.UserService;
import br.lostpets.project.domain.User;
import br.lostpets.project.domain.UserFiles;

@Controller
public class SpringFileUploadController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/")
	public String user(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		model.addAttribute("userFiles", new ArrayList<UserFiles>());
		model.addAttribute("isAdd", true);
		
		return "loginPage";
	}
	
}
*/