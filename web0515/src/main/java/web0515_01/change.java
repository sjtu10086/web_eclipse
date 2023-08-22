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
 * 对数据进行修改
 */
@WebServlet("/cp7/user/change")
public class change extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的id值
        String id  =req.getParameter("id");
        try {//通过id值检索对应的对象
            String sql ="select *from users where id ="+"'"+id+"'";
            String p ="ok";
            //执行sql语句获取该对象
            ResultSet rs = DBtools.executeQuery(sql);
            HashMap<String, String> hash_dd = new HashMap<String, String>();
            while(rs.next()){
            	hash_dd.put(rs.getString("id"), rs.getString("pass"));

            }
            System.out.println(rs);
            //对该对象的值进行展示,方便修改
            //先获取该对象的值,记住id值不可修改
            //实例化一个对象来储存当前值
            req.setAttribute("value",hash_dd);
            req.setAttribute("p",p);
            req.getRequestDispatcher("../sql_change.jsp").forward(req,resp);
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
