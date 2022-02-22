package com.shrey.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayEmp
 */
@WebServlet("/display")
public class DisplayEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn;
	Statement stmt;
	ResultSet rs;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			 
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root123@123");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html");
            out.println("<tr><th>Id &nbsp&nbsp</th><th>Name &nbsp&nbsp</th><th>Age &nbsp&nbsp</th><th>Salary &nbsp&nbsp</th><th>Designation &nbsp&nbsp</th><th><tr><br/>"); 
			while(rs.next()) {
				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				//out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				int sal = rs.getInt(4);
				String desig = rs.getString(5);
				out.println("<tr><td>" + id + "</td><td>&nbsp&nbsp&nbsp" + name + "</td><td>&nbsp&nbsp&nbsp" + age + "</td><td>&nbsp&nbsp&nbsp" + sal + "</td><td>&nbsp&nbsp&nbsp" + desig + "</td></tr>&nbsp&nbsp&nbsp<br/>");   
			}
			out.print("<br><a href='index.html'>Home</a><br>");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
