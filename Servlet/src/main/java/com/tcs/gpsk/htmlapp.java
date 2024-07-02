package com.tcs.gpsk;

import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class htmlapp extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		pw.println("<table align='center', border='1', bgcolor='cyan'>");
		pw.println("<tr><th>StudentName</th><th>Marks</th><th>Grade</th></tr>");
		pw.println("<tr><td>shiva</td><td>100</td><td>A+</td></tr>");
		pw.println("<tr><td>Yamini</td><td>95</td><td>A+</td></tr>");
		pw.println("<tr><td>Nivas</td><td>92</td><td>A+</td></tr>");
		pw.println("<tr><td>Ganesh</td><td>90</td><td>A+</td></tr>");
		pw.println("<tr><td>Kishore</td><td>82</td><td>A</td></tr>");
		pw.println("</table>");
		pw.println("<h3 style='color=#851254;text-align=center'><a href='page.html'>Home</a></h3>");
		
		res.setHeader("refresh","3");
		pw.println("<h1>"+new Date()+"</h1>");
		pw.close();
	}
}