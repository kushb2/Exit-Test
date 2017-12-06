package io.nagarro.exit.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nagarro.exit.model.User;
import io.nagarro.exit.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	
	public String sayHi() {
		return "hello";
	}


	public User register(User user) {
		user.setSecretID(new Date().getTime());
		return userRepository.save(user);
	}


	public List<User> getAllUser() {
			return (List<User>) userRepository.findAll();
	}


	public User doRecharge(User user) {
		return userRepository.save(user);
	}


	public User getUser(Long id) {
		User user =  userRepository.findBysecretID(id);
		user.setAccountBal(user.getAccountBal() + user.getBlockedAmount());
		user.setBlockedAmount(0);
		userRepository.save(user);
		return user;
	}


	public User BlockBetAmount(User user) {
		return userRepository.save(user);
	}


	public User updateBalance(User user) {
		System.out.println("updateBalance");
		return userRepository.save(user);
	}

}
