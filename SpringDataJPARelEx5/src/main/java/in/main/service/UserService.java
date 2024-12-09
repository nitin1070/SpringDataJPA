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
	
	public boolean createUserAndUpdateProfile(Integer id,String bio) {
		Optional<User>result = repo.findById(id);
		if(!result.isPresent())
		return false;
		
		User user= result.get();
		Profile profile = new Profile();
		profile.setBio(bio);
		user.setProfile(profile);
		profile.setUser(user);
		repo.save(user);
		return true;
		
		
	}
	
	
	   public Optional<User> findUserById(Integer id){
		   return repo.findById(id);
	   }
	 public void deleteUserById(Integer id) {
		  repo.deleteById(id);
	 }

	
	
}
