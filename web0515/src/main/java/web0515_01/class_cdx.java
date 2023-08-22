package web0515_01;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintWriter;
/**
 * Servlet implementation class PageRedirect
 */

public class class_cdx extends HttpServlet{
    
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
	  String account=request.getParameter("account");
      String password=request.getParameter("mypassword");
      
      String sql ="select *from gly";
      try {
	      Connection conn = DBtools.createConnection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(sql);
	      ArrayList<Users> list =new ArrayList<>();
	      String pow = "gly";
	      while(rs.next()){
	           Users user =new Users(rs.getString("id"), rs.getString("pass"), pow);
	           list.add(user);
	      }
	      DBtools.closeResult(rs);
	      DBtools.closeStatement(stmt);
	      DBtools.closeConnection(conn);
	      for(Users u : list){
	      
	      
	      final String myaccount=u.getId();     
	   	  final String mypassword=u.getPassword();
	      if (account .equals(myaccount) && password .equals(mypassword) ) {
	      // 设置响应内容类型
	      response.setContentType("text/html;charset=UTF-8");

	      // 要重定向的新位置
	      
	      /*String site = new String("http://localhost:8080/web0515/web0515_01/sql_cs1");

	      response.setStatus(response.SC_MOVED_TEMPORARILY);
	      response.setHeader("Location", site); */
	      
	      //response.sendRedirect("sql_cs1?value=1");
	      
	      request.getSession().setAttribute("value", "ok");
	      response.sendRedirect("sql_cs1");

	      }
	      
	      
	      }
      }
	      catch (SQLException e) {
	            e.printStackTrace();
	        }
	    PrintWriter out = response.getWriter();
	  	out.println("<script type=\"text/javascript\">");
	  	out.println("alert('warning!');");
	  	out.println("</script>");
	  	//response.sendRedirect("/web0515/try_cdx.jsp");
    }
	  
} 
