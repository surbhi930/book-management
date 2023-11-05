package com.zensar.bookmanagement.services;

import java.sql.SQLException;
import java.util.List;
import com.zensar.bookmanagement.provider.RepositoryProvider;
import com.zensar.bookmanagement.repository.BookRepository;
import com.zensar.bookmanagement.beans.Book;
import com.zensar.bookmanagement.exception.InvalidBookIdException;
import com.zensar.bookmanagement.exception.BookNotFoundException;
import com.zensar.bookmanagement.exception.ServiceNotAvailabeException;

public class BookServicesImplementation implements BookServices
{
	BookRepository bookRepositoryImplementation = null;

	public BookServicesImplementation()
	{
		bookRepositoryImplementation = RepositoryProvider.getRepositoryProvider();

	}
	public int acceptBook(String bookName, int bookCost)throws ServiceNotAvailabeException
	{
			try 
			{
				return bookRepositoryImplementation.insertBook(new Book(bookName, bookCost));
			} 
			catch (SQLException e) 
			{
				throw new ServiceNotAvailabeException("Server is busy right now, please try after some time");
			}
	}
	public List<Book> getAllBooks() throws SQLException
	{
		return bookRepositoryImplementation.getAllBook();
	}
	public Book getParticularBook(int bookId)throws BookNotFoundException, InvalidBookIdException,ServiceNotAvailabeException 
	{
		if (bookId < 100)
			throw new InvalidBookIdException("Invalid book id");
		else
			try 
			{
				if (bookRepositoryImplementation.getParticularBook(bookId) == null)
					throw new BookNotFoundException("Book not found");
				return bookRepositoryImplementation.getParticularBook(bookId);
			} 
			catch (SQLException e1) 
			{
				throw new ServiceNotAvailabeException("Server is busy right now, please try after soe time");
			}
	}
	public int deleteParticularBook(int id)throws InvalidBookIdException,BookNotFoundException,ServiceNotAvailabeException
	{
		if (id < 100)
			throw new InvalidBookIdException("Invalid book id");
		else
			try 
			{
				if (bookRepositoryImplementation.getParticularBook(id) == null)
					throw new BookNotFoundException("Book not found");
				return bookRepositoryImplementation.deleteParticularBook(id);
			} 
			catch (SQLException e) 
			{
				throw new ServiceNotAvailabeException("Server is busy right now, please try after soe time");
			}
	}
	public int updateParticularBook(int updateId, String updateName,int updateCost) throws InvalidBookIdException,BookNotFoundException,ServiceNotAvailabeException 
	{
		if (updateId < 100)
			throw new InvalidBookIdException("Invalid book id");
		else
			try {
				if (bookRepositoryImplementation.getParticularBook(updateId) == null)
					throw new BookNotFoundException("Book not found");
				return bookRepositoryImplementation.updateParticularBook(new Book(updateId,updateName, updateCost));
				}
			catch (SQLException e)
			{
				throw new ServiceNotAvailabeException("Server is busy right now, please try after soe time");
			}

	}
}
