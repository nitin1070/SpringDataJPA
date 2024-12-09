package in.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.main.service.DepartmentService;

@SpringBootApplication
public class SpringDataJpaRepoEx7Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRepoEx7Application.class, args);
		
		DepartmentService dServ=container.getBean(DepartmentService.class);
		
	
		  dServ.getAllDepartments();
		   
		 
		 
		 
		 
	}

}
