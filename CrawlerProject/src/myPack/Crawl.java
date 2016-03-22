package myPack;
import java.util.Date;
import java.sql.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class Crawl {
	static Connection con;
	static Database db;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static void main(String[] args) {
		
		parse("http://ymcaust.ac.in/index.php/en/");
	}
	public static void parse(String url)
	{
		try{
			db = new Database();
			con  = db.getConnection();
		  ps = con.prepareStatement("select * from URLS where Url = ? ");
		  ps.setString(1,url);
		  System.out.println("akakka");
		  rs = ps.executeQuery();
		  if(rs.next())
		  {
		  	System.out.println("already Present");

		  }
		  else if(url!="")
		  {
			  	Date d  = new Date();
			  	String d1 = d.toString();
			  	
			  	ps = con.prepareStatement("insert into URLS(Url,Timestamp) values(?,?)");
		  		ps.setString(1, url);
		  		ps.setString(2, d1);
		  		ps.executeUpdate();
		  		System.out.println(url);
		  		Document doc = Jsoup.connect(url).get();
		  		if(doc.text().contains("maths"))
		  		{
		  			System.out.println("yes"+url);
		  		}
		  		Elements urlgenerators = doc.select("a[href]");
		  		for(Element link : urlgenerators)
		  		{
		  			parse(link.attr("abs:href"));
		  			
		  		}
		 
		  }
		  else
		  {
			  
		  }
		}
		catch (Exception e) {
		  	System.out.println(e);
		  }  
	}
}
