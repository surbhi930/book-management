package com.zensar.bookmanagement.beans;

public class Author {
	private int authorId;
	private String authorName;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName
				+ "]";
	}

}
