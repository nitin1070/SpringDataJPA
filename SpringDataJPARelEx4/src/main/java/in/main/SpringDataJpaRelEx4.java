package in.main;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ch.qos.logback.core.joran.conditional.IfAction;
import in.main.model.Profile;
import in.main.model.User;
import in.main.service.ProfileService;

@SpringBootApplication
public class SpringDataJpaRelEx4 {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRelEx4.class, args);
		ProfileService serv = container.getBean(ProfileService.class);
		
		Optional<Profile> result=serv.findUserById(1);
		if(result.isEmpty()) {
			System.out.println("no record found for id ");
			
			
		}
		else {
			boolean ans = serv.updateUserAndProfile(1, "Nitin", "JAVA DEVELOPER");
			if(ans) {
				System.out.println("updated record "+ans);
			}
		}
		
	  
		
		
	}

}
