package web0515_01;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class class_zc
 */
@WebServlet("/class_zc")
public class class_zc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class_zc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从客户端获取数据
    	String account=request.getParameter("account");
        String password=request.getParameter("mypassword");
        String name=request.getParameter("name");
        //定义sql语句将获取到的数据储存到数据库
        String sql ="insert into customer values('" + name + "', '" +account+"', '" +password + "')";
        String sql2 ="insert into account values('"+account+"',0)";
        System.out.println(sql);
        System.out.println(sql2);
        //获取返回值进行确认
        try {
            int count = DBtools.executeUpdate(sql);
            int count2 = DBtools.executeUpdate(sql2);
            if(count ==0 || count2 ==0){
                 System.out.println("注册失败~");
                 System.out.println("<script>\n" +
                        "\t\tsetInterval(()=>{\n" +
                        "\t\t\twindow.history.back();\n" +
                        "\t\t},2000)\n" +
                        "\t</script>");
            }else{
            	System.out.println("注册成功~");
            	response.sendRedirect("../try_cdx.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
