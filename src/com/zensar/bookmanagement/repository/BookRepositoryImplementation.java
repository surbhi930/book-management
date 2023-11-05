package com.zensar.bookmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.bookmanagement.beans.Book;
import com.zensar.bookmanagement.provider.ConnectionProvider;

public class BookRepositoryImplementation implements BookRepository
{

	private static int BOOK_ID = 100;
	private Connection con = ConnectionProvider.getConnection();
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;

	public int insertBook(Book book) throws SQLException 
	{
		con = ConnectionProvider.getConnection();
		book.setBookId(BOOK_ID++);
		final String sql="INSERT INTO BOOK VALUES(?,?,?)";
		try
		{
			pst = con.prepareStatement(sql);
			pst.setInt(1, book.getBookId());
			pst.setString(2, book.getBookName());
			pst.setInt(3, book.getBookCost());
			int count = pst.executeUpdate();
			if (count > 0)
				return book.getBookId();
		}finally
		{
			pst.close();
			con.close();
		}
		return 0;
	}

	public List<Book> getAllBook() throws SQLException
	{
		con = ConnectionProvider.getConnection();
		List<Book> bookList = new ArrayList<Book>();
		final String sql="SELECT * FROM BOOK";
		try
		{
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookCost(rs.getInt(3));
				bookList.add(book);
			}
			return bookList;
		}finally
		{
			rs.close();
			st.close();
			con.close();
		}
		
	}
	public Book getParticularBook(int bookId) throws SQLException
	{
		con = ConnectionProvider.getConnection();
		final String sql = "SELECT * FROM BOOK WHERE BOOK_ID=?";
		try
		{
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			rs = pst.executeQuery();
			if (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookCost(rs.getInt(3));
				return book;
			}
		}finally
		{
			rs.close();
			pst.close();
			con.close();
		}
		
		return null;
	}

	public int deleteParticularBook(int id) throws SQLException 
	{
		con = ConnectionProvider.getConnection();
		final String sql = "DELETE FROM BOOK WHERE BOOK_ID=?";
		try
		{
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			if (count > 0)
				return 1;
		}finally
		{
			pst.close();
			con.close();
		}
		
		return 0;
	}
	public int updateParticularBook(Book book) throws SQLException
	{
		con = ConnectionProvider.getConnection();
		final String sql = "UPDATE BOOK SET BOOK_NAME=?, BOOK_COST=? WHERE BOOK_ID=?";
		try
		{
			pst = con.prepareStatement(sql);
			pst.setString(1, book.getBookName());
			pst.setInt(2, book.getBookCost());
			pst.setInt(3, book.getBookId());
			int count = pst.executeUpdate();
			if (count > 0)
				return 1;
		}finally
		{
			pst.close();
			con.close();
		}
		
		return 0;
	}
}