package Dao;

import Entity.Admit;
import Util.Mysql;

import java.util.List;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class AdmitDao {
    Mysql mysql = new Mysql();
    public boolean add(Admit admit , String table_name){
        String sql ="insert into "+table_name+"(id,name,sex,peiyang,major,xuezhi,tuition,school,pici)values ('"+admit.getId()+"','"+admit.getName()+"','"+admit.getSex()+"','"+admit.getPeiyang()+"','"+admit.getMajor()+"','"+admit.getXuezhi()+"','"+admit.getTuition()+"','"+admit.getSchool()+"','"+admit.getPici()+"')";
        //String sql = "insert into neu1803(id,name,sex,peiyang,major,xuezhi,tuition,school,pici)values ('342221199012102121','尚玉彤','女','专升本','会计学','2年','70.0','安徽合肥长风教育投资奥鹏学习中心[33]','1803')";
        System.out.println("sql："+sql);
        boolean isAdd = mysql.add(sql);
        return isAdd;
    }
    public boolean delete(Admit admit , String table_name){
        String sql ="delete from "+table_name+" where id="+admit.getId();
        boolean isDelete =mysql.delete(sql);
        return isDelete;
    }
    public boolean update(Admit admit ,Admit newAdmit , String table_name){
        String sql="update "+table_name+" set name='"+newAdmit.getName()+"',peiyang='"+newAdmit.getPeiyang()+"',major='"+newAdmit.getMajor()+"',xuezhi='"+newAdmit.getXuezhi()+"'tuition='"+newAdmit.getTuition()+"'school='"+newAdmit.getSchool()+"',pici='"+newAdmit.getPici()+"'"+ " where id='"+admit.getId()+"'";
        return mysql.update(sql);
    }
    public List<Admit> queryById(String id ,  String table_name){
        String sql ="select * from "+table_name+" where id = '"+id+"'";
        return mysql.mappingAdmit(sql);
    }
    public List<Admit> queryByName(String name ,  String table_name){
        String sql ="select * from "+table_name+" where name = '"+name+"'";
        return mysql.mappingAdmit(sql);
    }
    public boolean isExist(String name ,  String table_name){
        String sql = "select * from "+table_name+" where name = '"+name+"'";
        return mysql.isExist(sql);
    }
    public boolean createTabel(String table_name){
        return mysql.createTable(table_name);
    }
    public boolean isTableExit(String tableName){
        return mysql.isTableExit(tableName);
    }

    public static void main(String[] args){
        AdmitDao admitDao = new AdmitDao();
        Admit admit = new Admit();
        Boolean isSuc = admitDao.add(admit,"SSS");
        System.out.println("LOJBTY:"+isSuc);
    }
}
