package web0515_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Servlet implementation class insert_gwc
 */
@WebServlet("/insert_gwc")
public class insert_gwc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_gwc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的id值
    	String cus_id = (String) req.getSession().getAttribute("cus_id");
    	String cus_pass = (String) req.getSession().getAttribute("cus_pass");
    	
        String good_id  =req.getParameter("good_id");
        System.out.println(cus_id);
        System.out.println(good_id);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        int flag = 0;
        try {//通过id值检索对应的对象
            String sql ="select * from customer where id =" + "'" + cus_id + "'";
            //执行sql语句获取该对象
            ResultSet rs = DBtools.executeQuery(sql);
            if(rs.next()){
            	String pass = rs.getString("password");
            	if (pass.equals(cus_pass)) {
            		flag = 1;
            	}
            }
            
            
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag == 1) {
        
	        try {//通过id值检索对应的对象
	            String sql2 ="select *from cus_goods where id =" + "'"+cus_id+"'" +" and name = " + "'"+good_id+"'";
	            System.out.println(sql2);
	            String p ="ok";
	            //执行sql语句获取该对象
	            ResultSet rs = DBtools.executeQuery(sql2);
	            HashMap<String, Integer> hash_dd = new HashMap<String, Integer>();
	            while(rs.next()){
	            	hash_dd.put(rs.getString("name"), rs.getInt("sum"));
	            	
	            	System.out.println(rs.getString("name"));
	            	System.out.println(rs.getInt("sum"));
	            }
	            if (hash_dd.isEmpty()) {
	            	hash_dd.put(good_id, 0);
	            }
	            //对该对象的值进行展示,方便修改
	            //先获取该对象的值,记住id值不可修改
	            //实例化一个对象来储存当前值
	            
	            req.setAttribute("value",hash_dd);
	            req.setAttribute("p",p);
	            req.setAttribute("id",cus_id);
	            req.setAttribute("pass",cus_pass);
	            req.getRequestDispatcher("../insert_gwc.jsp").forward(req,resp);
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
        }
        else {
        	PrintWriter out = resp.getWriter();
    	  	out.println("<script type=\"text/javascript\">");
    	  	out.println("alert('warning!');");
    	  	out.println("</script>");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
