package web0515_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
 
public class sql_cs1 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//String pow  =req.getParameter("value");
    	String pow = (String) req.getSession().getAttribute("value");

    	if (pow.equals("ok")) {
        String sql ="select *from users";
        System.out.println("此步正常");
        try {
            Connection conn = DBtools.createConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            HashMap<String, String> hash_dd = new HashMap<String, String>();
            while(rs.next()){
            	hash_dd.put(rs.getString("id"), rs.getString("pass"));

            }
            DBtools.closeResult(rs);
            DBtools.closeStatement(stmt);
           DBtools.closeConnection(conn);
            req.setAttribute("value",hash_dd);
            req.getRequestDispatcher("../users.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
 
    }else {
    	System.out.println(pow);
    	PrintWriter out = resp.getWriter();
	  	out.println("<script type=\"text/javascript\">");
	  	out.println("alert('warning!');");
	  	out.println("</script>");
    }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
 
}
