package web0515_01;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class change_goods2
 */
@WebServlet("/change_goods2")
public class change_goods2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_goods2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        String price =request.getParameter("price");
        //编写sql语句并执行
        if(price == null){
        	System.out.println("修改数据错误!请重新输入!");
            System.out.println("<script>\n" +
                    "\t\tsetInterval(()=>{\n" +
                    "\t\t\twindow.history.back();\n" +
                    "\t\t},2000)\n" +
                    "\t</script>");
        } else {
            try {
                String changesql = "update goods set  price ='" +price+"' where name ='"+name+"'";
                System.out.println(changesql);
                int count = DBtools.executeUpdate(changesql);
                if (count == 0) {
                	System.out.println("修改失败~");
                	System.out.println("<script>\n" +
                            "\t\tsetInterval(()=>{\n" +
                            "\t\t\twindow.history.back();\n" +
                            "\t\t},2000)\n" +
                            "\t</script>");
                } else {
                	response.sendRedirect("/web0515/web0515_01/class_goods");
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
