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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class save
 */
@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //从客户端获取数据
	        String id =request.getParameter("id");
	        String password =request.getParameter("password");
	 
	        //定义sql语句将获取到的数据储存到数据库
	        String sql ="insert into users(id,pass) values('"+id+"','"+password+"')";
	        //获取返回值进行确认
	        try {
	            int count = DBtools.executeUpdate(sql);
	            if(count ==0){
	                 System.out.println("保存失败~");
	                 System.out.println("<script>\n" +
	                        "\t\tsetInterval(()=>{\n" +
	                        "\t\t\twindow.history.back();\n" +
	                        "\t\t},2000)\n" +
	                        "\t</script>");
	            }else{
	            	System.out.println("保存成功~");
	            	response.sendRedirect("/web0515/web0515_01/sql_cs1");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
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
