package com.zensar.bookmanagement.beans;

public class Book {
	private String bookName;
	private int bookId;
	private int bookCost;

	public Book(String bookName, int bookCost) {
		this.bookName = bookName;
		this.bookCost = bookCost;
	}

	public Book(int bookId, String bookName, int bookCost) {
		this.bookCost = bookCost;
		this.bookName = bookName;
		this.bookId = bookId;
	}

	public Book() {

	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookCost() {
		return bookCost;
	}

	public void setBookCost(int bookCost) {
		this.bookCost = bookCost;
	}

}
