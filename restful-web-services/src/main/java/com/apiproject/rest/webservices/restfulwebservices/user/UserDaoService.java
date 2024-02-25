package com.apiproject.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	//All the info from database and use JPA/hibernate to talk to database
	
	// For now we will make a staic arrayList
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Marcus",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Mason",LocalDate.now().minusYears(22)));
		users.add(new User(++usersCount,"Rasmus",LocalDate.now().minusYears(24)));
		users.add(new User(++usersCount,"Kobie",LocalDate.now().minusYears(20)));
	}
	
	//public List<User> findAll() {
	public List<User> findAll() {
		return users;
	}
	//public User save(User user) {
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	//public User findOne(int id) {
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
