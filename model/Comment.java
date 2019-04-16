package model;


public class Comment {

	private int comment_id;
	private int post_id;
	private int user_id;
	private String comment_body;
	
	public Comment() {
		
	}

	public Comment(int comment_id,String comment_body, int user_id, int post_id  ) {

		this.comment_id = comment_id;
		this.post_id = post_id;
		this.user_id = user_id;
		this.comment_body = comment_body;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getComment_body() {
		return comment_body;
	}

	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", post_id=" + post_id + ", user_id=" + user_id + ", comment_body="
				+ comment_body + "]";
	}
	
	
	
}