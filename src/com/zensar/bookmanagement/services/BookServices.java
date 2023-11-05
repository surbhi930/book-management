package com.zensar.bookmanagement.services;

import java.sql.SQLException;
import java.util.List;

import com.zensar.bookmanagement.beans.Book;
import com.zensar.bookmanagement.exception.InvalidBookIdException;
import com.zensar.bookmanagement.exception.BookNotFoundException;
import com.zensar.bookmanagement.exception.ServiceNotAvailabeException;

public interface BookServices {

	public abstract int acceptBook(String bookName, int bookCost)
			throws ServiceNotAvailabeException;

	public abstract List<Book> getAllBooks() throws SQLException;

	public abstract Book getParticularBook(int bookId)
			throws BookNotFoundException, InvalidBookIdException,
			ServiceNotAvailabeException;

	public abstract int deleteParticularBook(int id)
			throws InvalidBookIdException, BookNotFoundException,
			ServiceNotAvailabeException;

	public abstract int updateParticularBook(int updateId,
			String updateName, int updateCost)
			throws InvalidBookIdException, BookNotFoundException,
			ServiceNotAvailabeException;

}