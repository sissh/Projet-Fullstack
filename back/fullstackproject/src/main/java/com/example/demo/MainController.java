package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@PostMapping("/users")
	void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@GetMapping("/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/usertypes")
	void addUserType(@RequestBody UserType userType) {
		userTypeRepository.save(userType);
	}
	
	@GetMapping({ "/usertypes", "/adduser" })
	public @ResponseBody Iterable<UserType> getAllUserTypes() {
		return userTypeRepository.findAll();
	}
	
	@GetMapping("/adduser:id={id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping("/addtypes:type={type}")
	public void deleteType(@PathVariable String type) {
		Iterable<UserType> userTypes = userTypeRepository.findAll();
		UserType userTypeToDelete = new UserType();
		for(UserType userType : userTypes) {
			if (userType.getType().equals(type)) {
				userTypeToDelete = userType;
			}
 		}
		userTypeRepository.delete(userTypeToDelete);
	}
	
	@PostMapping("/adduser:id={id}")
	public void editUser(@PathVariable Integer id, @RequestBody User changedUser) {
		User user = userRepository.findById(id).get();
		user.setName(changedUser.getName());
		user.setFirstName(changedUser.getFirstName());
		user.setEmail(changedUser.getEmail());
		user.setUserType(changedUser.getUserType());
		userRepository.save(user);
	}
	
	@PostMapping("/addtype:type={type}")
	public void editUserType(@PathVariable String type, @RequestBody UserType changedUserType) {
		Iterable<UserType> userTypes = userTypeRepository.findAll();
		UserType userTypeToEdit = new UserType();
		for(UserType userType : userTypes) {
			if (userType.getType().equals(type)) {
				userTypeToEdit = userType;
			}
 		}
		userTypeToEdit.setType(changedUserType.getType());
		userTypeToEdit.setDescription(changedUserType.getDescription());
		userTypeRepository.save(userTypeToEdit);
	}
    
}
