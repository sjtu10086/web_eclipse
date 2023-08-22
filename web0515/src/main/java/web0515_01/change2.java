package web0515_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class change2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String id =request.getParameter("id");
	        String password =request.getParameter("password");
	        //编写sql语句并执行
	        if(password == "" || password == null){
	        	System.out.println("修改数据某行为空!请重新输入!");
	            System.out.println("<script>\n" +
	                    "\t\tsetInterval(()=>{\n" +
	                    "\t\t\twindow.history.back();\n" +
	                    "\t\t},2000)\n" +
	                    "\t</script>");
	        } else {
	            try {
	                String changesql = "update users set  pass ='" +password+"' where id ='"+id+"'";
	                System.out.println(changesql);
	                int count = DBtools.executeUpdate(changesql);
	                if (count == 0) {
	                	System.out.println("修改失败~");
	                	System.out.println("<script>\n" +
	                            "\t\tsetInterval(()=>{\n" +
	                            "\t\t\twindow.history.back();\n" +
	                            "\t\t},2000)\n" +
	                            "\t</script>");
	                } else {
	                	response.sendRedirect("/web0515/web0515_01/sql_cs1");
	                }
	            } catch (SQLException e) {
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
