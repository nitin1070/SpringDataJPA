package in.main.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.model.Department;

public interface DepartmentReposistory extends JpaRepository<Department, Integer> {

}
