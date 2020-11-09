package cn.com.yhb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ICStockBillEntry extends ICStockBillEntryKey {
    private String fbrno;

    private Integer fitemid;

    private BigDecimal fqtymust;

    private BigDecimal fqty;

    private BigDecimal fprice;

    private String fbatchno;

    private BigDecimal famount;

    private String fnote;

    private Integer fscbillinterid;

    private String fscbillno;

    private Integer funitid;

    private BigDecimal fauxprice;

    private BigDecimal fauxqty;

    private BigDecimal fauxqtymust;

    private BigDecimal fqtyactual;

    private BigDecimal fauxqtyactual;

    private BigDecimal fplanprice;

    private BigDecimal fauxplanprice;

    private Integer fsourceentryid;

    private BigDecimal fcommitqty;

    private BigDecimal fauxcommitqty;

    private Date fkfdate;

    private Integer fkfperiod;

    private Integer fdcspid;

    private Integer fscspid;

    private BigDecimal fconsignprice;

    private BigDecimal fconsignamount;

    private BigDecimal fprocesscost;

    private BigDecimal fmaterialcost;

    private BigDecimal ftaxamount;

    private String fmapnumber;

    private String fmapname;

    private Integer forgbillentryid;

    private Integer foperid;

    private BigDecimal fplanamount;

    private BigDecimal fprocessprice;

    private BigDecimal ftaxrate;

    private Integer fsnlistid;

    private BigDecimal famtref;

    private Integer fauxpropid;

    private BigDecimal fcost;

    private BigDecimal fpriceref;

    private BigDecimal fauxpriceref;

    private Date ffetchdate;

    private BigDecimal fqtyinvoice;

    private BigDecimal fqtyinvoicebase;

    private BigDecimal funitcost;

    private BigDecimal fseccoefficient;

    private BigDecimal fsecqty;

    private BigDecimal fseccommitqty;

    private Integer fsourcetrantype;

    private Integer fsourceinterid;

    private String fsourcebillno;

    private Integer fcontractinterid;

    private Integer fcontractentryid;

    private String fcontractbillno;

    private String ficmobillno;

    private Integer ficmointerid;

    private Integer fppbomentryid;

    private Integer forderinterid;

    private Integer forderentryid;

    private String forderbillno;

    private BigDecimal fallhookqty;

    private BigDecimal fallhookamount;

    private BigDecimal fcurrenthookqty;

    private BigDecimal fcurrenthookamount;

    private BigDecimal fstdallhookamount;

    private BigDecimal fstdcurrenthookamount;

    private Integer fscstockid;

    private Integer fdcstockid;

    private Date fperioddate;

    private Integer fcostobjgroupid;

    private Integer fcostobjid;

    private Integer fdetailid;

    private BigDecimal fmaterialcostprice;

    private Integer freproducetype;

    private Integer fbominterid;

    private BigDecimal fdiscountrate;

    private BigDecimal fdiscountamount;

    private Integer fsepcialsaleid;

    private BigDecimal foutcommitqty;

    private BigDecimal foutseccommitqty;

    private BigDecimal fdbcommitqty;

    private BigDecimal fdbseccommitqty;

    private BigDecimal fauxqtyinvoice;

    private Integer fopersn;

    private Short fcheckstatus;

    private BigDecimal fsplitsecqty;

    private Integer fdvstockid;

    private Integer fhookinterid;

    private Short fhookstatus;

    private String fafbillno;

    private Integer fmointerid;

    private Integer fmoentryid;

    private String fmobillno;

    private String fcustitemno;

    private String fcustitemname;

    private Integer findex;

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

    public BigDecimal getFqtymust() {
        return fqtymust;
    }

    public void setFqtymust(BigDecimal fqtymust) {
        this.fqtymust = fqtymust;
    }

    public BigDecimal getFqty() {
        return fqty;
    }

    public void setFqty(BigDecimal fqty) {
        this.fqty = fqty;
    }

    public BigDecimal getFprice() {
        return fprice;
    }

    public void setFprice(BigDecimal fprice) {
        this.fprice = fprice;
    }

    public String getFbatchno() {
        return fbatchno;
    }

    public void setFbatchno(String fbatchno) {
        this.fbatchno = fbatchno == null ? null : fbatchno.trim();
    }

    public BigDecimal getFamount() {
        return famount;
    }

    public void setFamount(BigDecimal famount) {
        this.famount = famount;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Integer getFscbillinterid() {
        return fscbillinterid;
    }

    public void setFscbillinterid(Integer fscbillinterid) {
        this.fscbillinterid = fscbillinterid;
    }

    public String getFscbillno() {
        return fscbillno;
    }

    public void setFscbillno(String fscbillno) {
        this.fscbillno = fscbillno == null ? null : fscbillno.trim();
    }

    public Integer getFunitid() {
        return funitid;
    }

    public void setFunitid(Integer funitid) {
        this.funitid = funitid;
    }

    public BigDecimal getFauxprice() {
        return fauxprice;
    }

    public void setFauxprice(BigDecimal fauxprice) {
        this.fauxprice = fauxprice;
    }

    public BigDecimal getFauxqty() {
        return fauxqty;
    }

    public void setFauxqty(BigDecimal fauxqty) {
        this.fauxqty = fauxqty;
    }

    public BigDecimal getFauxqtymust() {
        return fauxqtymust;
    }

    public void setFauxqtymust(BigDecimal fauxqtymust) {
        this.fauxqtymust = fauxqtymust;
    }

    public BigDecimal getFqtyactual() {
        return fqtyactual;
    }

    public void setFqtyactual(BigDecimal fqtyactual) {
        this.fqtyactual = fqtyactual;
    }

    public BigDecimal getFauxqtyactual() {
        return fauxqtyactual;
    }

    public void setFauxqtyactual(BigDecimal fauxqtyactual) {
        this.fauxqtyactual = fauxqtyactual;
    }

    public BigDecimal getFplanprice() {
        return fplanprice;
    }

    public void setFplanprice(BigDecimal fplanprice) {
        this.fplanprice = fplanprice;
    }

    public BigDecimal getFauxplanprice() {
        return fauxplanprice;
    }

    public void setFauxplanprice(BigDecimal fauxplanprice) {
        this.fauxplanprice = fauxplanprice;
    }

    public Integer getFsourceentryid() {
        return fsourceentryid;
    }

    public void setFsourceentryid(Integer fsourceentryid) {
        this.fsourceentryid = fsourceentryid;
    }

    public BigDecimal getFcommitqty() {
        return fcommitqty;
    }

    public void setFcommitqty(BigDecimal fcommitqty) {
        this.fcommitqty = fcommitqty;
    }

    public BigDecimal getFauxcommitqty() {
        return fauxcommitqty;
    }

    public void setFauxcommitqty(BigDecimal fauxcommitqty) {
        this.fauxcommitqty = fauxcommitqty;
    }

    public Date getFkfdate() {
        return fkfdate;
    }

    public void setFkfdate(Date fkfdate) {
        this.fkfdate = fkfdate;
    }

    public Integer getFkfperiod() {
        return fkfperiod;
    }

    public void setFkfperiod(Integer fkfperiod) {
        this.fkfperiod = fkfperiod;
    }

    public Integer getFdcspid() {
        return fdcspid;
    }

    public void setFdcspid(Integer fdcspid) {
        this.fdcspid = fdcspid;
    }

    public Integer getFscspid() {
        return fscspid;
    }

    public void setFscspid(Integer fscspid) {
        this.fscspid = fscspid;
    }

    public BigDecimal getFconsignprice() {
        return fconsignprice;
    }

    public void setFconsignprice(BigDecimal fconsignprice) {
        this.fconsignprice = fconsignprice;
    }

    public BigDecimal getFconsignamount() {
        return fconsignamount;
    }

    public void setFconsignamount(BigDecimal fconsignamount) {
        this.fconsignamount = fconsignamount;
    }

    public BigDecimal getFprocesscost() {
        return fprocesscost;
    }

    public void setFprocesscost(BigDecimal fprocesscost) {
        this.fprocesscost = fprocesscost;
    }

    public BigDecimal getFmaterialcost() {
        return fmaterialcost;
    }

    public void setFmaterialcost(BigDecimal fmaterialcost) {
        this.fmaterialcost = fmaterialcost;
    }

    public BigDecimal getFtaxamount() {
        return ftaxamount;
    }

    public void setFtaxamount(BigDecimal ftaxamount) {
        this.ftaxamount = ftaxamount;
    }

    public String getFmapnumber() {
        return fmapnumber;
    }

    public void setFmapnumber(String fmapnumber) {
        this.fmapnumber = fmapnumber == null ? null : fmapnumber.trim();
    }

    public String getFmapname() {
        return fmapname;
    }

    public void setFmapname(String fmapname) {
        this.fmapname = fmapname == null ? null : fmapname.trim();
    }

    public Integer getForgbillentryid() {
        return forgbillentryid;
    }

    public void setForgbillentryid(Integer forgbillentryid) {
        this.forgbillentryid = forgbillentryid;
    }

    public Integer getFoperid() {
        return foperid;
    }

    public void setFoperid(Integer foperid) {
        this.foperid = foperid;
    }

    public BigDecimal getFplanamount() {
        return fplanamount;
    }

    public void setFplanamount(BigDecimal fplanamount) {
        this.fplanamount = fplanamount;
    }

    public BigDecimal getFprocessprice() {
        return fprocessprice;
    }

    public void setFprocessprice(BigDecimal fprocessprice) {
        this.fprocessprice = fprocessprice;
    }

    public BigDecimal getFtaxrate() {
        return ftaxrate;
    }

    public void setFtaxrate(BigDecimal ftaxrate) {
        this.ftaxrate = ftaxrate;
    }

    public Integer getFsnlistid() {
        return fsnlistid;
    }

    public void setFsnlistid(Integer fsnlistid) {
        this.fsnlistid = fsnlistid;
    }

    public BigDecimal getFamtref() {
        return famtref;
    }

    public void setFamtref(BigDecimal famtref) {
        this.famtref = famtref;
    }

    public Integer getFauxpropid() {
        return fauxpropid;
    }

    public void setFauxpropid(Integer fauxpropid) {
        this.fauxpropid = fauxpropid;
    }

    public BigDecimal getFcost() {
        return fcost;
    }

    public void setFcost(BigDecimal fcost) {
        this.fcost = fcost;
    }

    public BigDecimal getFpriceref() {
        return fpriceref;
    }

    public void setFpriceref(BigDecimal fpriceref) {
        this.fpriceref = fpriceref;
    }

    public BigDecimal getFauxpriceref() {
        return fauxpriceref;
    }

    public void setFauxpriceref(BigDecimal fauxpriceref) {
        this.fauxpriceref = fauxpriceref;
    }

    public Date getFfetchdate() {
        return ffetchdate;
    }

    public void setFfetchdate(Date ffetchdate) {
        this.ffetchdate = ffetchdate;
    }

    public BigDecimal getFqtyinvoice() {
        return fqtyinvoice;
    }

    public void setFqtyinvoice(BigDecimal fqtyinvoice) {
        this.fqtyinvoice = fqtyinvoice;
    }

    public BigDecimal getFqtyinvoicebase() {
        return fqtyinvoicebase;
    }

    public void setFqtyinvoicebase(BigDecimal fqtyinvoicebase) {
        this.fqtyinvoicebase = fqtyinvoicebase;
    }

    public BigDecimal getFunitcost() {
        return funitcost;
    }

    public void setFunitcost(BigDecimal funitcost) {
        this.funitcost = funitcost;
    }

    public BigDecimal getFseccoefficient() {
        return fseccoefficient;
    }

    public void setFseccoefficient(BigDecimal fseccoefficient) {
        this.fseccoefficient = fseccoefficient;
    }

    public BigDecimal getFsecqty() {
        return fsecqty;
    }

    public void setFsecqty(BigDecimal fsecqty) {
        this.fsecqty = fsecqty;
    }

    public BigDecimal getFseccommitqty() {
        return fseccommitqty;
    }

    public void setFseccommitqty(BigDecimal fseccommitqty) {
        this.fseccommitqty = fseccommitqty;
    }

    public Integer getFsourcetrantype() {
        return fsourcetrantype;
    }

    public void setFsourcetrantype(Integer fsourcetrantype) {
        this.fsourcetrantype = fsourcetrantype;
    }

    public Integer getFsourceinterid() {
        return fsourceinterid;
    }

    public void setFsourceinterid(Integer fsourceinterid) {
        this.fsourceinterid = fsourceinterid;
    }

    public String getFsourcebillno() {
        return fsourcebillno;
    }

    public void setFsourcebillno(String fsourcebillno) {
        this.fsourcebillno = fsourcebillno == null ? null : fsourcebillno.trim();
    }

    public Integer getFcontractinterid() {
        return fcontractinterid;
    }

    public void setFcontractinterid(Integer fcontractinterid) {
        this.fcontractinterid = fcontractinterid;
    }

    public Integer getFcontractentryid() {
        return fcontractentryid;
    }

    public void setFcontractentryid(Integer fcontractentryid) {
        this.fcontractentryid = fcontractentryid;
    }

    public String getFcontractbillno() {
        return fcontractbillno;
    }

    public void setFcontractbillno(String fcontractbillno) {
        this.fcontractbillno = fcontractbillno == null ? null : fcontractbillno.trim();
    }

    public String getFicmobillno() {
        return ficmobillno;
    }

    public void setFicmobillno(String ficmobillno) {
        this.ficmobillno = ficmobillno == null ? null : ficmobillno.trim();
    }

    public Integer getFicmointerid() {
        return ficmointerid;
    }

    public void setFicmointerid(Integer ficmointerid) {
        this.ficmointerid = ficmointerid;
    }

    public Integer getFppbomentryid() {
        return fppbomentryid;
    }

    public void setFppbomentryid(Integer fppbomentryid) {
        this.fppbomentryid = fppbomentryid;
    }

    public Integer getForderinterid() {
        return forderinterid;
    }

    public void setForderinterid(Integer forderinterid) {
        this.forderinterid = forderinterid;
    }

    public Integer getForderentryid() {
        return forderentryid;
    }

    public void setForderentryid(Integer forderentryid) {
        this.forderentryid = forderentryid;
    }

    public String getForderbillno() {
        return forderbillno;
    }

    public void setForderbillno(String forderbillno) {
        this.forderbillno = forderbillno == null ? null : forderbillno.trim();
    }

    public BigDecimal getFallhookqty() {
        return fallhookqty;
    }

    public void setFallhookqty(BigDecimal fallhookqty) {
        this.fallhookqty = fallhookqty;
    }

    public BigDecimal getFallhookamount() {
        return fallhookamount;
    }

    public void setFallhookamount(BigDecimal fallhookamount) {
        this.fallhookamount = fallhookamount;
    }

    public BigDecimal getFcurrenthookqty() {
        return fcurrenthookqty;
    }

    public void setFcurrenthookqty(BigDecimal fcurrenthookqty) {
        this.fcurrenthookqty = fcurrenthookqty;
    }

    public BigDecimal getFcurrenthookamount() {
        return fcurrenthookamount;
    }

    public void setFcurrenthookamount(BigDecimal fcurrenthookamount) {
        this.fcurrenthookamount = fcurrenthookamount;
    }

    public BigDecimal getFstdallhookamount() {
        return fstdallhookamount;
    }

    public void setFstdallhookamount(BigDecimal fstdallhookamount) {
        this.fstdallhookamount = fstdallhookamount;
    }

    public BigDecimal getFstdcurrenthookamount() {
        return fstdcurrenthookamount;
    }

    public void setFstdcurrenthookamount(BigDecimal fstdcurrenthookamount) {
        this.fstdcurrenthookamount = fstdcurrenthookamount;
    }

    public Integer getFscstockid() {
        return fscstockid;
    }

    public void setFscstockid(Integer fscstockid) {
        this.fscstockid = fscstockid;
    }

    public Integer getFdcstockid() {
        return fdcstockid;
    }

    public void setFdcstockid(Integer fdcstockid) {
        this.fdcstockid = fdcstockid;
    }

    public Date getFperioddate() {
        return fperioddate;
    }

    public void setFperioddate(Date fperioddate) {
        this.fperioddate = fperioddate;
    }

    public Integer getFcostobjgroupid() {
        return fcostobjgroupid;
    }

    public void setFcostobjgroupid(Integer fcostobjgroupid) {
        this.fcostobjgroupid = fcostobjgroupid;
    }

    public Integer getFcostobjid() {
        return fcostobjid;
    }

    public void setFcostobjid(Integer fcostobjid) {
        this.fcostobjid = fcostobjid;
    }

    public Integer getFdetailid() {
        return fdetailid;
    }

    public void setFdetailid(Integer fdetailid) {
        this.fdetailid = fdetailid;
    }

    public BigDecimal getFmaterialcostprice() {
        return fmaterialcostprice;
    }

    public void setFmaterialcostprice(BigDecimal fmaterialcostprice) {
        this.fmaterialcostprice = fmaterialcostprice;
    }

    public Integer getFreproducetype() {
        return freproducetype;
    }

    public void setFreproducetype(Integer freproducetype) {
        this.freproducetype = freproducetype;
    }

    public Integer getFbominterid() {
        return fbominterid;
    }

    public void setFbominterid(Integer fbominterid) {
        this.fbominterid = fbominterid;
    }

    public BigDecimal getFdiscountrate() {
        return fdiscountrate;
    }

    public void setFdiscountrate(BigDecimal fdiscountrate) {
        this.fdiscountrate = fdiscountrate;
    }

    public BigDecimal getFdiscountamount() {
        return fdiscountamount;
    }

    public void setFdiscountamount(BigDecimal fdiscountamount) {
        this.fdiscountamount = fdiscountamount;
    }

    public Integer getFsepcialsaleid() {
        return fsepcialsaleid;
    }

    public void setFsepcialsaleid(Integer fsepcialsaleid) {
        this.fsepcialsaleid = fsepcialsaleid;
    }

    public BigDecimal getFoutcommitqty() {
        return foutcommitqty;
    }

    public void setFoutcommitqty(BigDecimal foutcommitqty) {
        this.foutcommitqty = foutcommitqty;
    }

    public BigDecimal getFoutseccommitqty() {
        return foutseccommitqty;
    }

    public void setFoutseccommitqty(BigDecimal foutseccommitqty) {
        this.foutseccommitqty = foutseccommitqty;
    }

    public BigDecimal getFdbcommitqty() {
        return fdbcommitqty;
    }

    public void setFdbcommitqty(BigDecimal fdbcommitqty) {
        this.fdbcommitqty = fdbcommitqty;
    }

    public BigDecimal getFdbseccommitqty() {
        return fdbseccommitqty;
    }

    public void setFdbseccommitqty(BigDecimal fdbseccommitqty) {
        this.fdbseccommitqty = fdbseccommitqty;
    }

    public BigDecimal getFauxqtyinvoice() {
        return fauxqtyinvoice;
    }

    public void setFauxqtyinvoice(BigDecimal fauxqtyinvoice) {
        this.fauxqtyinvoice = fauxqtyinvoice;
    }

    public Integer getFopersn() {
        return fopersn;
    }

    public void setFopersn(Integer fopersn) {
        this.fopersn = fopersn;
    }

    public Short getFcheckstatus() {
        return fcheckstatus;
    }

    public void setFcheckstatus(Short fcheckstatus) {
        this.fcheckstatus = fcheckstatus;
    }

    public BigDecimal getFsplitsecqty() {
        return fsplitsecqty;
    }

    public void setFsplitsecqty(BigDecimal fsplitsecqty) {
        this.fsplitsecqty = fsplitsecqty;
    }

    public Integer getFdvstockid() {
        return fdvstockid;
    }

    public void setFdvstockid(Integer fdvstockid) {
        this.fdvstockid = fdvstockid;
    }

    public Integer getFhookinterid() {
        return fhookinterid;
    }

    public void setFhookinterid(Integer fhookinterid) {
        this.fhookinterid = fhookinterid;
    }

    public Short getFhookstatus() {
        return fhookstatus;
    }

    public void setFhookstatus(Short fhookstatus) {
        this.fhookstatus = fhookstatus;
    }

    public String getFafbillno() {
        return fafbillno;
    }

    public void setFafbillno(String fafbillno) {
        this.fafbillno = fafbillno == null ? null : fafbillno.trim();
    }

    public Integer getFmointerid() {
        return fmointerid;
    }

    public void setFmointerid(Integer fmointerid) {
        this.fmointerid = fmointerid;
    }

    public Integer getFmoentryid() {
        return fmoentryid;
    }

    public void setFmoentryid(Integer fmoentryid) {
        this.fmoentryid = fmoentryid;
    }

    public String getFmobillno() {
        return fmobillno;
    }

    public void setFmobillno(String fmobillno) {
        this.fmobillno = fmobillno == null ? null : fmobillno.trim();
    }

    public String getFcustitemno() {
        return fcustitemno;
    }

    public void setFcustitemno(String fcustitemno) {
        this.fcustitemno = fcustitemno == null ? null : fcustitemno.trim();
    }

    public String getFcustitemname() {
        return fcustitemname;
    }

    public void setFcustitemname(String fcustitemname) {
        this.fcustitemname = fcustitemname == null ? null : fcustitemname.trim();
    }

    public Integer getFindex() {
        return findex;
    }

    public void setFindex(Integer findex) {
        this.findex = findex;
    }
}