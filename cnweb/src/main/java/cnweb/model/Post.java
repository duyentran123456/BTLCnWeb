package cnweb.model;

import java.sql.Timestamp;

public class Post {
	private int id;
	private int authorId;
	private String title;
	private String content;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	
}
