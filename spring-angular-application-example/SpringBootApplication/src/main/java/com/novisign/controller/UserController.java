package com.novisign.controller;

import java.util.List;

import com.novisign.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.novisign.model.UserEntity;
import com.novisign.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService userService;

	private AuthenticationManager authenticationManager;

	@PostMapping("create-user")
	@ResponseStatus(value = HttpStatus.CREATED)
	public UserEntity registerUser(@RequestBody UserEntity userEntityVO) {

		return this.userService.insert(userEntityVO);
	}

	@GetMapping(value = "/users")
	@ResponseStatus(value = HttpStatus.OK)
	public List<UserEntity> findAllUser() {

		return this.userService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public UserEntity findById(@PathVariable int id) {
		return this.userService.findById(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity userEntityVO) {

		return this.userService.updateUser(id, userEntityVO);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int id) {

		this.userService.delete(id);
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userDTO.getUsername(),
						userDTO.getPassword()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);


		return ResponseEntity.ok().build();
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logoutUser() {

		return new ResponseEntity(HttpStatus.OK); // todo amirn - complete
	}


}
