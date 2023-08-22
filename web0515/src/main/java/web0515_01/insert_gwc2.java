package web0515_01;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class insert_gwc2
 */
@WebServlet("/insert_gwc2")
public class insert_gwc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_gwc2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String cus_id = (String) request.getSession().getAttribute("cus_id");
		String cus_pass = (String) request.getSession().getAttribute("cus_pass");
		String name =request.getParameter("name");
		String num = request.getParameter("num");
        //编写sql语句并执行
		//原数目因为奇怪的原因不能传过来
        if(num == "" || num == null){
        	System.out.println("修改数据某行为空!请重新输入!");
            System.out.println("<script>\n" +
                    "\t\tsetInterval(()=>{\n" +
                    "\t\t\twindow.history.back();\n" +
                    "\t\t},2000)\n" +
                    "\t</script>");
        } else {
            try {

                String changesql1 = "update cus_goods set  sum =" + num +" where id ='"+cus_id+"' and name = '" +name +"'";
            	
            	String changesql2 = "insert into cus_goods value ('" + cus_id +"','"+name+"',"+num +")";

                System.out.println(changesql1);
                int count = DBtools.executeUpdate(changesql1);
                if (count == 0) {
                	DBtools.executeUpdate(changesql2);
                	request.getSession().setAttribute("value", "yes");
      		      	request.getSession().setAttribute("cus_id", cus_id);
      		      	request.getSession().setAttribute("cus_pass", cus_pass);
                	response.sendRedirect("class_goumai");
                } else {
                	request.getSession().setAttribute("value", "yes");
      		      	request.getSession().setAttribute("cus_id", cus_id);
      		      	request.getSession().setAttribute("cus_pass", cus_pass);
                	response.sendRedirect("class_goumai");
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
