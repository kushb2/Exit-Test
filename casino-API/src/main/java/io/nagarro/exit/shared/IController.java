package io.nagarro.exit.shared;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.nagarro.exit.model.User;

public interface IController {

	public String sayHi();
	public User createUser(@Valid @RequestBody User user);
	public List<User> getAllUser(); 
	public User updateBalance(@RequestBody User user);
	public User doRecharge(@Valid @RequestBody User user);
	public User BlockBetAmount(@Valid @RequestBody User user);
	public ResponseEntity<User> getNoteById(@PathVariable(value = "id") String id);
}
