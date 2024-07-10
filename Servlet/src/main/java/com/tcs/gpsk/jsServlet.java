package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jsServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int num = Integer.parseInt(req.getParameter("country"));

		String city[][] = new String[][] { { "Delhi", "Mumbai", "Bengaluru", "Chennai", "Hyderabad" },
				{ "Zurich", "Geneva", "Bern", "Basel", "Lucerne" },
				{ "New-yark", "Loss-Angeles", "Chicago", "Bostan", "Philadelphia" },
				{ "London", "Paris", "Brlin", "Amsterdam", "Barcelona" },
				{ "Kyoto", "Osaka", "Hiroshima", "Tokyo", "Saporro" } };

		PrintWriter pw = res.getWriter();
		pw.println("<br><br><h2 Style='color:blue;text-align:center'> Top 5 cities are --> " + Arrays.toString(city[num])+ " </h1>");
		pw.println("<br><br><a href='input.html'> Home </a>");
		pw.close();
		System.out.println("Post");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.println("<br><br><h1> Current Time is "+ new java.util.Date()+"</h1>");
		pw.println("<br><br><a href='input.html'> Home </a>");
		System.out.println("Get");
	}
}
