package model;

public class User {

	private String fullName;

	public User() {
	}

	public User(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + "]";
	}

}
