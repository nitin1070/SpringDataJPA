package in.main.reposistory;


import org.springframework.data.jpa.repository.JpaRepository;

import in.main.model.User;

public interface UserReposistory  extends JpaRepository<User, Integer>{
	



}
