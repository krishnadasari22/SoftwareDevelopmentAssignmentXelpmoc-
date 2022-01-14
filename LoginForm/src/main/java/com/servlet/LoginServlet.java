package com.servlet;
import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  HttpSession session = request.getSession();
  String email = request.getParameter("email");

  session.setAttribute("email", email);
  String password = request.getParameter("password");

  try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "abcd");
   PreparedStatement pst = conn
     .prepareStatement("Select email,password from test.login where email=? and password=?");
   pst.setString(1, email);
   pst.setString(2, password);
   ResultSet rs = pst.executeQuery();
   if (rs.next()) {
    out.print("You are successfully loggedin...");
    request.getRequestDispatcher("Welcome").include(request, response);
   } else {

    out.println("Username or Password incorrect");
    request.getRequestDispatcher("Login.html").include(request, response);

   }
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }
}
