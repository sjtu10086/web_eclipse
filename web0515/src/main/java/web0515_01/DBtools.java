package web0515_01;

import java.sql.*;
 
/**
 * 将数据库的一些连接操作进行封装
 */
public class DBtools {
 
    //静态注册驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static final String DB_URL = "jdbc:mysql://localhost:3306/cs0517?cs0517SSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//这里为自己表所在的数据库名称
    static final String USERNAME = "root";
    static final String PASSWORD = "20052017fy";
    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        return conn;
    }
 
    public static int executeUpdate(String sql) throws SQLException {
        //再次用于执行创建stmt对象执行sql语句
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        closeStatement(stmt);
        closeConnection(conn);
        return count;
    }
 
        //这是查询SQL语句
    public static ResultSet executeQuery(String sql) throws SQLException {
 
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
 
    //资源释放方法,这里编写的时方法,无须执行,只能进行调用
    public static void closeResult(ResultSet rs) throws SQLException {
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void closeStatement(Statement stmt) throws SQLException {
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
    public static void closeConnection(Connection conn) throws SQLException {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
 
 
}
