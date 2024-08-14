package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormInsetion extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String add=req.getParameter("add");
		String ms=req.getParameter("ms");
		String qufy=req.getParameter("qlfy");
		String hobies[]=req.getParameterValues("s1");
		if(hobies==null)
			hobies=new String[] {"No hobies selected"};
		String qusine[]=req.getParameterValues("cousine");
		String color=req.getParameter("favcolor");
		String num=req.getParameter("lnum");
		String mail=req.getParameter("email");
		String sal=req.getParameter("sal");
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String doj=req.getParameter("doj");
		String contact=req.getParameter("contact");
		String em=req.getParameter("em");
		String ew=req.getParameter("ew");
		String url=req.getParameter("url");
		String serch=req.getParameter("serch");
		
		PrintWriter pw=res.getWriter();
		
		pw.println("<h1>Please find the entered details </h1>");
		pw.println("<h1> name "+name+"</h1>");
		pw.println("<h1> age "+age+"</h1>");
		pw.println("<h1> add "+add+"</h1>");
		pw.println("<h1> Marital Status "+ms+"</h1>");
		pw.println("<h1> Qualification "+qufy+"</h1>");
		pw.println("<h1> Hobies "+Arrays.toString(hobies)+"</h1>");
		pw.println("<h1> Fav Qusine "+Arrays.toString(qusine)+"</h1>");
		pw.println("<h1> Fav color "+color+"</h1>");
		pw.println("<h1> Lucky Number "+num+"</h1>");
		pw.println("<h1> Email "+mail+"</h1>");
		pw.println("<h1> Salary "+sal+"</h1>");
		pw.println("<h1> Date of Birth "+dob+"</h1>");
		pw.println("<h1> Time of Birth "+tob+"</h1>");
		pw.println("<h1> Date of joining "+doj+"</h1>");
		pw.println("<h1> Contact Number"+contact+"</h1>");
		pw.println("<h1> Energitic month "+em+"</h1>");
		pw.println("<h1> Energitic week "+ew+"</h1>");
		pw.println("<h1> Linkdin URL "+url+"</h1>");
		pw.println("<h1> Google Search String "+serch+"</h1>");
	
		pw.println("<a href=Form.html>Home</a>");
	}
}
