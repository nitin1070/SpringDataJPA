package in.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.model.Department;
import in.main.reposistory.DepartmentReposistory;
import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentReposistory repo;
	

@Transactional
public void getAllDepartments() {
	System.out.println("All Departments");
	List<Department>allDeptList = repo.findAll();
	for(Department dpt: allDeptList) {
		System.out.println("department name :"+dpt.getDeptName());
		System.out.println(dpt.getEmpList());
	}
	    
	
	

}

	
	

}
