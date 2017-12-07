package io.nagarro.exit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nagarro.exit.model.User;
import io.nagarro.exit.service.UserService;
import io.nagarro.exit.shared.IController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController implements IController {

	@Autowired
	public UserService userService;

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#sayHi()
	 */
	@RequestMapping("/abc")
	public String sayHi() {
		return userService.sayHi();
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#createUser(io.nagarro.exit.model.User)
	 */
	@PostMapping("/register")
	public User createUser(@Valid @RequestBody User user) {
		return userService.register(user);
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#getAllUser()
	 */
	@RequestMapping("/getall")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#doRecharge(io.nagarro.exit.model.User)
	 */
	@PutMapping("/recharge")
	public User doRecharge(@Valid @RequestBody User user) {
		return userService.doRecharge(user);
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#updateBalance(io.nagarro.exit.model.User)
	 */
	@PutMapping("/user")
	public User updateBalance(@RequestBody User user) {
		return userService.updateBalance(user);
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#BlockBetAmount(io.nagarro.exit.model.User)
	 */
	@PutMapping("/blockedAmount")
	public User BlockBetAmount(@Valid @RequestBody User user) {
		return userService.BlockBetAmount(user);
	}

	/*
	 * (non-Javadoc)
	 * @see io.nagarro.exit.shared.IController#getNoteById(java.lang.String)
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getNoteById(@PathVariable(value = "id") String id) {
		User note = userService.getUser(Long.parseLong(id));
		System.out.println(note);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(note);
	}

}
