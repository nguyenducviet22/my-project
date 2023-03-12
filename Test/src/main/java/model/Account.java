package model;

public class Account {

	private String id;
	private String username;
	private String password;
	private int isSell;
	private int isAdamin;

	public Account() {
	}

	public Account(String id, String username, String password, int isSell, int isAdamin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isSell = isSell;
		this.isAdamin = isAdamin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsSell() {
		return isSell;
	}

	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}

	public int getIsAdamin() {
		return isAdamin;
	}

	public void setIsAdamin(int isAdamin) {
		this.isAdamin = isAdamin;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", isSell=" + isSell
				+ ", isAdamin=" + isAdamin + "]";
	}

	
}
