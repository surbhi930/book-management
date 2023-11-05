package com.zensar.bookmanagement.provider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.zensar.bookmanagement.services.BookServices;

public class ServiceProvider 
{
	public static BookServices getServiceProvider()
	{
		Properties properties = new Properties();
		try 
		{
			properties.load(new FileReader(new File(".\\resources\\provider.properties")));
			String provider = properties.getProperty("serviceProvider");
					return (BookServices) Class.forName(provider).newInstance();
		} 
		catch (InstantiationException|IllegalAccessException|ClassNotFoundException|IOException e)
		{
					e.printStackTrace();
		} 
		return null;
	}
}
