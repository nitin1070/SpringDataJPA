package in.main;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.main.model.User;
import in.main.service.UserService;

@SpringBootApplication
public class SpringDataJpaRelEx5 {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRelEx5.class, args);

		UserService service = container.getBean(UserService.class);

		
		
		  boolean result = service.createUserAndUpdateProfile(1,"Tester"); if(!result)
		  {
		  
		  System.out.println("No record found"); } else {
		  System.out.println("user updated"); Optional<User>opt =
		  service.findUserById(1); User user=opt.get();
		  System.out.println("user ID "+user.getId());
		  System.out.println("user name "+user.getName());
		  System.out.println("user profile "+user.getProfile().getBio()); }
		 
		   
		/* To delete a User */
		  
		/*
		 * service.deleteUserById(1); Optional<User> opt= service.findUserById(1);
		 * if(!opt.isEmpty()) {
		 * 
		 * System.out.println("Record not deleted"); } else {
		 * 
		 * User user = opt.get(); System.out.println("user id "+user.getId());
		 * System.out.println("user name "+user.getName());
		 * System.out.println("user profile bio "+user.getProfile().getBio()); }
		 */
		    
    
	}

}
