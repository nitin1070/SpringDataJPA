package in.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class User {
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User(String name) {
	
		this.name = name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	    private String name;
	  
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="profile_id",referencedColumnName = "id")
	    private Profile profile;

		public User() {
			
			// TODO Auto-generated constructor stub
		}


}
