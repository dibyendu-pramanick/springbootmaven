package qcom.cas.springbootmaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qcom.cas.springbootmaven.Model.User;
import qcom.cas.springbootmaven.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping(value="")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUser(id);
	}
	
	@GetMapping(value="/age/{age}")
	public List<User> getUserByAge(@PathVariable("age") int age) {
		return userService.getUserByAge(age);
	}
	
	@PutMapping(value="/name")
	public String updateUsersName(@RequestBody User user) {
		userService.fetchAndUpdateFirstNameAndLastName(user.getId());
		return "Updated successfully";
	}
	
	@PutMapping(value="")
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "Updated successfully";
	}

}
