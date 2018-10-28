package Entity;

/**
 * Created by miaohualin on 2018/5/8.
 */
public class Score {
    private String id;
    private String name;
    private String sex;
    private String csrq; //出生日期
    private String mz;     //民族
    private String ksly; //考生来源
    private String xz;  //学制
    private String nj;  //年级
    private String zymc; //专业名称
    private String txdz; //通讯地址
    private String km1dm; //科目一代码
    private String km1bmh;
    private String bmd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getKsly() {
        return ksly;
    }

    public void setKsly(String ksly) {
        this.ksly = ksly;
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getTxdz() {
        return txdz;
    }

    public void setTxdz(String txdz) {
        this.txdz = txdz;
    }

    public String getKm1dm() {
        return km1dm;
    }

    public void setKm1dm(String km1dm) {
        this.km1dm = km1dm;
    }

    public String getKm1bmh() {
        return km1bmh;
    }

    public void setKm1bmh(String km1bmh) {
        this.km1bmh = km1bmh;
    }

    public String getBmd() {
        return bmd;
    }

    public void setBmd(String bmd) {
        this.bmd = bmd;
    }
}
