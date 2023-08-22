package web0515_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class class_cust
 */
@WebServlet("/class_cust")
public class class_cust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class_cust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
	      String password=request.getParameter("mypassword");
	      
	      String sql ="select * from customer";
	      int ii = 0;
	      try {
		      Connection conn = DBtools.createConnection();
		      Statement stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(sql);
		      ArrayList<Users> list =new ArrayList<>();
		      String pow = "cus";
		      while(rs.next()){
		           Users user =new Users(rs.getString("id"), rs.getString("password"), pow);
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
		    	 ii = 1;
		      response.setContentType("text/html;charset=UTF-8");

		      // 要重定向的新位置
		      /*
		      String site = new String("http://localhost:8080/web0515/web0515_01/class_goods");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);*/
		      request.getSession().setAttribute("value", "yes");
		      request.getSession().setAttribute("cus_id", account);
		      request.getSession().setAttribute("cus_pass", password);
		      response.sendRedirect("class_goumai");
		      }
		      
		      
		      }
		      if (ii == 0) {
		      request.getSession().setAttribute("value", "no");
		      response.sendRedirect("class_goumai");
		      }
	      }
		      catch (SQLException e) {
		            e.printStackTrace();
		        }
		    PrintWriter out = response.getWriter();
		  	out.println("<script type=\"text/javascript\">");
		  	out.println("alert('warning');");
		  	out.println("</script>");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
