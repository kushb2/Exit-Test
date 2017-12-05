package io.nagarro.exit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.nagarro.exit.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findBysecretID(Long secretID);

}
