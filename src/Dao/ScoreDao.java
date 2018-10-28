package Dao;

import Entity.Score;
import Util.Mysql;

import java.util.List;

/**
 * Created by miaohualin on 2018/5/8.
 */
public class ScoreDao {
    Mysql mysql = new Mysql();
    public boolean add(Score admit){
        String sql ="insert into bkmd(id,name,sex,csrq,mz,ksly,xz,nj,zymc,txdz,km1dm,km1bmh,bmd)values ('"+admit.getId()+"','"+admit.getName()+"','"+admit.getSex()+"','"+admit.getCsrq()+"','"+admit.getMz()+"','"+admit.getKsly()+"','"+admit.getXz()+"','"+admit.getNj()+"','"+admit.getZymc()+"','"+admit.getTxdz()+"','"+admit.getKm1dm()+"','"+admit.getKm1bmh()+"','"+admit.getBmd()+"');";
        boolean isAdd = mysql.add(sql);
        return isAdd;
    }
    public boolean delete(){
        String sql = "delete from bkmd;";
        boolean isDel = mysql.delete(sql);
        return isDel;
    }
    public List<Score> queryById(String id){
        String sql ="select * from bkmd where id = '"+id+"';";
        return mysql.mappingScore(sql);
    }
    public List<Score> queryByName(String name ){
        String sql ="select * from bkmd where name = '"+name+"';";
        return mysql.mappingScore(sql);
    }
    public int getCount(){
        String sql = "select count(*) as totle from bkmd;";
        return mysql.getCount(sql);
    }
    public boolean isExist(String id){
        String sql = "select * from bkmd where id = '"+id+"';";
        return mysql.isExist(sql);
    }
    public static void main(String[] args){
        List<Score> scoreList = new ScoreDao().queryById("211203199003310524");
        System.out.println(scoreList.size());
    }
}
