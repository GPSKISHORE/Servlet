package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DrivingLicenceEligibility extends HttpServlet	{

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		String name=req.getParameter("pname");
		String adderes=req.getParameter("padd");
		String tage=req.getParameter("page");
		int age=Integer.parseInt(tage);
		
		String el;
		if(age<18) 
			el="Not eligible";
		else
			el="Eligible";
		
		PrintWriter pw=res.getWriter();
		pw.println("<br><br><br><h1 style='color:red;text-align:center'> User is name is "+name +" and the adderes is "+adderes+" <u>"+el+" for getting Driving Licence </u></h1>");
		
		pw.println("<a href='index.html';style='text-align:center'><img src='images/home.jpeg'></a>");
	}
}
