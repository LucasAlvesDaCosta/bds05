package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserControllers {

	@Autowired
	private UserService service;
	
	@PreAuthorize("hasAnyRole('VISITOR','MEMBER')")
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> profileForCurrentUser() {
		UserDTO dto = service.profileForCurrentUser();
		return ResponseEntity.ok().body(dto);
	}
}
