package in.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.model.Profile;
import in.main.model.User;
import in.main.reposistory.UserReposistory;

@Service
public class UserService {
	@Autowired
	private UserReposistory repo;
	
	 public User createUserWithProfile(String userName,String bio) {
		  
		 User user = new User(userName);
			Profile profile = new Profile(bio);
			user.setProfile(profile);
			profile.setUser(user); // This is for bidirectional consistency
			return repo.save(user); // Saving user cascades to profile

		
		   
		   
	   }
	   public Optional<User> findUserById(Integer id){
		   return repo.findById(id);
	   }

	
	
}
