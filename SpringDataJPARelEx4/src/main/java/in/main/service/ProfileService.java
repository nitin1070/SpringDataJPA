package in.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.model.Profile;
import in.main.reposistory.ProfileReposistory;


@Service
public class ProfileService {
	@Autowired
	private ProfileReposistory repo;
	
	 public boolean updateUserAndProfile(Integer userId,String userName,String bio) {
		  
		 Optional<Profile> result =repo.findById(userId);
			if(!result.isPresent())
				return false;
			Profile profile=result.get();
			
		profile.setBio(bio);
	profile.getUser().setName(userName);
			repo.save(profile); // Updating profile will not update user
			return true;

	
		   
		   
	   }
	   public Optional<Profile> findUserById(Integer id){
		   return repo.findById(id);
	   }

	
	
}
