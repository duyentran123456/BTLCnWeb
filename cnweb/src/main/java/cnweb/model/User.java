package cnweb.model;

public class User {
	private int id;
	private String username;
	private String hashedPw;
	private String role;
	private String name;
	private String avatar;
	private String about;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashedPw() {
		return hashedPw;
	}
	public void setHashedPw(String hashed_pw) {
		this.hashedPw = hashed_pw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
}
