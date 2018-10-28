package DB;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class MysqlPool {
    //这就是我们的池子，想下为啥用static，为啥用LinkedList
    private static LinkedList<Connection> pool = new LinkedList<Connection>();
    //池水的深度（哈哈，其实就是最大连接数）
    private static int maxCount=20;

    public static void init(){//初始化，就是让20个连接有意义
        try{
            for(int i=0;i<maxCount;i++){
                MysqlHandler handler=new MysqlHandler();
                Connection connection = handler.buildConnection();//建立连接，并放于池中，不用担心这个连接找不到了，因为已经是池中之物了
                pool.add(connection);
            }
        }catch(Exception e){//此处threw exception更好，为何？
            e.printStackTrace();
        }
    }

    public static Connection getConnecton(){//从池中获取一个连接
        if(pool.size()==0)//分配完了
        {
            return null;//没有连接可用
        }
        else{
            return pool.remove(0);//删除第一个对象并返回
        }
    }

    public static void release(Connection connection){//使用完的归还给池子
        pool.add(connection);
    }
}
