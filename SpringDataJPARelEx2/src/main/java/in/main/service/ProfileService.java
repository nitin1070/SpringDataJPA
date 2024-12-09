package in.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.model.Profile;
import in.main.reposistory.ProfileReposistory;

@Service
public class ProfileService{
  @Autowired
	private ProfileReposistory repo;
  
  public Optional<Profile> findProfileById(Integer profileId){
	   return repo.findById(profileId);
  }

	
}
