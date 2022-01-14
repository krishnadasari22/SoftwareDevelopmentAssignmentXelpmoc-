package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
 private static final long serialVersionUID = 1L;
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  PrintWriter out = response.getWriter();
  out.println("<form action='LoginServlet' method='post'>");
        out.println("</br>Welcome user");
        out.println("<input type='submit' value='logout' formaction='Login.html'>");
        out.println("</form>");
 }
}
