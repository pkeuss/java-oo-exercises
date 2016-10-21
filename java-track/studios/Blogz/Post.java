package Blogz;

import java.util.Date;

public class Post extends Entity{
	
	private String body, title, author;
	private final Date created;
	private Date updated;

	public Post(String body, String title, String author) {
		super();
		this.body = body;
		this.title = title;
		this.author = author;
		this.created = new Date();
		this.updated = this.created;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 * and update the updated time-stamp
	 */
	public void setBody(String body) {
		this.body = body;
		this.setUpdated(new Date());
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 * and update the updated time-stamp
	 */
	public void setTitle(String title) {
		this.title = title;
		this.setUpdated(new Date());
	}

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	
	

}
