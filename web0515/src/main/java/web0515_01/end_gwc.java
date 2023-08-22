package web0515_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class end_gwc
 */
@WebServlet("/end_gwc")
public class end_gwc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public end_gwc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到要删除的对应id值
    	req.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html;charset=UTF-8");
    	
        String id  =req.getParameter("id");
        int money = (int)req.getSession().getAttribute("money");
        int account = 0;
        System.out.println(money);
        String sql ="delete  from cus_goods where id ="+"'"+id+"' ";
        String sql2 ="select * from account where id ="+"'"+id+"'";
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
        int last = account - money;
        if (last < 0) {
        	PrintWriter out = resp.getWriter();
        	System.out.println("余额不足");
        	out.println("<script type=\"text/javascript\">");
        	out.println("alert('余额不足');");
        	out.println("</script>");
        }
        else {
        String sql3 ="update account set  money =" +last+" where id ='"+id+"'";
        try {
            int count = DBtools.executeUpdate(sql);
            int count2 = DBtools.executeUpdate(sql3);
            if(count!=0 && count2 != 0){
            	resp.sendRedirect("/web0515/web0515_01/cust_space");
            }else{
            System.out.println("删除失败~");
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
