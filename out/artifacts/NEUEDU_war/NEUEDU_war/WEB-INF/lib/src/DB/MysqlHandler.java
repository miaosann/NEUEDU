package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class MysqlHandler {
    //依然是那熟悉的三个必备参数
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    //建立数据库连接，此处仅用于提供原始连接，供放入池中使用
    public Connection buildConnection() {
        String driver = "com.mysql.jdbc.Driver";//MySQL数据库的驱动程序名
        String url = "jdbc:mysql://localhost:3306/neuedu?useUnicode=true&characterEncoding=utf-8";//数据库连接字符串
        String user = "root";//用户名
        String password = "miaohualin";//密码
        try{
            Class.forName(driver);//加载驱动程序
            conn= DriverManager.getConnection(url,user,password);//输入必备参数，获取连接
        }
        catch(Exception ex){
            ex.printStackTrace();//可以输出比较详细的异常信息
        }
        return conn;
    }
    //操作1，“增删改查”中，增、删、改都是执行sql语句，无需返回ResultSet结果集，所以设置为一个方法
    public int execute(String sql){
        try {
            conn=MysqlPool.getConnecton();//用时从池中取，很爽快
            stmt=conn.createStatement();
            int affectedCount = stmt.executeUpdate(sql);//此处真正执行stmt定义的操作
            return affectedCount;//这个是收到影响的行数
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;//返回-1，表示执行失败了，有异常
        }
    }
    //操作2，如果是查询，需返回结果集
    public ResultSet query(String sql)throws Exception{
        try{
            conn=MysqlPool.getConnecton();//用时从池中取，很爽快
            stmt=conn.createStatement();
            rs = stmt.executeQuery(sql);//执行pstmt中定义的查询
            return rs;//将结果集返回
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    //操作3，释放资源
    public void sayGoodbye(){
        //此处注意，conn在池中管理，此处无需关闭
        if(rs!=null){//关闭结果集，这个不关闭也浪费
            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(stmt!=null){//关闭Statement，不要浪费
            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        MysqlPool.release(conn);
    }
}
