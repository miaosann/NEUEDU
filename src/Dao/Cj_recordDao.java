package Dao;

import Entity.Excel_record;
import Entity.cj_record;
import Util.Mysql;

import java.util.List;

/**
 * Created by miaohualin on 2018/5/10.
 */
public class Cj_recordDao {
    Mysql mysql = new Mysql();
    public boolean add(cj_record admit){
        String sql ="insert into cj_record(tablename,createtime)values ('"+admit.getTablename()+"','"+admit.getCreatetime()+"')";
        boolean isAdd = mysql.add(sql);
        return isAdd;
    }
    public List<Excel_record> queryByPici(String pici){
        String sql ="select * from cj_record where tablename = '"+pici+"'";
        return mysql.mappingExcel(sql);
    }
    public List<cj_record> queryAll(){
        String sql ="select * from cj_record ORDER BY createtime DESC;";
        return mysql.mappingCj(sql);
    }
}
