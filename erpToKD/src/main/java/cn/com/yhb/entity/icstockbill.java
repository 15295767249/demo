package cn.com.yhb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class icstockbill {
    private Integer finterid;

    private String fbrno;

    private Short ftrantype;

    private Date fdate;

    private String fbillno;

    private String fuse;

    private String fnote;

    private Integer fdcstockid;

    private Integer fscstockid;

    private Integer fdeptid;

    private Integer fempid;

    private Integer fsupplyid;

    private Integer fposterid;

    private Integer fcheckerid;

    private Integer ffmanagerid;

    private Integer fsmanagerid;

    private Integer fbillerid;

    private Integer freturnbillinterid;

    private String fscbillno;

    private Integer fhookinterid;

    private Integer fvchinterid;

    private Short fposted;

    private Short fcheckselect;

    private Integer fcurrencyid;

    private Integer fsalestyle;

    private Integer facctid;

    private Short frob;

    private String frscbillno;

    private Short fstatus;

    private Boolean fupstockwhensave;

    private Boolean fcancellation;

    private Integer forgbillinterid;

    private Integer fbilltypeid;

    private Integer fpostyle;

    private Integer fmultichecklevel1;

    private Integer fmultichecklevel2;

    private Integer fmultichecklevel3;

    private Integer fmultichecklevel4;

    private Integer fmultichecklevel5;

    private Integer fmultichecklevel6;

    private Date fmulticheckdate1;

    private Date fmulticheckdate2;

    private Date fmulticheckdate3;

    private Date fmulticheckdate4;

    private Date fmulticheckdate5;

    private Date fmulticheckdate6;

    private Integer fcurchecklevel;

    private Integer ftaskid;

    private Integer fresourceid;

    private Boolean fbackflushed;

    private Integer fwbinterid;

    private Integer ftranstatus;

    private Integer fzpbillinterid;

    private Integer frelatebrid;

    private Integer fpurposeid;

    private String fuuid;

    private Integer frelateinvoiceid;

    private Integer fimport;

    private Integer fsystemtype;

    private Integer fmarketingstyle;

    private Integer fpaybillid;

    private Date fcheckdate;

    private String fexplanation;

    private String ffetchadd;

    private Date ffetchdate;

    private Integer fmanagerid;

    private Integer freftype;

    private Integer fseltrantype;

    private Integer fchildren;

    private Short fhookstatus;

    private Integer factpricevchtplid;

    private Integer fplanpricevchtplid;

    private Integer fprocid;

    private Integer factualvchtplid;

    private Integer fplanvchtplid;

    private Integer fbrid;

    private Integer fvipcardid;

    private BigDecimal fvipscore;

    private BigDecimal fholisticdiscountrate;

    private String fposname;

    private Integer fworkshiftid;

    private Integer fcussentacctid;

    private Boolean fzangucount;

    private Integer fcustid;

    private Integer fmoitemid;

    private Integer fmounitid;

    private BigDecimal fmoauxqty;

    private Integer fmobaseunitid;

    private BigDecimal fmoqty;

    private String fbatchno;

    private String fmcustitemno;

    private String fmcustitemname;

    private String freceiveaddr;

    private String fbillsource;

    private Integer frejected;

    private String frejectednote;

    private Date frejectedtime;

    private String fwlnumber;

    private String fwlcompany;

    private byte[] foperdate;

    public Integer getFinterid() {
        return finterid;
    }

    public void setFinterid(Integer finterid) {
        this.finterid = finterid;
    }

    public String getFbrno() {
        return fbrno;
    }

    public void setFbrno(String fbrno) {
        this.fbrno = fbrno == null ? null : fbrno.trim();
    }

    public Short getFtrantype() {
        return ftrantype;
    }

    public void setFtrantype(Short ftrantype) {
        this.ftrantype = ftrantype;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public String getFbillno() {
        return fbillno;
    }

    public void setFbillno(String fbillno) {
        this.fbillno = fbillno == null ? null : fbillno.trim();
    }

    public String getFuse() {
        return fuse;
    }

    public void setFuse(String fuse) {
        this.fuse = fuse == null ? null : fuse.trim();
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Integer getFdcstockid() {
        return fdcstockid;
    }

    public void setFdcstockid(Integer fdcstockid) {
        this.fdcstockid = fdcstockid;
    }

    public Integer getFscstockid() {
        return fscstockid;
    }

    public void setFscstockid(Integer fscstockid) {
        this.fscstockid = fscstockid;
    }

    public Integer getFdeptid() {
        return fdeptid;
    }

    public void setFdeptid(Integer fdeptid) {
        this.fdeptid = fdeptid;
    }

    public Integer getFempid() {
        return fempid;
    }

    public void setFempid(Integer fempid) {
        this.fempid = fempid;
    }

    public Integer getFsupplyid() {
        return fsupplyid;
    }

    public void setFsupplyid(Integer fsupplyid) {
        this.fsupplyid = fsupplyid;
    }

    public Integer getFposterid() {
        return fposterid;
    }

    public void setFposterid(Integer fposterid) {
        this.fposterid = fposterid;
    }

    public Integer getFcheckerid() {
        return fcheckerid;
    }

    public void setFcheckerid(Integer fcheckerid) {
        this.fcheckerid = fcheckerid;
    }

    public Integer getFfmanagerid() {
        return ffmanagerid;
    }

    public void setFfmanagerid(Integer ffmanagerid) {
        this.ffmanagerid = ffmanagerid;
    }

    public Integer getFsmanagerid() {
        return fsmanagerid;
    }

    public void setFsmanagerid(Integer fsmanagerid) {
        this.fsmanagerid = fsmanagerid;
    }

    public Integer getFbillerid() {
        return fbillerid;
    }

    public void setFbillerid(Integer fbillerid) {
        this.fbillerid = fbillerid;
    }

    public Integer getFreturnbillinterid() {
        return freturnbillinterid;
    }

    public void setFreturnbillinterid(Integer freturnbillinterid) {
        this.freturnbillinterid = freturnbillinterid;
    }

    public String getFscbillno() {
        return fscbillno;
    }

    public void setFscbillno(String fscbillno) {
        this.fscbillno = fscbillno == null ? null : fscbillno.trim();
    }

    public Integer getFhookinterid() {
        return fhookinterid;
    }

    public void setFhookinterid(Integer fhookinterid) {
        this.fhookinterid = fhookinterid;
    }

    public Integer getFvchinterid() {
        return fvchinterid;
    }

    public void setFvchinterid(Integer fvchinterid) {
        this.fvchinterid = fvchinterid;
    }

    public Short getFposted() {
        return fposted;
    }

    public void setFposted(Short fposted) {
        this.fposted = fposted;
    }

    public Short getFcheckselect() {
        return fcheckselect;
    }

    public void setFcheckselect(Short fcheckselect) {
        this.fcheckselect = fcheckselect;
    }

    public Integer getFcurrencyid() {
        return fcurrencyid;
    }

    public void setFcurrencyid(Integer fcurrencyid) {
        this.fcurrencyid = fcurrencyid;
    }

    public Integer getFsalestyle() {
        return fsalestyle;
    }

    public void setFsalestyle(Integer fsalestyle) {
        this.fsalestyle = fsalestyle;
    }

    public Integer getFacctid() {
        return facctid;
    }

    public void setFacctid(Integer facctid) {
        this.facctid = facctid;
    }

    public Short getFrob() {
        return frob;
    }

    public void setFrob(Short frob) {
        this.frob = frob;
    }

    public String getFrscbillno() {
        return frscbillno;
    }

    public void setFrscbillno(String frscbillno) {
        this.frscbillno = frscbillno == null ? null : frscbillno.trim();
    }

    public Short getFstatus() {
        return fstatus;
    }

    public void setFstatus(Short fstatus) {
        this.fstatus = fstatus;
    }

    public Boolean getFupstockwhensave() {
        return fupstockwhensave;
    }

    public void setFupstockwhensave(Boolean fupstockwhensave) {
        this.fupstockwhensave = fupstockwhensave;
    }

    public Boolean getFcancellation() {
        return fcancellation;
    }

    public void setFcancellation(Boolean fcancellation) {
        this.fcancellation = fcancellation;
    }

    public Integer getForgbillinterid() {
        return forgbillinterid;
    }

    public void setForgbillinterid(Integer forgbillinterid) {
        this.forgbillinterid = forgbillinterid;
    }

    public Integer getFbilltypeid() {
        return fbilltypeid;
    }

    public void setFbilltypeid(Integer fbilltypeid) {
        this.fbilltypeid = fbilltypeid;
    }

    public Integer getFpostyle() {
        return fpostyle;
    }

    public void setFpostyle(Integer fpostyle) {
        this.fpostyle = fpostyle;
    }

    public Integer getFmultichecklevel1() {
        return fmultichecklevel1;
    }

    public void setFmultichecklevel1(Integer fmultichecklevel1) {
        this.fmultichecklevel1 = fmultichecklevel1;
    }

    public Integer getFmultichecklevel2() {
        return fmultichecklevel2;
    }

    public void setFmultichecklevel2(Integer fmultichecklevel2) {
        this.fmultichecklevel2 = fmultichecklevel2;
    }

    public Integer getFmultichecklevel3() {
        return fmultichecklevel3;
    }

    public void setFmultichecklevel3(Integer fmultichecklevel3) {
        this.fmultichecklevel3 = fmultichecklevel3;
    }

    public Integer getFmultichecklevel4() {
        return fmultichecklevel4;
    }

    public void setFmultichecklevel4(Integer fmultichecklevel4) {
        this.fmultichecklevel4 = fmultichecklevel4;
    }

    public Integer getFmultichecklevel5() {
        return fmultichecklevel5;
    }

    public void setFmultichecklevel5(Integer fmultichecklevel5) {
        this.fmultichecklevel5 = fmultichecklevel5;
    }

    public Integer getFmultichecklevel6() {
        return fmultichecklevel6;
    }

    public void setFmultichecklevel6(Integer fmultichecklevel6) {
        this.fmultichecklevel6 = fmultichecklevel6;
    }

    public Date getFmulticheckdate1() {
        return fmulticheckdate1;
    }

    public void setFmulticheckdate1(Date fmulticheckdate1) {
        this.fmulticheckdate1 = fmulticheckdate1;
    }

    public Date getFmulticheckdate2() {
        return fmulticheckdate2;
    }

    public void setFmulticheckdate2(Date fmulticheckdate2) {
        this.fmulticheckdate2 = fmulticheckdate2;
    }

    public Date getFmulticheckdate3() {
        return fmulticheckdate3;
    }

    public void setFmulticheckdate3(Date fmulticheckdate3) {
        this.fmulticheckdate3 = fmulticheckdate3;
    }

    public Date getFmulticheckdate4() {
        return fmulticheckdate4;
    }

    public void setFmulticheckdate4(Date fmulticheckdate4) {
        this.fmulticheckdate4 = fmulticheckdate4;
    }

    public Date getFmulticheckdate5() {
        return fmulticheckdate5;
    }

    public void setFmulticheckdate5(Date fmulticheckdate5) {
        this.fmulticheckdate5 = fmulticheckdate5;
    }

    public Date getFmulticheckdate6() {
        return fmulticheckdate6;
    }

    public void setFmulticheckdate6(Date fmulticheckdate6) {
        this.fmulticheckdate6 = fmulticheckdate6;
    }

    public Integer getFcurchecklevel() {
        return fcurchecklevel;
    }

    public void setFcurchecklevel(Integer fcurchecklevel) {
        this.fcurchecklevel = fcurchecklevel;
    }

    public Integer getFtaskid() {
        return ftaskid;
    }

    public void setFtaskid(Integer ftaskid) {
        this.ftaskid = ftaskid;
    }

    public Integer getFresourceid() {
        return fresourceid;
    }

    public void setFresourceid(Integer fresourceid) {
        this.fresourceid = fresourceid;
    }

    public Boolean getFbackflushed() {
        return fbackflushed;
    }

    public void setFbackflushed(Boolean fbackflushed) {
        this.fbackflushed = fbackflushed;
    }

    public Integer getFwbinterid() {
        return fwbinterid;
    }

    public void setFwbinterid(Integer fwbinterid) {
        this.fwbinterid = fwbinterid;
    }

    public Integer getFtranstatus() {
        return ftranstatus;
    }

    public void setFtranstatus(Integer ftranstatus) {
        this.ftranstatus = ftranstatus;
    }

    public Integer getFzpbillinterid() {
        return fzpbillinterid;
    }

    public void setFzpbillinterid(Integer fzpbillinterid) {
        this.fzpbillinterid = fzpbillinterid;
    }

    public Integer getFrelatebrid() {
        return frelatebrid;
    }

    public void setFrelatebrid(Integer frelatebrid) {
        this.frelatebrid = frelatebrid;
    }

    public Integer getFpurposeid() {
        return fpurposeid;
    }

    public void setFpurposeid(Integer fpurposeid) {
        this.fpurposeid = fpurposeid;
    }

    public String getFuuid() {
        return fuuid;
    }

    public void setFuuid(String fuuid) {
        this.fuuid = fuuid == null ? null : fuuid.trim();
    }

    public Integer getFrelateinvoiceid() {
        return frelateinvoiceid;
    }

    public void setFrelateinvoiceid(Integer frelateinvoiceid) {
        this.frelateinvoiceid = frelateinvoiceid;
    }

    public Integer getFimport() {
        return fimport;
    }

    public void setFimport(Integer fimport) {
        this.fimport = fimport;
    }

    public Integer getFsystemtype() {
        return fsystemtype;
    }

    public void setFsystemtype(Integer fsystemtype) {
        this.fsystemtype = fsystemtype;
    }

    public Integer getFmarketingstyle() {
        return fmarketingstyle;
    }

    public void setFmarketingstyle(Integer fmarketingstyle) {
        this.fmarketingstyle = fmarketingstyle;
    }

    public Integer getFpaybillid() {
        return fpaybillid;
    }

    public void setFpaybillid(Integer fpaybillid) {
        this.fpaybillid = fpaybillid;
    }

    public Date getFcheckdate() {
        return fcheckdate;
    }

    public void setFcheckdate(Date fcheckdate) {
        this.fcheckdate = fcheckdate;
    }

    public String getFexplanation() {
        return fexplanation;
    }

    public void setFexplanation(String fexplanation) {
        this.fexplanation = fexplanation == null ? null : fexplanation.trim();
    }

    public String getFfetchadd() {
        return ffetchadd;
    }

    public void setFfetchadd(String ffetchadd) {
        this.ffetchadd = ffetchadd == null ? null : ffetchadd.trim();
    }

    public Date getFfetchdate() {
        return ffetchdate;
    }

    public void setFfetchdate(Date ffetchdate) {
        this.ffetchdate = ffetchdate;
    }

    public Integer getFmanagerid() {
        return fmanagerid;
    }

    public void setFmanagerid(Integer fmanagerid) {
        this.fmanagerid = fmanagerid;
    }

    public Integer getFreftype() {
        return freftype;
    }

    public void setFreftype(Integer freftype) {
        this.freftype = freftype;
    }

    public Integer getFseltrantype() {
        return fseltrantype;
    }

    public void setFseltrantype(Integer fseltrantype) {
        this.fseltrantype = fseltrantype;
    }

    public Integer getFchildren() {
        return fchildren;
    }

    public void setFchildren(Integer fchildren) {
        this.fchildren = fchildren;
    }

    public Short getFhookstatus() {
        return fhookstatus;
    }

    public void setFhookstatus(Short fhookstatus) {
        this.fhookstatus = fhookstatus;
    }

    public Integer getFactpricevchtplid() {
        return factpricevchtplid;
    }

    public void setFactpricevchtplid(Integer factpricevchtplid) {
        this.factpricevchtplid = factpricevchtplid;
    }

    public Integer getFplanpricevchtplid() {
        return fplanpricevchtplid;
    }

    public void setFplanpricevchtplid(Integer fplanpricevchtplid) {
        this.fplanpricevchtplid = fplanpricevchtplid;
    }

    public Integer getFprocid() {
        return fprocid;
    }

    public void setFprocid(Integer fprocid) {
        this.fprocid = fprocid;
    }

    public Integer getFactualvchtplid() {
        return factualvchtplid;
    }

    public void setFactualvchtplid(Integer factualvchtplid) {
        this.factualvchtplid = factualvchtplid;
    }

    public Integer getFplanvchtplid() {
        return fplanvchtplid;
    }

    public void setFplanvchtplid(Integer fplanvchtplid) {
        this.fplanvchtplid = fplanvchtplid;
    }

    public Integer getFbrid() {
        return fbrid;
    }

    public void setFbrid(Integer fbrid) {
        this.fbrid = fbrid;
    }

    public Integer getFvipcardid() {
        return fvipcardid;
    }

    public void setFvipcardid(Integer fvipcardid) {
        this.fvipcardid = fvipcardid;
    }

    public BigDecimal getFvipscore() {
        return fvipscore;
    }

    public void setFvipscore(BigDecimal fvipscore) {
        this.fvipscore = fvipscore;
    }

    public BigDecimal getFholisticdiscountrate() {
        return fholisticdiscountrate;
    }

    public void setFholisticdiscountrate(BigDecimal fholisticdiscountrate) {
        this.fholisticdiscountrate = fholisticdiscountrate;
    }

    public String getFposname() {
        return fposname;
    }

    public void setFposname(String fposname) {
        this.fposname = fposname == null ? null : fposname.trim();
    }

    public Integer getFworkshiftid() {
        return fworkshiftid;
    }

    public void setFworkshiftid(Integer fworkshiftid) {
        this.fworkshiftid = fworkshiftid;
    }

    public Integer getFcussentacctid() {
        return fcussentacctid;
    }

    public void setFcussentacctid(Integer fcussentacctid) {
        this.fcussentacctid = fcussentacctid;
    }

    public Boolean getFzangucount() {
        return fzangucount;
    }

    public void setFzangucount(Boolean fzangucount) {
        this.fzangucount = fzangucount;
    }

    public Integer getFcustid() {
        return fcustid;
    }

    public void setFcustid(Integer fcustid) {
        this.fcustid = fcustid;
    }

    public Integer getFmoitemid() {
        return fmoitemid;
    }

    public void setFmoitemid(Integer fmoitemid) {
        this.fmoitemid = fmoitemid;
    }

    public Integer getFmounitid() {
        return fmounitid;
    }

    public void setFmounitid(Integer fmounitid) {
        this.fmounitid = fmounitid;
    }

    public BigDecimal getFmoauxqty() {
        return fmoauxqty;
    }

    public void setFmoauxqty(BigDecimal fmoauxqty) {
        this.fmoauxqty = fmoauxqty;
    }

    public Integer getFmobaseunitid() {
        return fmobaseunitid;
    }

    public void setFmobaseunitid(Integer fmobaseunitid) {
        this.fmobaseunitid = fmobaseunitid;
    }

    public BigDecimal getFmoqty() {
        return fmoqty;
    }

    public void setFmoqty(BigDecimal fmoqty) {
        this.fmoqty = fmoqty;
    }

    public String getFbatchno() {
        return fbatchno;
    }

    public void setFbatchno(String fbatchno) {
        this.fbatchno = fbatchno == null ? null : fbatchno.trim();
    }

    public String getFmcustitemno() {
        return fmcustitemno;
    }

    public void setFmcustitemno(String fmcustitemno) {
        this.fmcustitemno = fmcustitemno == null ? null : fmcustitemno.trim();
    }

    public String getFmcustitemname() {
        return fmcustitemname;
    }

    public void setFmcustitemname(String fmcustitemname) {
        this.fmcustitemname = fmcustitemname == null ? null : fmcustitemname.trim();
    }

    public String getFreceiveaddr() {
        return freceiveaddr;
    }

    public void setFreceiveaddr(String freceiveaddr) {
        this.freceiveaddr = freceiveaddr == null ? null : freceiveaddr.trim();
    }

    public String getFbillsource() {
        return fbillsource;
    }

    public void setFbillsource(String fbillsource) {
        this.fbillsource = fbillsource == null ? null : fbillsource.trim();
    }

    public Integer getFrejected() {
        return frejected;
    }

    public void setFrejected(Integer frejected) {
        this.frejected = frejected;
    }

    public String getFrejectednote() {
        return frejectednote;
    }

    public void setFrejectednote(String frejectednote) {
        this.frejectednote = frejectednote == null ? null : frejectednote.trim();
    }

    public Date getFrejectedtime() {
        return frejectedtime;
    }

    public void setFrejectedtime(Date frejectedtime) {
        this.frejectedtime = frejectedtime;
    }

    public String getFwlnumber() {
        return fwlnumber;
    }

    public void setFwlnumber(String fwlnumber) {
        this.fwlnumber = fwlnumber == null ? null : fwlnumber.trim();
    }

    public String getFwlcompany() {
        return fwlcompany;
    }

    public void setFwlcompany(String fwlcompany) {
        this.fwlcompany = fwlcompany == null ? null : fwlcompany.trim();
    }

    public byte[] getFoperdate() {
        return foperdate;
    }

    public void setFoperdate(byte[] foperdate) {
        this.foperdate = foperdate;
    }
}