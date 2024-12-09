package in.main.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.model.Profile;

public interface ProfileReposistory extends JpaRepository<Profile, Integer> {

}
