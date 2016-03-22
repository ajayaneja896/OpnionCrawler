package myPack;
import  java.io.*;
import java.sql.*;
import java.util.*;
public class Database {
	Connection con  = null;
	public Connection getConnection()
	{
		try{
			System.out.println("Before loading SQLServerDriver:");
		  
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///crawler","root","7352#Xyz");

		}	
		catch(Exception e)
		{
			e.printStackTrace();
		} 
			return con;
		
	} 
	 
   	
  
  
}
