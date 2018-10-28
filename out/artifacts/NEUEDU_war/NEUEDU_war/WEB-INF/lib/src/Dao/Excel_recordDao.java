package Dao;

import Entity.Admit;
import Entity.Excel_record;
import Util.Mysql;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/6.
 */
public class Excel_recordDao {
    Mysql mysql = new Mysql();
    public boolean add(Excel_record admit){
        String sql ="insert into excel_record(pici,tablename,createtime)values ('"+admit.getPici()+"','"+admit.getName()+"','"+admit.getCreatetime()+"')";
        boolean isAdd = mysql.add(sql);
        return isAdd;
    }
    public List<Excel_record> queryByPici(String pici){
        String sql ="select * from excel_record where pici = '"+pici+"'";
        return mysql.mappingExcel(sql);
    }
    public List<Excel_record> queryAll(){
        String sql ="select * from excel_record ORDER BY createtime DESC;";
        return mysql.mappingExcel(sql);
    }
    public static void main(String[] args){
        Excel_recordDao excel_recordDao = new Excel_recordDao();
        Excel_record excel_record = new Excel_record();
        excel_record.setPici("123456");
        excel_record.setName("123456");
        excel_record.setCreatetime(new Timestamp(System.currentTimeMillis()));
        excel_recordDao.add(excel_record);
    }
}
