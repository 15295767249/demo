package cn.com.yhb.entity;

public class t_ItemClass {
    private Integer fitemclassid;

    private String fnumber;

    private String fname;

    private String fnameCht;

    private String fnameEn;

    private String fsqltablename;

    private Short fversion;

    private Boolean fimport;

    private String fbrno;

    private Integer fuserdefilast;

    private Short ftype;

    private Short fgrtype;

    private String fremark;

    private Integer fgrcontrol;

    private String uuid;

    private byte[] fmodifytime;

    public Integer getFitemclassid() {
        return fitemclassid;
    }

    public void setFitemclassid(Integer fitemclassid) {
        this.fitemclassid = fitemclassid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFnameCht() {
        return fnameCht;
    }

    public void setFnameCht(String fnameCht) {
        this.fnameCht = fnameCht == null ? null : fnameCht.trim();
    }

    public String getFnameEn() {
        return fnameEn;
    }

    public void setFnameEn(String fnameEn) {
        this.fnameEn = fnameEn == null ? null : fnameEn.trim();
    }

    public String getFsqltablename() {
        return fsqltablename;
    }

    public void setFsqltablename(String fsqltablename) {
        this.fsqltablename = fsqltablename == null ? null : fsqltablename.trim();
    }

    public Short getFversion() {
        return fversion;
    }

    public void setFversion(Short fversion) {
        this.fversion = fversion;
    }

    public Boolean getFimport() {
        return fimport;
    }

    public void setFimport(Boolean fimport) {
        this.fimport = fimport;
    }

    public String getFbrno() {
        return fbrno;
    }

    public void setFbrno(String fbrno) {
        this.fbrno = fbrno == null ? null : fbrno.trim();
    }

    public Integer getFuserdefilast() {
        return fuserdefilast;
    }

    public void setFuserdefilast(Integer fuserdefilast) {
        this.fuserdefilast = fuserdefilast;
    }

    public Short getFtype() {
        return ftype;
    }

    public void setFtype(Short ftype) {
        this.ftype = ftype;
    }

    public Short getFgrtype() {
        return fgrtype;
    }

    public void setFgrtype(Short fgrtype) {
        this.fgrtype = fgrtype;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public Integer getFgrcontrol() {
        return fgrcontrol;
    }

    public void setFgrcontrol(Integer fgrcontrol) {
        this.fgrcontrol = fgrcontrol;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public byte[] getFmodifytime() {
        return fmodifytime;
    }

    public void setFmodifytime(byte[] fmodifytime) {
        this.fmodifytime = fmodifytime;
    }
}