package Util;

import DB.ConnectionPool;
import Entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
   /* private  final String url = "jdbc:mysql://localhost:3306/neuedu?useUnicode=true&characterEncoding=utf8";
    private  final String user = "root";
    private  final String sqlPassword = "miaohualin";
    public static Mysql mysql = null;
    private static Connection con = null;
    public Mysql(){
        getCon();
    }
    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, sqlPassword);
            if (con.isClosed()) {
                System.exit(1);
                System.out.println("database connet error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Connection getCon() {
        if (con == null) {
            connect();
        }
        return con;
    }*/

    public boolean createTable(String tableName) {
        Connection con = ConnectionPool.getInstance().getConn();
        PreparedStatement statement = null;
        String sql = "CREATE TABLE " + tableName + " ("
                + " id varchar(18) NOT NULL,\n"
                + " name varchar(20) NOT NULL,\n"
                + " sex varchar(20) NOT NULL,\n"
                + " peiyang varchar(20) NOT NULL,\n"
                + " major varchar(20) NOT NULL,\n"
                + " xuezhi varchar(20) NOT NULL,\n"
                + " tuition double NOT NULL,\n"
                + " school varchar(50) NOT NULL,\n"
                + " pici varchar(20) NOT NULL,\n"
                + " PRIMARY KEY (id)"
                + ")"
                + " ENGINE=InnoDB DEFAULT CHARSET=utf8;";
       /* String addExcelRecordSQL = "insert into excel_record " +
                "(tableName,createTime) values " +
                "(?, ?);";*/
        try {
            statement = con.prepareStatement(sql);

           /* statement = con.prepareStatement(addExcelRecordSQL);
            statement.setString(1,tableName);
            statement.setTimestamp(2,new Timestamp(System.currentTimeMillis()));*/
            statement.executeUpdate();
            ConnectionPool.getInstance().retConn(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return false;
    }
   public boolean createSecondTable(String tableName) {
       Connection con = ConnectionPool.getInstance().getConn();
        PreparedStatement statement = null;
        String sql = "CREATE TABLE " + tableName + " ("
                + " sfzh varchar(18) NOT NULL,\n"
                + " xm varchar(20) NOT NULL,\n"
                + " zymc varchar(20) NOT NULL,\n"
                + " txdz varchar(20) NOT NULL,\n"
                + " kmldm varchar(20) NOT NULL,\n"
                + " kmlcj varchar(20) NOT NULL,\n"
                + " riqi varchar(20) NOT NULL,\n"
                + " PRIMARY KEY (sfzh)"
                + ")"
                + " ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        try {
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            ConnectionPool.getInstance().retConn(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
       ConnectionPool.getInstance().retConn(con);
        return false;
    }
    public boolean isTableExit(String tableName) {
        Connection con = ConnectionPool.getInstance().getConn();
        /*String sql = "SELECT DISTINCT t.table_name, n.SCHEMA_NAME " +
                "FROM information_schema.TABLES t, information_schema.SCHEMATA n " +
                "WHERE t.table_name = '"+tableName+"' AND n.SCHEMA_NAME = 'neuedu';";*/
        String sql = "select TABLE_NAME from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA= 'neuedu' and TABLE_NAME='"+tableName+"';";
        boolean result = false;
        try{
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                result = true;
            }
            ConnectionPool.getInstance().retConn(con);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return result;
    }

    public boolean update(String sql) {
        Connection con = ConnectionPool.getInstance().getConn();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            ConnectionPool.getInstance().retConn(con);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Update error");
        }
        ConnectionPool.getInstance().retConn(con);
        return false;
    }
    public boolean add(String sql) {
        Connection con = ConnectionPool.getInstance().getConn();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            ConnectionPool.getInstance().retConn(con);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("Add error");
            }
        }
        ConnectionPool.getInstance().retConn(con);
        return false;
    }
    public  boolean delete(String sql) {
        Connection con = ConnectionPool.getInstance().getConn();
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            ConnectionPool.getInstance().retConn(con);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Delete error");
        }
        ConnectionPool.getInstance().retConn(con);
        return false;
    }
    public List<Admit> mappingAdmit(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<Admit> admits=null;
        try {
            admits=new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                Admit admit=new Admit();
                admit.setName(set.getString("name"));
                admit.setId(set.getString("id"));
                admit.setSex(set.getString("sex"));
                admit.setPeiyang(set.getString("peiyang"));
                admit.setMajor(set.getString("major"));
                admit.setXuezhi(set.getString("xuezhi"));
                admit.setTuition(set.getFloat("tuition"));
                admit.setSchool(set.getString("school"));
                admit.setPici(set.getString("pici"));
                admits.add(admit);
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return admits;
    }
    public List<Student> mappingStudent(String sql) {
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<Student> students = null;
        try {
            students = new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Student student = new Student();
                student.setXm(set.getString("xm"));
                student.setSfzh(set.getString("sfzh"));
                student.setZymc(set.getString("zymc"));
                student.setTxdz(set.getString("txdz"));
                student.setKmldm(set.getString("kmldm"));
                student.setKmlcj(set.getString("kmlcj"));
                student.setRiqi(set.getString("riqi"));
                students.add(student);
            }
            statement.close();
            set.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return students;
    }
    public List<String> mappingTime(String sql) {
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<String> students = null;
        try {
            students = new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                String student = set.getString("riqi");
                students.add(student);
            }
            statement.close();
            set.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return students;
    }
    public List<Excel_record> mappingExcel(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<Excel_record> students=null;
        try {
            students=new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                Excel_record admit = new Excel_record();
                admit.setPici(set.getString("pici"));
                admit.setName(set.getString("tablename"));
                admit.setCreatetime(set.getTimestamp("createtime"));
                students.add(admit);
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return students;
    }
    public List<cj_record> mappingCj(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<cj_record> students=null;
        try {
            students=new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                cj_record admit = new cj_record();
                admit.setTablename(set.getString("tablename"));
                admit.setCreatetime(set.getTimestamp("createtime"));
                students.add(admit);
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return students;
    }
    public List<Score> mappingScore(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        ArrayList<Score> students=null;
        try {
            students=new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                Score score = new Score();
                score.setId(set.getString("id"));
                score.setName(set.getString("name"));
                score.setSex(set.getString("sex"));
                score.setCsrq(set.getString("csrq"));
                score.setMz(set.getString("mz"));
                score.setKsly(set.getString("ksly"));
                score.setXz(set.getString("xz"));
                score.setNj(set.getString("nj"));
                score.setZymc(set.getString("zymc"));
                score.setTxdz(set.getString("txdz"));
                score.setKm1dm(set.getString("km1dm"));
                score.setKm1dm(set.getString("km1bmh"));
                score.setBmd(set.getString("bmd"));
                students.add(score);
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return students;
    }
    public List<User> mappingUser(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        System.out.println("con:"+con);
        ArrayList<User> students=null;
        try {
            students=new ArrayList<>();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            //System.out.println(set.next());
            while (set.next()){
                User user = new User();
                user.setZhanghao(set.getString("zhanghao"));
                user.setPassword(set.getString("password"));
                //System.out.println("账号："+user.getZhanghao()+"  "+user.getPassword());
                students.add(user);
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        //System.out.println("student:"+students.size());
        return students;
    }
    public int getCount(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        int count = 0;
        try {
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()){
                count = set.getInt("totle");
            }
            statement.close();
            set.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return count;
    }
    public boolean isExist(String sql){
        Connection con = ConnectionPool.getInstance().getConn();
        try{
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            if (set.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ConnectionPool.getInstance().retConn(con);
        return false;
    }
    public static void main(String[] args){
        new Mysql().createSecondTable("Chengji");
    }
}
