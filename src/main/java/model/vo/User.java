package model.vo;

public class User {
	String id;
	String password;
	String name;
	String gender;
	int birth;
	String email;
	String interest;
	
	public User() {
		super();
	}

	public User(String id, String password, String name, String gender, int birth, String email, String interest) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.interest = interest;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getInterest() {
		return interest;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
}
