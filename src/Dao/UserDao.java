package Dao;

import Entity.User;
import Util.Mysql;

import java.util.List;

public class UserDao {
    public boolean add(User user){
        String sql = "insert into user (zhanghao, password) values ('"+user.getZhanghao()+"','"+user.getPassword()+"')";
        Mysql mysql = new Mysql();
        return mysql.add(sql);
    }
    public boolean update(User user,User olduser){
        String sql = "update user set password ='"+user.getPassword()+"' where zhanghao ='"+olduser.getZhanghao()+"' and password = '"+olduser.getPassword()+"'";
        Mysql mysql = new Mysql();
        return mysql.update(sql);
    }
    public boolean delete(String zhanghao){
        String sql = "delete from user where zhanghao = '"+zhanghao+"'";
        Mysql mysql = new Mysql();
        boolean isDel = mysql.delete(sql);
        return isDel;
    }
    public List<User> queryforlogin(String zhanghao, String password){
        String sql = "select * from user where zhanghao = '"+zhanghao+"' and password = '"+password+"';";
        //System.out.println(sql);
        Mysql mysql = new Mysql();
        return mysql.mappingUser(sql);
    }
    public List<User> queryAll(){
        String sql = "select * from user;";
        Mysql mysql = new Mysql();
        return mysql.mappingUser(sql);
    }
}
