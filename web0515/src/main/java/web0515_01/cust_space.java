package web0515_01;

import java.io.IOException;
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
 * Servlet implementation class cust_space
 */
@WebServlet("/cust_space")
public class cust_space extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cust_space() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cus_id = (String) request.getSession().getAttribute("cus_id");
		String cus_pass = (String) request.getSession().getAttribute("cus_pass");
		String p = (String) request.getSession().getAttribute("p");
		int account = 0;
		if (p.equals("ok")) {
			String sql2 ="select * from account where id ="+"'"+cus_id+"'";
	        System.out.println(sql2);
	        //调用方法进行执行
	        try {
	        	ResultSet rs = DBtools.executeQuery(sql2);
	        	while (rs.next()) {
	            account = rs.getInt("money");
	        	}
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			String sql ="select * from cus_goods natural join goods where id = " + cus_id;
		      try {
			      Connection conn = DBtools.createConnection();
			      Statement stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery(sql);
			      ArrayList<cus_good> list =new ArrayList<>();
			      while(rs.next()){
			    	  cus_good cg =new cus_good(rs.getString("id"), rs.getString("name"), rs.getInt("sum"), rs.getInt("price"));
			          list.add(cg);
			      }
			      DBtools.closeResult(rs);
			      DBtools.closeStatement(stmt);
			      DBtools.closeConnection(conn);
			      for(cus_good c : list){
			      
			      
			      final String name = c.getG_id();
			   	  final int num = c.getNum();
			   	  System.out.println(name);
			   	System.out.println(num);
			      

			      
			      }
			      /*
			      response.setContentType("text/html;charset=UTF-8");
			      request.getSession().setAttribute("list", list);
			      response.sendRedirect("../users.jsp");
			      */
			      request.setAttribute("list",list);
			      request.setAttribute("account",account);
		          request.getRequestDispatcher("../gwc.jsp").forward(request,response);
		      }
			      catch (SQLException e) {
			            e.printStackTrace();
			        }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
