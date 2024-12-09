package in.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.main.model.Department;
import in.main.service.DepartmentService;

@SpringBootApplication
public class SpringDataJpaRepoEx6Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaRepoEx6Application.class, args);
		

		List <String>empNames=List.of("Nitin","Jatin");
		
		DepartmentService dServ=container.getBean(DepartmentService.class);
		
		
		  Department dept1=dServ.createDepartmentWithEmps("IT", empNames);
		  System.out.println("Created Department:"+dept1.getDeptName());
		  
		  empNames=List.of("Neeti","Preeti");
		  
		  Department dept2=dServ.createDepartmentWithEmps("HR", empNames);
		  System.out.println("Created Department:"+dept2.getDeptName());
		  
		  
		  List <Department>deptList=dServ.getAllDepartments();
		  
		  System.out.println("All Departments"); for(Department dep:deptList) {
		  System.out.println("Department name:"+dep.getDeptName());
		  System.out.println(dep.getEmpList()); System.out.println(); }
		 
		
		
		  Department dept=dServ.updateDepartment(2, "Sales");
		  System.out.println("Department updated:"+dept.getDeptName());
		 
		 
		    dServ.addEmpToDept(1, "Mayank"); 
		 
			
			  dServ.removeEmpFromDept(1, 2);
			 

		  
		   
		 
		 
		 
		 
	}

}
