package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ={"/link"}, loadOnStartup = 1, name="link", description="ds", displayName="Test")
public class AllServices extends HttpServlet{
	
	public AllServices() {
		System.out.println("Class Constructer");
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		PrintWriter pw=res.getWriter();
		pw.println("<h1> Do get Method</h1>");
		System.out.println("Do get");
	}
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		PrintWriter pw=res.getWriter();
		pw.println("<h1> Public Servlice Method</h1>");
		System.out.println("Protected");
	}
	
}
