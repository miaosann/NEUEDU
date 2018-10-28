package Entity;

import java.sql.Timestamp;

/**
 * Created by miaohualin on 2018/5/6.
 */
public class Excel_record {
    private String pici;
    private String name;
    private Timestamp createtime;

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
