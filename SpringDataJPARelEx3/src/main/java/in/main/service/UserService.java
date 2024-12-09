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
	
	 public boolean updateUserAndProfile(Integer userId,String userName,String bio) {
		  
		 Optional<User> result =repo.findById(userId); 
			if(!result.isPresent())
				return false;
			User user=result.get();
			
			user.setName(userName);
			user.getProfile().setBio(bio);
			repo.save(user); // Updating user will also update profile
			return true;

		   
	   }
	   public Optional<User> findUserById(Integer id){
		   return repo.findById(id);
	   }
	   
	 

	
	
}
