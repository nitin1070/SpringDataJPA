package in.main;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.main.model.Profile;
import in.main.model.User;
import in.main.service.ProfileService;
import in.main.service.UserService;

@SpringBootApplication
public class SpringDataJpaRelEx2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRelEx2.class, args);

		  
		UserService serv = container.getBean(UserService.class);
		
		User user=serv.createUserWithProfile("Ajay", "SDE With 1 year exp");
		
		System.out.println("User created with id:"+user.getId());
		System.out.println("Getting data from User-->Profile");
	
		Optional <User>result=serv.findUserById(user.getId());
		
		if(result.isPresent()) {
			User retrievedUser=result.get();
			System.out.println("user id"+retrievedUser.getId());
			System.out.println("User name:"+retrievedUser.getName());
			System.out.println("User profile:"+retrievedUser.getProfile().getBio());
		}else {
			System.out.println("Record not found");
		}
		
		System.out.println("Getting data from Profile-->User");
		ProfileService pserv=container.getBean(ProfileService.class);
		Optional <Profile>result2=pserv.findProfileById(user.getProfile().getId());
		if(result2.isPresent()) {
			Profile retrievedProfile=result2.get();
			System.out.println("Profile id"+retrievedProfile.getId());
			System.out.println("Bio:"+retrievedProfile.getBio());
			System.out.println("Username:"+retrievedProfile.getUser().getName());
		}else {
			System.out.println("Record not found");
		}


		  
		
		
	}

}
