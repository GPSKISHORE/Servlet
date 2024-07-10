package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String data=req.getParameter("retrive");
		System.out.println(data);
		PrintWriter pw=res.getWriter();
		if(data.equals("Know_All_Books")) {
			try {
				ResultSet rs=new LibraryJDBC().listOfAllBooks();
				while(rs.next()) {
					pw.println("<h3 style='color:red;text-align:center'>----------------------------------------------------------------------</h3>");
					pw.println("<h3 style='color:red;text-align:center'>"+rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" |</h>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		int sno=5;
		String title=req.getParameter("title");
		String auth=req.getParameter("author");
		String isbn=req.getParameter("isbn");
		String avai="YES";
		
		System.out.println(sno);
		System.out.println(title);
		System.out.println(auth);
		System.out.println(isbn);
		System.out.println(avai);
		
		PrintWriter pw=res.getWriter();
		
		try {
			int result=new LibraryJDBC().insert(sno, title, auth, isbn, avai);
			if(result==1) {
				pw.println("<h1 Style='color:red;text-align:center'> sno "+sno+" title "+title+ " author "+auth+" isbn "+isbn+" avai, record is inserted successfully..! </h1>");
				sno++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
