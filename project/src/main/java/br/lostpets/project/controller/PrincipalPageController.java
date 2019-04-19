package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalPageController {

	@GetMapping("/Dashboard")
	public String openDashboardGet() {
		return "paginaPrincipal";
	}

}
