package web0515_01;

import web0515_01.DBtools;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
 
public class MyDQLDemo2{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        String sql ="select *from users";
        System.out.println("此步正常");
        try {
            Connection conn = DBtools.createConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            HashMap<String, String> hash_dd = new HashMap<String, String>();
            while(rs.next()){
            	hash_dd.put(rs.getString("id"), rs.getString("pass"));
            	System.out.println(rs.getString("id"));
            }
            DBtools.closeResult(rs);
            DBtools.closeStatement(stmt);
           DBtools.closeConnection(conn);
            //req.setAttribute("value",hash_dd);
            //req.getRequestDispatcher("../users.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
 
    }
 
}
