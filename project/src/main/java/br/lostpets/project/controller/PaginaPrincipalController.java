package br.lostpets.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaginaPrincipalController {

	@GetMapping("/Dashboard")
	public String openDashboardGet() {
		return "paginaPrincipal";
	}
	
	@PostMapping("/Dashboard")
	public String openDashboard() {
		return "paginaPrincipal";
	}
	
}
