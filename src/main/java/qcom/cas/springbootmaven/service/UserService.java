package qcom.cas.springbootmaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qcom.cas.springbootmaven.Model.User;
import qcom.cas.springbootmaven.repository.UserRepository;
import qcom.cas.springbootmaven.util.ThreadContext;
import qcom.cas.springbootmaven.util.UserThreadContext;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getUsers() {
		return (List<User>)userRepository.findAll();
	}
	
	public User getUser(int userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	public List<User> getUserByAge(int age) {
		return userRepository.findUsersByAge(age);
	}
	
	public void updateUser(User user) {
		
		userRepository.save(user);
	}
	
	@Transactional
	public void fetchAndUpdateFirstNameAndLastName(int userId) {
		User user = userRepository.findById(userId).orElse(null);
		if(null != user) {
			userRepository.updateFirstName(user.getId(), user.getFirstName().toUpperCase());
			userRepository.updateLastName(user.getId(), user.getLastName().toUpperCase());
		}
	}
	
	@Transactional
	public void updateFirstName() {
		ThreadContext threadContext = UserThreadContext.get();
		userRepository.updateFirstName(threadContext.getUser().getId(), threadContext.getUser().getFirstName().toUpperCase());
		UserThreadContext.clear();
	}

}
