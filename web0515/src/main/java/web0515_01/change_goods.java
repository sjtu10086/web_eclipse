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
 * Servlet implementation class change_goods
 */
@WebServlet("/change_goods")
public class change_goods extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的id值
        String name  =req.getParameter("id");
        try {//通过id值检索对应的对象
            String sql ="select *from goods where name ="+"'"+name+"'";
            //执行sql语句获取该对象
            ResultSet rs = DBtools.executeQuery(sql);
            HashMap<String, Integer> hash_dd = new HashMap<String, Integer>();
            while(rs.next()){
            	hash_dd.put(rs.getString("name"), rs.getInt("price"));

            }
            System.out.println(rs);
            //对该对象的值进行展示,方便修改
            //先获取该对象的值,记住id值不可修改
            //实例化一个对象来储存当前值
            req.setAttribute("value",hash_dd);
            req.getRequestDispatcher("../sql_change_goods.jsp").forward(req,resp);
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
