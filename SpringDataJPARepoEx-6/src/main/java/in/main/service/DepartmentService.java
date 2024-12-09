package in.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.model.Department;
import in.main.model.Emp;
import in.main.reposistory.DepartmentReposistory;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentReposistory repo;
	
	public Department createDepartmentWithEmps(String deptName,List<String>empNames) {
		
		Department department=new Department(deptName);
		for(String name :empNames) {
		
			department.addEmp(new Emp(name));

		}	
		
		return repo.save(department);
	
		
	}
	
	public Department  updateDepartment(Integer deptId,String newName) {
	    Optional<Department>result=repo.findById(deptId);
	    if(result.isEmpty())
	    	return null;
	    Department dept=result.get();
	    dept.setDeptName(newName);
	    return repo.save(dept);
	    
}
public void addEmpToDept(Integer deptId,String empName) {
	Optional<Department>result=repo.findById(deptId);
    if(result.isEmpty()) {
    	System.out.println("Dept does not exist");
    	return ;
    }
    Department dept=result.get();
    Emp emp=new Emp(empName);
    dept.addEmp(emp);
    repo.save(dept);
}
public void removeEmpFromDept(Integer deptId,Integer empId) {
	Optional<Department>result=repo.findById(deptId);
    if(result.isEmpty()) {
    	System.out.println("Dept does not exist");
    	return ;
    }
    Department dept=result.get();
    for(Emp e:dept.getEmpList()) {
    	if(e.getId()==empId) {
    		dept.remove(e);
    		repo.save(dept);
    		System.out.println("Emp removed");
    		return;
    	}
    }
    System.out.println("Emp not found");
}

public List<Department> getAllDepartments() {
	 return repo.findAll();
}

	
	

}
