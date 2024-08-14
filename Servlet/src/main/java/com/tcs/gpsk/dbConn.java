package com.tcs.gpsk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dbconn")
public class dbConn extends HttpServlet {

    private static final String SQL_SELECT_EMP = "SELECT * FROM EMP WHERE EMPNO = ?";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empNoParam = request.getParameter("ind");
    	//String empNoParam="7777";
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
        if (empNoParam == null || empNoParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Employee number is required.");
            return;
        }
        
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Kishore@123");
             PreparedStatement ps = con.prepareStatement(SQL_SELECT_EMP)) {

            int empNo = Integer.parseInt(empNoParam);
            ps.setInt(1, empNo);
            
            try (ResultSet rs = ps.executeQuery();
                 PrintWriter out = response.getWriter()) {
                 
                response.setContentType("text/html");
                
                if (rs.next()) {
                    out.println("<html><body>");
                    out.println("<p>Employee Number: " + rs.getString(1) + "</p>");
                    out.println("<p>Employee Name: " + rs.getString(2) + "</p>");
                    out.println("<p>Employee Position: " + rs.getString(3) + "</p>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><body><p>No employee found with number " + empNo + "</p></body></html>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid employee number format.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
