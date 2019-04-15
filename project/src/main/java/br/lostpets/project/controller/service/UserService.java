package br.lostpets.project.controller.service;

import java.util.List;

import br.lostpets.project.domain.User;

public interface UserService {

	List<User> getAllUsers();
	User save(User user);

}
