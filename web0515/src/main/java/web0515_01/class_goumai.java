package web0515_01;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class class_goumai
 */
@WebServlet("/class_goumai")
public class class_goumai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class_goumai() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pow = (String) req.getSession().getAttribute("value");
		String cus_id = (String) req.getSession().getAttribute("cus_id");
		String cus_pass = (String) req.getSession().getAttribute("cus_pass");
		//System.out.println(cus_id);
    	if (pow.equals("yes") || pow.equals("no")) {
		
		String sql ="select *from cs0517.goods";
        
        try {
            ResultSet rs = DBtools.executeQuery(sql);
            HashMap<String, Integer> hash_go = new HashMap<String, Integer>();
            while(rs.next()){
            	hash_go.put(rs.getString("name"), rs.getInt("price"));
            }
            DBtools.closeResult(rs);
            req.setAttribute("value",hash_go);
            req.setAttribute("power",pow);
            req.setAttribute("cus_id",cus_id);
            req.setAttribute("cus_pass",cus_pass);
            req.getRequestDispatcher("../goumai.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }}/*
    	else if (pow.equals("no")) {
    		
    	
    	}*/
 
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
