package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		String a = req.getParameter("val1");
		int num1 = Integer.parseInt(a);
		String b = req.getParameter("val2");
		int num2 = Integer.parseInt(b);
		
		System.out.println(num1);
		System.out.println(num2);
		PrintWriter pw = res.getWriter();

		if (req.getParameter("p1").equals("Addition"))
			pw.println("<h1 style='color:red;text-align=center'> Addition of two number is " + (num1 + num2) + " </h1>");
		else if (req.getParameter("p1").equals("Substraction"))
			pw.println("<h1 style='color:red;text-align=center'> Substraction of two number is " + (num1 - num2) + " </h1>");
		else if (req.getParameter("p1").equals("Multiplication"))
			pw.println("<h1 style='color:red;text-align=center'> Multiplication of two number is " + (num1 * num2) + " </h1>");
		else
			pw.println("<h1 style='color:red;text-align=center'> Division of two number is " + (num1 / num2) + " </h1>");
	
		pw.println("<a href='cal.html' style='color:red;text-align=center'> Home  </h1></a>");
		
	}
}
