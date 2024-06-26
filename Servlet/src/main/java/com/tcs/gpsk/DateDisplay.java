package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DateDisplay extends  GenericServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
	
	res.setContentType("text/html");
	
	PrintWriter pw=res.getWriter();
	pw.println("<h1 style='color:red;text-align:center'><u><b><i>"+new Date()+"</i></b></u></h1>");
	pw.println("<h1 style='color:#105020;text-align:center'><q> I am Kishore, this is my friend shiva </q></h1>");
	pw.close();

}


} 