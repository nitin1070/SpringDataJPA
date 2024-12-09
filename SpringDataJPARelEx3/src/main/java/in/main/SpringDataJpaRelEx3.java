package in.main;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.main.model.User;
import in.main.service.UserService;

@SpringBootApplication
public class SpringDataJpaRelEx3 {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRelEx3.class, args);

		  
		UserService serv = container.getBean(UserService.class);
		
		boolean result=serv.updateUserAndProfile(1,"Nitin", "SDE");
		if(!result) {
			System.out.println("Could not find user");
		}else {
			System.out.println("User updated");
			Optional<User>opt=serv.findUserById(1);
			User user=opt.get();
			System.out.println("User id:"+user.getId());
			System.out.println("User Name: " + user.getName());
			System.out.println("User Profile Bio: " + user.getProfile().getBio());
		}

	
	
		


		  
		
		
	}

}
