package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class ConnectionPool {
    private static final String DatabaseUser = "root";
    private static final String DatabasePass = "miaohualin";
    private static final String DatabaseUrl = "jdbc:mysql://localhost:3306/neuedu?useUnicode=true&characterEncoding=utf8";
   /* private static final int INIT_COUNT = 5;
    private static final int MAX_COUNT = 30;*/
    private static ConnectionPool instance;
    private List<Connection> pool;
    private List<Connection> using;
    private int size;

    private ConnectionPool(int size){
        this.size = size;
        pool = new ArrayList<Connection>();
        using = new ArrayList<Connection>();
        for (int i = 0 ; i < size ; i++){
            pool.add(openAConnection());
        }
    }

    public static ConnectionPool getInstance(){
        if (instance==null){
            synchronized (ConnectionPool.class){
                if (instance == null){
                    instance = new ConnectionPool(15);
                }
            }
        }
        return instance;
    }

    public Connection getConn() {
        synchronized (this) {
            for (int i = 0; i < pool.size(); i++) {
                try {
                    if (pool.get(i).isClosed()) {
                        pool.remove(i);
                        i--;
                    }
                } catch (SQLException ignored) {
                }
            }
            for (int i = 0; i < using.size(); i++) {
                try {
                    if (using.get(i).isClosed()) {
                        using.remove(i);
                        i--;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for (int i = pool.size(); i + using.size() < size; i++) {
                pool.add(openAConnection());
            }
            if (pool.size() == 0) {
                Connection cn = openAConnection();
                using.add(cn);
                return cn;
            }
            Connection c = pool.remove(0);
            using.add(c);
            return c;
        }
    }
    public boolean retConn(Connection c) {
        synchronized (this) {
            for (int i = 0;i < using.size();i++) {
                if (c == using.get(i)) {
                    using.remove(i);
                    pool.add(c);
                    return true;
                }
            }
            try {
                c.close();
            } catch (SQLException ignored) {
            }
            return false;

        }
    }

    private Connection openAConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DatabaseUrl,DatabaseUser,DatabasePass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
