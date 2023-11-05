package com.zensar.bookmanagement.client;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.zensar.bookmanagement.provider.ServiceProvider;
import com.zensar.bookmanagement.services.BookServices;
import com.zensar.bookmanagement.beans.Book;
import com.zensar.bookmanagement.exception.InvalidBookIdException;
import com.zensar.bookmanagement.exception.BookNotFoundException;
import com.zensar.bookmanagement.exception.ServiceNotAvailabeException;

public class Client {
	public static void main(String[] args) 
	{
		BookServices bookServicesImpelementation = ServiceProvider.getServiceProvider();
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		String ans=null;
		System.out.println("Welcome to book management system");
		do {
			System.out.println("1. insert book registeration");
			System.out.println("2. display book");
			System.out.println("3. display book by book id ");
			System.out.println("4. delete book by book id");
			System.out.println("5. update book by book id");
			System.out.println("6. Exit");
			System.out.println("Enter choice  :");
			choice = scanner.nextInt();
			switch (choice) 
			{
			case 1:
					System.out.println("please enter book name : ");
					String bookName = scanner.next();
					System.out.println("please enter book cost : ");
					int bookCost = scanner.nextInt();
					int bookId;
				try 
				{
					bookId = bookServicesImpelementation.acceptBook(bookName, bookCost);
					System.out.println("book successfully entered with book id "+ bookId);
				} 
				catch (ServiceNotAvailabeException e1) 
				{
					e1.printStackTrace();
				}
					break;

			case 2:
					List<Book> myBooks;
					try
					{
						myBooks = bookServicesImpelementation.getAllBooks();
						Iterator<Book> iter = myBooks.iterator();
						while (iter.hasNext())
						{
							Book b = iter.next();
							System.out.println(b);
						}
					} 
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
					break;
			case 3:
					System.out.println("Please enter book id : ");
					int id = scanner.nextInt();
					Book b = null;
					try
					{
						b = bookServicesImpelementation.getParticularBook(id);
					} 
					catch (ServiceNotAvailabeException|InvalidBookIdException|BookNotFoundException e)
					{
						e.printStackTrace();
					}

					System.out.println("DETAILS ARE : " + b);
					break;
			case 4:
					System.out.println("Please enter book id : ");
					int deleteCount;
					int deleteId = scanner.nextInt();
					try 
					{
					deleteCount = bookServicesImpelementation.deleteParticularBook(deleteId);
					if (deleteCount > 0)
						System.out.println("book deleted succeessfully");
					else 
					{
						System.out.println("Deletion failed... please try after some time");
					}
					} 
					catch (ServiceNotAvailabeException|BookNotFoundException|InvalidBookIdException e)
					{
						e.printStackTrace();
					}
					break;
			case 5:
					System.out.println("Please enter book id : ");
					int updateId = scanner.nextInt();
					System.out.println("Please enter book name : ");
					String updateName = scanner.next();
					System.out.println("Please enter book cost : ");
					int updateCost = scanner.nextInt();
					int updateCount;
					try 
					{
						updateCount = bookServicesImpelementation.updateParticularBook(updateId, updateName,updateCost);
					if (updateCount > 0)
						System.out.println("book updated succeessfully");
					else 
					{
						System.out.println("updation failed... please try after some time");
					}
					}

					catch (ServiceNotAvailabeException|BookNotFoundException|InvalidBookIdException e) 
					{
						e.printStackTrace();
					}
					break;
			case 6:
					System.out.println("Thanku for using our book management system");
					System.exit(0);
					break;
			default:
					System.out.println("Wrong choice");
					break;
			}
				System.out.println("Do you want to continue ??");
				ans = scanner.next();
		} while (ans.equalsIgnoreCase("Yes"));
		scanner.close();
	}
}
