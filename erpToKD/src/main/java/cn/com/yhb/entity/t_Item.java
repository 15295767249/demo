package cn.com.yhb.entity;

public class t_Item {
    private Integer fitemid;

    private Integer fitemclassid;

    private Integer fexternid;

    private String fnumber;

    private Integer fparentid;

    private Short flevel;

    private Boolean fdetail;

    private String fname;

    private Boolean funused;

    private String fbrno;

    private String ffullnumber;

    private Boolean fdiff;

    private Short fdeleted;

    private String fshortnumber;

    private String ffullname;

    private String uuid;

    private Integer fgrcommonid;

    private Integer fsystemtype;

    private Integer fusesign;

    private Short fchkuserid;

    private Integer fgrcontrol;

    private String frightuserid;

    private Integer fonsale;

    private byte[] fmodifytime;

    public Integer getFitemid() {
        return fitemid;
    }

    public void setFitemid(Integer fitemid) {
        this.fitemid = fitemid;
    }

    public Integer getFitemclassid() {
        return fitemclassid;
    }

    public void setFitemclassid(Integer fitemclassid) {
        this.fitemclassid = fitemclassid;
    }

    public Integer getFexternid() {
        return fexternid;
    }

    public void setFexternid(Integer fexternid) {
        this.fexternid = fexternid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public Integer getFparentid() {
        return fparentid;
    }

    public void setFparentid(Integer fparentid) {
        this.fparentid = fparentid;
    }

    public Short getFlevel() {
        return flevel;
    }

    public void setFlevel(Short flevel) {
        this.flevel = flevel;
    }

    public Boolean getFdetail() {
        return fdetail;
    }

    public void setFdetail(Boolean fdetail) {
        this.fdetail = fdetail;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Boolean getFunused() {
        return funused;
    }

    public void setFunused(Boolean funused) {
        this.funused = funused;
    }

    public String getFbrno() {
        return fbrno;
    }

    public void setFbrno(String fbrno) {
        this.fbrno = fbrno == null ? null : fbrno.trim();
    }

    public String getFfullnumber() {
        return ffullnumber;
    }

    public void setFfullnumber(String ffullnumber) {
        this.ffullnumber = ffullnumber == null ? null : ffullnumber.trim();
    }

    public Boolean getFdiff() {
        return fdiff;
    }

    public void setFdiff(Boolean fdiff) {
        this.fdiff = fdiff;
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

    public String getFfullname() {
        return ffullname;
    }

    public void setFfullname(String ffullname) {
        this.ffullname = ffullname == null ? null : ffullname.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getFgrcommonid() {
        return fgrcommonid;
    }

    public void setFgrcommonid(Integer fgrcommonid) {
        this.fgrcommonid = fgrcommonid;
    }

    public Integer getFsystemtype() {
        return fsystemtype;
    }

    public void setFsystemtype(Integer fsystemtype) {
        this.fsystemtype = fsystemtype;
    }

    public Integer getFusesign() {
        return fusesign;
    }

    public void setFusesign(Integer fusesign) {
        this.fusesign = fusesign;
    }

    public Short getFchkuserid() {
        return fchkuserid;
    }

    public void setFchkuserid(Short fchkuserid) {
        this.fchkuserid = fchkuserid;
    }

    public Integer getFgrcontrol() {
        return fgrcontrol;
    }

    public void setFgrcontrol(Integer fgrcontrol) {
        this.fgrcontrol = fgrcontrol;
    }

    public String getFrightuserid() {
        return frightuserid;
    }

    public void setFrightuserid(String frightuserid) {
        this.frightuserid = frightuserid == null ? null : frightuserid.trim();
    }

    public Integer getFonsale() {
        return fonsale;
    }

    public void setFonsale(Integer fonsale) {
        this.fonsale = fonsale;
    }

    public byte[] getFmodifytime() {
        return fmodifytime;
    }

    public void setFmodifytime(byte[] fmodifytime) {
        this.fmodifytime = fmodifytime;
    }
}