package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinkUrl extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();

		String dum = req.getParameter("p1");

		if (dum.equalsIgnoreCase("link1"))
			pw.println("<h1 style='color: green;text-align: center'><u> Top 5 Telugu Movies are </u> <br> Bhahubali-2 <br> Kalaki <br> Bharath Ane Nenu <br> Arjun Reddy <br> Magha Dheera </h1>");
		else if (dum.equalsIgnoreCase("link2"))
			pw.println("<h1 style='color: red;text-align: center'> <u>Top 5 Malayalam Movies are </u> <br> Manjummel Boys <br> 2018 <br> The Goat Life <br> Aavesham <br> Premalu </h1>");
		else
			pw.println("<h1 style='color: darkorange;text-align: center'><u> Top 5 Tamil Movies are </u> <br> 2.0 <br> Leo <br> Jailer <br> Ponniyin Selvan: Part I <br> Vikram </h1>");
		
		pw.println("<h1 style='color: yellow;text-align: center'> <a href='Links.html'> Home </a></h1>");
		
		pw.close();
	}
}
