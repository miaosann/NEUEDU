package Entity;

public class Student {
    private String xm;
    private String sfzh;
    private String zymc;
    private String txdz;
    private String kmldm;
    private String kmlcj;
    private String riqi;

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }

    public String getTxdz() {
        return txdz;
    }

    public void setTxdz(String txdz) {
        this.txdz = txdz;
    }

    public String getKmldm() {
        return kmldm;
    }

    public void setKmldm(String kmldm) {
        this.kmldm = kmldm;
    }

    public String getKmlcj() {
        return kmlcj;
    }

    public void setKmlcj(String kmlcj) {
        this.kmlcj = kmlcj;
    }
    public Student(String riqi){
        this.riqi = riqi;
    }
    public Student(){

    }
}
