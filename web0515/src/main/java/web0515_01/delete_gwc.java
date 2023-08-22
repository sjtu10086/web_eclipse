package web0515_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class delete_gwc
 */
@WebServlet("/delete_gwc")
public class delete_gwc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_gwc() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到要删除的对应id值
        String good_id  =req.getParameter("good_id");
        String cust_id = (String)req.getSession().getAttribute("cus_id");
        System.out.println(good_id);
        System.out.println(cust_id);
        String sql ="delete  from cus_goods where name ="+"'"+good_id+"' and id = '" +cust_id+ "'";
        //调用方法进行执行
        try {
            int count = DBtools.executeUpdate(sql);
            if(count!=0){
            	PrintWriter out = resp.getWriter();
            	System.out.println("删除成功");
            	out.println("<script type=\"text/javascript\">");
            	out.println("alert('删除成功');");
            	out.println("</script>");
            	resp.sendRedirect("/web0515/web0515_01/cust_space");
            }else{
            System.out.println("删除失败~");
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
