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
		  
		 User user= new User(userName);
		   
		Profile profile= new Profile(bio);

		  user.setProfile(profile);
		   return repo.save(user);//This will save profile also
	   }
	   public Optional<User> findUserById(Integer id){
		   return repo.findById(id);
	   }

	
	
}
