package Dao;

import Entity.Student;
import Util.Mysql;

import java.util.List;

public class StudentDao {
    public boolean add(Student student , String tablename){
        String sql = "insert into "+tablename+" (xm,sfzh,zymc,txdz,kmldm,kmlcj,riqi)values('"+student.getXm()+"','"+student.getSfzh()+"','"+student.getZymc()+"','"+student.getTxdz()+"','"+student.getKmldm()+"','"+student.getKmlcj()+"','"+student.getRiqi()+"')";
        Mysql mysql = new Mysql();
        return mysql.add(sql);
    }
    public boolean update(Student nestudent,Student oldstudent, String tablename){
        String sql = "update "+tablename+" set zymc = '"+nestudent.getZymc()+"',txdz = '"+nestudent.getTxdz()+"', kmldm = '"+nestudent.getKmlcj()+"' where sfzh = '"+oldstudent.getSfzh()+"'";
        Mysql mysql = new Mysql();
        return mysql.update(sql);
    }
    public List<Student> queryById(String id , String tablename){
        String sql = "select * from "+tablename+" where sfzh = '"+id+"'";
        Mysql mysql = new Mysql();
        return mysql.mappingStudent(sql);
    }
    /*public List<Student> queryByAll(){
        String sql = "select * from student";
        Mysql mysql = new Mysql();
        return mysql.mappingStudent(sql);
    }*/
    /*public List<String> queryByTime(){
        String sql = "select distinct riqi from student;";
        Mysql mysql = new Mysql();
        return mysql.mappingTime(sql);
    }*/
    public boolean isTableExit(String tableName){
        Mysql mysql = new Mysql();
        return mysql.isTableExit(tableName);
    }
    public boolean createTabel(String table_name){
        Mysql mysql = new Mysql();
        return mysql.createSecondTable(table_name);
    }
    public static void main(String[] args){
        String str = "成绩1234";
        System.out.println(str.substring(2));
    }
}
