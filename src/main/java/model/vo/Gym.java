package model.vo;

public class Gym {
	int id;
	String name;
	String type;
	String location;
	String owner;
	String manager;
	
	public Gym() {
		super();
	}

	public Gym(int id, String name, String type, String location, String owner, String manager) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.owner = owner;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public String getOwner() {
		return owner;
	}

	public String getManager() {
		return manager;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}
