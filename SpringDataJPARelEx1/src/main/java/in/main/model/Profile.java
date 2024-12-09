package in.main.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {
	public Profile() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public Profile(String bio) {
		super();
		this.bio = bio;
	}
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bio;
	
	
	

}
