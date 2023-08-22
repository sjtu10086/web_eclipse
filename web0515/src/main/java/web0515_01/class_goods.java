package web0515_01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class class_goods
 */
@WebServlet("/class_goods")
public class class_goods extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pow = (String) req.getSession().getAttribute("value");

    	if (pow.equals("ok")) {
		
		String sql ="select *from cs0517.goods";

        
        try {
            ResultSet rs = DBtools.executeQuery(sql);
            HashMap<String, Integer> hash_go = new HashMap<String, Integer>();
            while(rs.next()){
            	hash_go.put(rs.getString("name"), rs.getInt("price"));
            }
            DBtools.closeResult(rs);
            req.setAttribute("value",hash_go);
            req.getRequestDispatcher("../goods.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    	
 
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
