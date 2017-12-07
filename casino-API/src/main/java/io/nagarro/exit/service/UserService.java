package io.nagarro.exit.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nagarro.exit.model.User;
import io.nagarro.exit.repository.UserRepository;
import io.nagarro.exit.shared.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	public UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IUserService#sayHi()
	 */
	public String sayHi() {
		return "hello";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.nagarro.exit.shared.IUserService#register(io.nagarro.exit.model.User)
	 */
	public User register(User user) {
		user.setSecretID(new Date().getTime());
		return userRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IUserService#getAllUser()
	 */
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.nagarro.exit.shared.IUserService#doRecharge(io.nagarro.exit.model.
	 * User)
	 */
	public User doRecharge(User user) {
		return userRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.nagarro.exit.shared.IUserService#getUser(java.lang.Long)
	 */
	public User getUser(Long id) {
		User user = userRepository.findBysecretID(id);
		user.setAccountBal(user.getAccountBal() + user.getBlockedAmount());
		user.setBlockedAmount(0);
		userRepository.save(user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.nagarro.exit.shared.IUserService#BlockBetAmount(io.nagarro.exit.model.
	 * User)
	 */
	public User BlockBetAmount(User user) {
		return userRepository.save(user);
	}

	public User updateBalance(User user) {
		System.out.println("updateBalance");
		return userRepository.save(user);
	}

}
