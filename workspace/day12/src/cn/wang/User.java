package cn.wang;

public class User {
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username) {
		super();
		this.username = username;
	}

	private String username;
	private String gender;
	private String likes[];
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
