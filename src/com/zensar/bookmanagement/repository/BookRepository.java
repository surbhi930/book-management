package com.zensar.bookmanagement.repository;

import java.sql.SQLException;
import java.util.List;

import com.zensar.bookmanagement.beans.Book;

public interface BookRepository {

	public abstract int insertBook(Book book) throws SQLException;

	public abstract List<Book> getAllBook() throws SQLException;

	public abstract Book getParticularBook(int bookId)
			throws SQLException;

	public abstract int deleteParticularBook(int id) throws SQLException;

	public abstract int updateParticularBook(Book book)
			throws SQLException;

}