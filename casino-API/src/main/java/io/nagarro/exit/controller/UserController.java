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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
   public 	UserService userService;
	
	@RequestMapping("/abc")
	public String sayHi(){
		System.out.println("fsffdas");
		return userService.sayHi();
	}
	
	
	@PostMapping("/register")
	public User createUser(@Valid @RequestBody User user) {
	    return userService.register(user);
	}
	
	
	
	
	
	@RequestMapping("/getall")
	public List<User> getAllUser( ){
		return userService.getAllUser();
	}
	
	@PutMapping("/recharge")
	public User doRecharge( @Valid @RequestBody User user){
		return userService.doRecharge(user);
	}

	@PutMapping("/user")
	public User updateBalance(  @RequestBody User user){
		System.out.println("dfsdfrsdgrgdrg");
		System.out.println(user);
		return userService.updateBalance(user);
	}
	
	@PutMapping("/blockedAmount")
	public User BlockBetAmount( @Valid @RequestBody User user){
		System.out.println(user);
		System.out.println("/blockedAmounts");
		return userService.BlockBetAmount(user);
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User>  getNoteById(@PathVariable(value = "id") String id) {
		System.out.println("getNoteById");
		
			
//		System.out.println(id);
		User note = userService.getUser(Long.parseLong(id));
		System.out.println(note);
	    if(note == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(note);
	}
	
	
	
	
	
}
