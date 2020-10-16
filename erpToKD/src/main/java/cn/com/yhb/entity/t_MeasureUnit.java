package cn.com.yhb.entity;

import java.math.BigDecimal;

public class t_MeasureUnit {
    private Integer fmeasureunitid;

    private Integer funitgroupid;

    private String fnumber;

    private String fauxclass;

    private String fname;

    private Integer fconversation;

    private BigDecimal fcoefficient;

    private Integer fprecision;

    private String fbrno;

    private Integer fitemid;

    private Integer fparentid;

    private Short fdeleted;

    private String fshortnumber;

    private String foperdate;

    private BigDecimal fscale;

    private Short fstandard;

    private Short fcontrol;

    private Integer fsystemtype;

    private String uuid;

    private byte[] fmodifytime;

    public Integer getFmeasureunitid() {
        return fmeasureunitid;
    }

    public void setFmeasureunitid(Integer fmeasureunitid) {
        this.fmeasureunitid = fmeasureunitid;
    }

    public Integer getFunitgroupid() {
        return funitgroupid;
    }

    public void setFunitgroupid(Integer funitgroupid) {
        this.funitgroupid = funitgroupid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFauxclass() {
        return fauxclass;
    }

    public void setFauxclass(String fauxclass) {
        this.fauxclass = fauxclass == null ? null : fauxclass.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Integer getFconversation() {
        return fconversation;
    }

    public void setFconversation(Integer fconversation) {
        this.fconversation = fconversation;
    }

    public BigDecimal getFcoefficient() {
        return fcoefficient;
    }

    public void setFcoefficient(BigDecimal fcoefficient) {
        this.fcoefficient = fcoefficient;
    }

    public Integer getFprecision() {
        return fprecision;
    }

    public void setFprecision(Integer fprecision) {
        this.fprecision = fprecision;
    }

    public String getFbrno() {
        return fbrno;
    }

    public void setFbrno(String fbrno) {
        this.fbrno = fbrno == null ? null : fbrno.trim();
    }

    public Integer getFitemid() {
        return fitemid;
    }

    public void setFitemid(Integer fitemid) {
        this.fitemid = fitemid;
    }

    public Integer getFparentid() {
        return fparentid;
    }

    public void setFparentid(Integer fparentid) {
        this.fparentid = fparentid;
    }

    public Short getFdeleted() {
        return fdeleted;
    }

    public void setFdeleted(Short fdeleted) {
        this.fdeleted = fdeleted;
    }

    public String getFshortnumber() {
        return fshortnumber;
    }

    public void setFshortnumber(String fshortnumber) {
        this.fshortnumber = fshortnumber == null ? null : fshortnumber.trim();
    }

    public String getFoperdate() {
        return foperdate;
    }

    public void setFoperdate(String foperdate) {
        this.foperdate = foperdate == null ? null : foperdate.trim();
    }

    public BigDecimal getFscale() {
        return fscale;
    }

    public void setFscale(BigDecimal fscale) {
        this.fscale = fscale;
    }

    public Short getFstandard() {
        return fstandard;
    }

    public void setFstandard(Short fstandard) {
        this.fstandard = fstandard;
    }

    public Short getFcontrol() {
        return fcontrol;
    }

    public void setFcontrol(Short fcontrol) {
        this.fcontrol = fcontrol;
    }

    public Integer getFsystemtype() {
        return fsystemtype;
    }

    public void setFsystemtype(Integer fsystemtype) {
        this.fsystemtype = fsystemtype;
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