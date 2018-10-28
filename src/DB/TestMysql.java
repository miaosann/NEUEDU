package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class TestMysql {
    public static void main(String[] args)  {
        try {//捕获异常
            long start=System.currentTimeMillis();//产生一个当前的毫秒(自1970年1月1日0时起的毫秒数)
            MysqlPool.init();
            for(int i=0;i<1000;i++){
                testOneTime();
            }
            long end=System.currentTimeMillis();
            System.out.println("\n消耗时间："+(end-start)+"毫秒");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //测试一次完整查询
    private static void testOneTime()throws SQLException{//可能会有异常，我们在更广阔的天地捕获之
        Connection conn = MysqlPool.getConnecton();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        rs=stmt.executeQuery("select * from exam_record");
        rs.close();
        stmt.close();

        MysqlPool.release(conn);//注意Statement和ResultSet是需要释放的，而Connection放在池子里面循环使用，不必释放，为啥呢？因为Connection建立连接太耗时！

    }
}
