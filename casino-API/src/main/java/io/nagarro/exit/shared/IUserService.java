package io.nagarro.exit.shared;

import java.util.List;

import io.nagarro.exit.model.User;

public interface IUserService {

	public String sayHi();
	public User register(User user);
	public User BlockBetAmount(User user);
	public User updateBalance(User user);
	public List<User> getAllUser();
	public User doRecharge(User user);
	public User getUser(Long id); 
}
