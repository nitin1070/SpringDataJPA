package in.main.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department(String deptName) {
		this.deptName=deptName;
		
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
    public void addEmp(Emp e) {
    	empList.add(e);    	
    }
    public void remove(Emp e) {
    	empList.remove(e);
    }

	

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String deptName;
	
	public Department() {
	
	}






	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // for lazy loading the data will load when we access only
	@JoinColumn(name = "department_id") // foreign key in Employee table
	private List<Emp>empList =new ArrayList<>();
	

}
