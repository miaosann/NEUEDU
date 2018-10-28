package Entity;

import java.sql.Timestamp;

/**
 * Created by miaohualin on 2018/5/10.
 */
public class cj_record {
    private String tablename;
    private Timestamp createtime;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
