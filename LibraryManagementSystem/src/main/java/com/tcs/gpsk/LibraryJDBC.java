package com.tcs.gpsk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryJDBC {

	public int insert(int sno, String title, String Author, String isbn, String avai) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Kishore@123");
		
		PreparedStatement st = con.prepareStatement("INSERT INTO BOOKS VALUES (?,?,?,?,?)");
		st.setInt(1, sno);
		st.setString(2, title);
		st.setString(3, Author);
		st.setString(4, isbn);
		st.setString(5, avai);
		int count = st.executeUpdate();
		return count;
	}

	public ResultSet listOfAllBooks() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Kishore@123");
		PreparedStatement st = con.prepareStatement("SELECT * FROM BOOKS");
		ResultSet rs = st.executeQuery();
		return rs;
	}

	public String status() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Kishore@123");
		PreparedStatement st = con.prepareStatement("SELECT AVA FROM BOOKS WHERE BOOK_ID=?");

		st.setInt(1, 1);
		ResultSet rs = st.executeQuery();
		String res = null;
		if (rs.next())
			res = rs.getString(1);

		return res;
	}
	public static void main(String[] args) throws SQLException {
		//new LibraryJDBC().insert(4, "Secrets", "Gopal Das", "7661060061", "YES");
	}
}
