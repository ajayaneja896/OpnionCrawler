package myPack;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
public class CrawlerUi implements ActionListener {

	
		JFrame fr;
		JLabel lb;
		JTextField tb;
		JButton b;
		int i;
		CrawlerUi()
		{
		   fr=new JFrame();
		   fr.setSize(500,500);
		   fr.setLayout(null);
		   

		   lb=new JLabel("URL");
		   lb.setBounds(100,100,80,40);
		   fr.add(lb);
		   tb=new JTextField();
		   tb.setBounds(200,100,200,30);
		   fr.add(tb);

		   b=new JButton("Browse");
		   b.setBounds(450,100,100,30);
		   fr.add(b);
		   b.addActionListener(this);

	       fr.setVisible(true);

		}
		public static void main(String s[])
		{

		      new CrawlerUi();
		 }     
		      public void actionPerformed(ActionEvent e)
		      {
		      	 if(e.getSource()==b)
		      	 {
		      	 	System.out.println("Button clicked");
		      	 	String url=tb.getText();
		      	 	System.out.println(url);
		      	 	ArrayList<String> al=extractFromFile(url);

		      	 }
		      }
		      public ArrayList<String> extractFromFile(String addr)
		      {
		      	ArrayList<String> l=new ArrayList<String>();
	              try
	              {
	            	  String currentUrl;
	            	 BufferedReader br  = new BufferedReader(new FileReader(addr));         	 
	                 while((currentUrl = br.readLine())!=null)
	                 {
	                	 System.out.println(currentUrl);
	                	 Crawl.parse(currentUrl);
	                 }
	                	
	              }
	              catch(Exception e1)
	              {
	                    e1.printStackTrace();
	              }
	         
	            
	              
	              return l;

		      }
		
		
	

}
