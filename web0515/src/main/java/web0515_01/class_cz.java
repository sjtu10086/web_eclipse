package web0515_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class class_cz
 */
@WebServlet("/class_cz")
public class class_cz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class_cz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到要删除的对应id值
    	String Cid = (String)req.getSession().getAttribute("cus_id");
    	String money= req.getParameter("money");
    	int mon = Integer.parseInt(money);
        int account = 0;
        
        System.out.println(money);
        String sql2 ="select * from account where id ="+"'"+Cid+"'";
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
        int last = account + mon;
        String sql3 ="update account set  money =" +last+" where id ='"+Cid+"'";
        System.out.println(sql3);
        try {
            int count = DBtools.executeUpdate(sql3);
            if(count != 0){
            	PrintWriter out = resp.getWriter();
            	System.out.println("充值成功");
            	out.println("<script type=\"text/javascript\">");
            	out.println("alert('充值成功');");
            	out.println("</script>");
            	resp.sendRedirect("/web0515/web0515_01/cust_space");
            }else{
            System.out.println("充值失败~");
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
