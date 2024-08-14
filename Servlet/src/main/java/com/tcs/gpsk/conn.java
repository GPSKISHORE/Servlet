package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connection")
public class conn extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
//	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		

		 try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Kishore@123");
	             PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?")) {

			 	String empno=req.getParameter("ind");
	            int empNo = Integer.parseInt(empno);
	            ps.setInt(1, empNo);
	            
	            try (ResultSet rs = ps.executeQuery();
	                    PrintWriter out = res.getWriter()) {
	                    
	                   res.setContentType("text/html");
	                   
	                   if (rs.next()) {
	                       out.println("<html><body>");
	                       out.println("<p>Employee Number: " + rs.getString(1) + "</p>");
	                       out.println("<p>Employee Name: " + rs.getString(2) + "</p>");
	                       out.println("<p>Employee Position: " + rs.getString(3) + "</p>");
	                       out.println("<br>");
	                       out.println("<br>");
	                       out.println("<a href='inputdb.html'>Home</a>");
	                       out.println("</body></html>");
	                   } else {
	                       out.println("<html><body><p>No employee found with number " + empNo + "</p><a href='inputdb.html'>Home</a></body></html>");
	                   }
	               } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
