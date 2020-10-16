package cn.com.yhb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class t_ICItem {
    private Integer fitemid;

    private String fname;

    private String fhelpcode;

    private Short fdeleted;

    private String fshortnumber;

    private String fnumber;

    private Integer fparentid;

    private String fbrno;

    private Integer ftopid;

    private Short frp;

    private Short fomortize;

    private Short fomortizescale;

    private Boolean fforsale;

    private Double fstacost;

    private Double forderprice;

    private Integer fordermethod;

    private Integer fpricefixingtype;

    private Integer fsalepricefixingtype;

    private Double fperwastage;

    private Integer faracctid;

    private Short fplanpricemethod;

    private Short fplanclass;

    private String fmodel;

    private String fitemdescription;

    private String falias;

    private String fapproveno;

    private Integer fauxclassid;

    private Integer fdefaultloc;

    private String fequipmentnum;

    private Integer ferpclsid;

    private String ffullname;

    private BigDecimal fhighlimit;

    private Boolean fisequipment;

    private Boolean fissparepart;

    private BigDecimal flowlimit;

    private Integer forderunitid;

    private Integer fpredeadline;

    private Integer fproductunitid;

    private Short fqtydecimal;

    private Integer fsaleunitid;

    private BigDecimal fseccoefficient;

    private Integer fsecunitdecimal;

    private BigDecimal fsecinv;

    private Integer fsecunitid;

    private Integer fserialclassid;

    private Integer fsource;

    private Integer fspid;

    private Integer fstoreunitid;

    private Integer ftypeid;

    private Integer funitgroupid;

    private Integer funitid;

    private Integer fusestate;

    private String fabccls;

    private Integer facctid;

    private Integer fadminacctid;

    private Integer fapacctid;

    private Boolean fbatchmanager;

    private Double fbatchqty;

    private Integer fbeforeexpire;

    private Boolean fbookplan;

    private Integer fcheckcycle;

    private Integer fcheckcycunit;

    private Boolean fclass;

    private Integer fcostacctid;

    private Double fcostdiffrate;

    private Integer fcostproject;

    private Integer fdaysper;

    private Integer fdepartment;

    private Integer fgoodspec;

    private Boolean fiskfperiod;

    private Boolean fissale;

    private Boolean fissnmanage;

    private Boolean fisspecialtax;

    private BigDecimal fkfperiod;

    private Date flastcheckdate;

    private String fnote;

    private BigDecimal foihighlimit;

    private BigDecimal foilowlimit;

    private Integer forderrector;

    private BigDecimal fplanprice;

    private Integer fpohghprcmnytype;

    private BigDecimal fpohighprice;

    private Short fpricedecimal;

    private BigDecimal fprofitrate;

    private Integer fsaleacctid;

    private BigDecimal fsaleprice;

    private Integer fsaletaxacctid;

    private BigDecimal fsohighlimit;

    private BigDecimal fsolowlimit;

    private BigDecimal fsolowprc;

    private Integer fsolowprcmnytype;

    private BigDecimal fstockprice;

    private Boolean fstocktime;

    private Integer ftaxrate;

    private Integer ftrack;

    private BigDecimal fwwhghprc;

    private Integer fwwhghprcmnytype;

    private Integer fcbbmstandardid;

    private BigDecimal fbatchangeeconomy;

    private BigDecimal fbatchappendqty;

    private BigDecimal fbatfixeconomy;

    private Integer fcuunitid;

    private BigDecimal fdailyconsume;

    private Integer fdefaultroutingid;

    private Integer fdefaultworktypeid;

    private Float ffixleadtime;

    private BigDecimal finhighlimit;

    private BigDecimal finlowlimit;

    private Float fleadtime;

    private Integer flowestbomcode;

    private Boolean fmrpcon;

    private Integer forderinterval;

    private BigDecimal forderpoint;

    private Integer fordertrategy;

    private Integer fplanner;

    private Integer fplanpoint;

    private Integer fplantrategy;

    private Integer fproductprincipal;

    private Boolean fputinteger;

    private BigDecimal fqtymax;

    private BigDecimal fqtymin;

    private Integer frequirepoint;

    private Integer ftotaltqq;

    private Boolean fmrporder;

    private Boolean fbatchcreate;

    private String fchartnumber;

    private Integer fcubicmeasure;

    private BigDecimal fgrossweight;

    private BigDecimal fheight;

    private Boolean fiskeyitem;

    private BigDecimal flength;

    private Integer fmaund;

    private BigDecimal fnetweight;

    private BigDecimal fsize;

    private String fversion;

    private BigDecimal fwidth;

    private BigDecimal fchgfeerate;

    private BigDecimal foutmachfee;

    private BigDecimal fpiecerate;

    private BigDecimal fstandardcost;

    private BigDecimal fstandardmanhour;

    private BigDecimal fstdfixfeerate;

    private BigDecimal fstdpayrate;

    private Integer fidentifier;

    private Integer finspectionlevel;

    private Integer finspectionproject;

    private Integer fislistcontrol;

    private Integer fotherchkmde;

    private Integer fprochkmde;

    private Integer fsochkmde;

    private Integer fstkchkalrm;

    private Integer fstkchkmde;

    private Integer fstkchkprd;

    private Integer fwthdrwchkmde;

    private Integer fwwchkmde;

    private byte[] fmodifytime;

    public Integer getFitemid() {
        return fitemid;
    }

    public void setFitemid(Integer fitemid) {
        this.fitemid = fitemid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFhelpcode() {
        return fhelpcode;
    }

    public void setFhelpcode(String fhelpcode) {
        this.fhelpcode = fhelpcode == null ? null : fhelpcode.trim();
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

    public String getFbrno() {
        return fbrno;
    }

    public void setFbrno(String fbrno) {
        this.fbrno = fbrno == null ? null : fbrno.trim();
    }

    public Integer getFtopid() {
        return ftopid;
    }

    public void setFtopid(Integer ftopid) {
        this.ftopid = ftopid;
    }

    public Short getFrp() {
        return frp;
    }

    public void setFrp(Short frp) {
        this.frp = frp;
    }

    public Short getFomortize() {
        return fomortize;
    }

    public void setFomortize(Short fomortize) {
        this.fomortize = fomortize;
    }

    public Short getFomortizescale() {
        return fomortizescale;
    }

    public void setFomortizescale(Short fomortizescale) {
        this.fomortizescale = fomortizescale;
    }

    public Boolean getFforsale() {
        return fforsale;
    }

    public void setFforsale(Boolean fforsale) {
        this.fforsale = fforsale;
    }

    public Double getFstacost() {
        return fstacost;
    }

    public void setFstacost(Double fstacost) {
        this.fstacost = fstacost;
    }

    public Double getForderprice() {
        return forderprice;
    }

    public void setForderprice(Double forderprice) {
        this.forderprice = forderprice;
    }

    public Integer getFordermethod() {
        return fordermethod;
    }

    public void setFordermethod(Integer fordermethod) {
        this.fordermethod = fordermethod;
    }

    public Integer getFpricefixingtype() {
        return fpricefixingtype;
    }

    public void setFpricefixingtype(Integer fpricefixingtype) {
        this.fpricefixingtype = fpricefixingtype;
    }

    public Integer getFsalepricefixingtype() {
        return fsalepricefixingtype;
    }

    public void setFsalepricefixingtype(Integer fsalepricefixingtype) {
        this.fsalepricefixingtype = fsalepricefixingtype;
    }

    public Double getFperwastage() {
        return fperwastage;
    }

    public void setFperwastage(Double fperwastage) {
        this.fperwastage = fperwastage;
    }

    public Integer getFaracctid() {
        return faracctid;
    }

    public void setFaracctid(Integer faracctid) {
        this.faracctid = faracctid;
    }

    public Short getFplanpricemethod() {
        return fplanpricemethod;
    }

    public void setFplanpricemethod(Short fplanpricemethod) {
        this.fplanpricemethod = fplanpricemethod;
    }

    public Short getFplanclass() {
        return fplanclass;
    }

    public void setFplanclass(Short fplanclass) {
        this.fplanclass = fplanclass;
    }

    public String getFmodel() {
        return fmodel;
    }

    public void setFmodel(String fmodel) {
        this.fmodel = fmodel == null ? null : fmodel.trim();
    }

    public String getFitemdescription() {
        return fitemdescription;
    }

    public void setFitemdescription(String fitemdescription) {
        this.fitemdescription = fitemdescription == null ? null : fitemdescription.trim();
    }

    public String getFalias() {
        return falias;
    }

    public void setFalias(String falias) {
        this.falias = falias == null ? null : falias.trim();
    }

    public String getFapproveno() {
        return fapproveno;
    }

    public void setFapproveno(String fapproveno) {
        this.fapproveno = fapproveno == null ? null : fapproveno.trim();
    }

    public Integer getFauxclassid() {
        return fauxclassid;
    }

    public void setFauxclassid(Integer fauxclassid) {
        this.fauxclassid = fauxclassid;
    }

    public Integer getFdefaultloc() {
        return fdefaultloc;
    }

    public void setFdefaultloc(Integer fdefaultloc) {
        this.fdefaultloc = fdefaultloc;
    }

    public String getFequipmentnum() {
        return fequipmentnum;
    }

    public void setFequipmentnum(String fequipmentnum) {
        this.fequipmentnum = fequipmentnum == null ? null : fequipmentnum.trim();
    }

    public Integer getFerpclsid() {
        return ferpclsid;
    }

    public void setFerpclsid(Integer ferpclsid) {
        this.ferpclsid = ferpclsid;
    }

    public String getFfullname() {
        return ffullname;
    }

    public void setFfullname(String ffullname) {
        this.ffullname = ffullname == null ? null : ffullname.trim();
    }

    public BigDecimal getFhighlimit() {
        return fhighlimit;
    }

    public void setFhighlimit(BigDecimal fhighlimit) {
        this.fhighlimit = fhighlimit;
    }

    public Boolean getFisequipment() {
        return fisequipment;
    }

    public void setFisequipment(Boolean fisequipment) {
        this.fisequipment = fisequipment;
    }

    public Boolean getFissparepart() {
        return fissparepart;
    }

    public void setFissparepart(Boolean fissparepart) {
        this.fissparepart = fissparepart;
    }

    public BigDecimal getFlowlimit() {
        return flowlimit;
    }

    public void setFlowlimit(BigDecimal flowlimit) {
        this.flowlimit = flowlimit;
    }

    public Integer getForderunitid() {
        return forderunitid;
    }

    public void setForderunitid(Integer forderunitid) {
        this.forderunitid = forderunitid;
    }

    public Integer getFpredeadline() {
        return fpredeadline;
    }

    public void setFpredeadline(Integer fpredeadline) {
        this.fpredeadline = fpredeadline;
    }

    public Integer getFproductunitid() {
        return fproductunitid;
    }

    public void setFproductunitid(Integer fproductunitid) {
        this.fproductunitid = fproductunitid;
    }

    public Short getFqtydecimal() {
        return fqtydecimal;
    }

    public void setFqtydecimal(Short fqtydecimal) {
        this.fqtydecimal = fqtydecimal;
    }

    public Integer getFsaleunitid() {
        return fsaleunitid;
    }

    public void setFsaleunitid(Integer fsaleunitid) {
        this.fsaleunitid = fsaleunitid;
    }

    public BigDecimal getFseccoefficient() {
        return fseccoefficient;
    }

    public void setFseccoefficient(BigDecimal fseccoefficient) {
        this.fseccoefficient = fseccoefficient;
    }

    public Integer getFsecunitdecimal() {
        return fsecunitdecimal;
    }

    public void setFsecunitdecimal(Integer fsecunitdecimal) {
        this.fsecunitdecimal = fsecunitdecimal;
    }

    public BigDecimal getFsecinv() {
        return fsecinv;
    }

    public void setFsecinv(BigDecimal fsecinv) {
        this.fsecinv = fsecinv;
    }

    public Integer getFsecunitid() {
        return fsecunitid;
    }

    public void setFsecunitid(Integer fsecunitid) {
        this.fsecunitid = fsecunitid;
    }

    public Integer getFserialclassid() {
        return fserialclassid;
    }

    public void setFserialclassid(Integer fserialclassid) {
        this.fserialclassid = fserialclassid;
    }

    public Integer getFsource() {
        return fsource;
    }

    public void setFsource(Integer fsource) {
        this.fsource = fsource;
    }

    public Integer getFspid() {
        return fspid;
    }

    public void setFspid(Integer fspid) {
        this.fspid = fspid;
    }

    public Integer getFstoreunitid() {
        return fstoreunitid;
    }

    public void setFstoreunitid(Integer fstoreunitid) {
        this.fstoreunitid = fstoreunitid;
    }

    public Integer getFtypeid() {
        return ftypeid;
    }

    public void setFtypeid(Integer ftypeid) {
        this.ftypeid = ftypeid;
    }

    public Integer getFunitgroupid() {
        return funitgroupid;
    }

    public void setFunitgroupid(Integer funitgroupid) {
        this.funitgroupid = funitgroupid;
    }

    public Integer getFunitid() {
        return funitid;
    }

    public void setFunitid(Integer funitid) {
        this.funitid = funitid;
    }

    public Integer getFusestate() {
        return fusestate;
    }

    public void setFusestate(Integer fusestate) {
        this.fusestate = fusestate;
    }

    public String getFabccls() {
        return fabccls;
    }

    public void setFabccls(String fabccls) {
        this.fabccls = fabccls == null ? null : fabccls.trim();
    }

    public Integer getFacctid() {
        return facctid;
    }

    public void setFacctid(Integer facctid) {
        this.facctid = facctid;
    }

    public Integer getFadminacctid() {
        return fadminacctid;
    }

    public void setFadminacctid(Integer fadminacctid) {
        this.fadminacctid = fadminacctid;
    }

    public Integer getFapacctid() {
        return fapacctid;
    }

    public void setFapacctid(Integer fapacctid) {
        this.fapacctid = fapacctid;
    }

    public Boolean getFbatchmanager() {
        return fbatchmanager;
    }

    public void setFbatchmanager(Boolean fbatchmanager) {
        this.fbatchmanager = fbatchmanager;
    }

    public Double getFbatchqty() {
        return fbatchqty;
    }

    public void setFbatchqty(Double fbatchqty) {
        this.fbatchqty = fbatchqty;
    }

    public Integer getFbeforeexpire() {
        return fbeforeexpire;
    }

    public void setFbeforeexpire(Integer fbeforeexpire) {
        this.fbeforeexpire = fbeforeexpire;
    }

    public Boolean getFbookplan() {
        return fbookplan;
    }

    public void setFbookplan(Boolean fbookplan) {
        this.fbookplan = fbookplan;
    }

    public Integer getFcheckcycle() {
        return fcheckcycle;
    }

    public void setFcheckcycle(Integer fcheckcycle) {
        this.fcheckcycle = fcheckcycle;
    }

    public Integer getFcheckcycunit() {
        return fcheckcycunit;
    }

    public void setFcheckcycunit(Integer fcheckcycunit) {
        this.fcheckcycunit = fcheckcycunit;
    }

    public Boolean getFclass() {
        return fclass;
    }

    public void setFclass(Boolean fclass) {
        this.fclass = fclass;
    }

    public Integer getFcostacctid() {
        return fcostacctid;
    }

    public void setFcostacctid(Integer fcostacctid) {
        this.fcostacctid = fcostacctid;
    }

    public Double getFcostdiffrate() {
        return fcostdiffrate;
    }

    public void setFcostdiffrate(Double fcostdiffrate) {
        this.fcostdiffrate = fcostdiffrate;
    }

    public Integer getFcostproject() {
        return fcostproject;
    }

    public void setFcostproject(Integer fcostproject) {
        this.fcostproject = fcostproject;
    }

    public Integer getFdaysper() {
        return fdaysper;
    }

    public void setFdaysper(Integer fdaysper) {
        this.fdaysper = fdaysper;
    }

    public Integer getFdepartment() {
        return fdepartment;
    }

    public void setFdepartment(Integer fdepartment) {
        this.fdepartment = fdepartment;
    }

    public Integer getFgoodspec() {
        return fgoodspec;
    }

    public void setFgoodspec(Integer fgoodspec) {
        this.fgoodspec = fgoodspec;
    }

    public Boolean getFiskfperiod() {
        return fiskfperiod;
    }

    public void setFiskfperiod(Boolean fiskfperiod) {
        this.fiskfperiod = fiskfperiod;
    }

    public Boolean getFissale() {
        return fissale;
    }

    public void setFissale(Boolean fissale) {
        this.fissale = fissale;
    }

    public Boolean getFissnmanage() {
        return fissnmanage;
    }

    public void setFissnmanage(Boolean fissnmanage) {
        this.fissnmanage = fissnmanage;
    }

    public Boolean getFisspecialtax() {
        return fisspecialtax;
    }

    public void setFisspecialtax(Boolean fisspecialtax) {
        this.fisspecialtax = fisspecialtax;
    }

    public BigDecimal getFkfperiod() {
        return fkfperiod;
    }

    public void setFkfperiod(BigDecimal fkfperiod) {
        this.fkfperiod = fkfperiod;
    }

    public Date getFlastcheckdate() {
        return flastcheckdate;
    }

    public void setFlastcheckdate(Date flastcheckdate) {
        this.flastcheckdate = flastcheckdate;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public BigDecimal getFoihighlimit() {
        return foihighlimit;
    }

    public void setFoihighlimit(BigDecimal foihighlimit) {
        this.foihighlimit = foihighlimit;
    }

    public BigDecimal getFoilowlimit() {
        return foilowlimit;
    }

    public void setFoilowlimit(BigDecimal foilowlimit) {
        this.foilowlimit = foilowlimit;
    }

    public Integer getForderrector() {
        return forderrector;
    }

    public void setForderrector(Integer forderrector) {
        this.forderrector = forderrector;
    }

    public BigDecimal getFplanprice() {
        return fplanprice;
    }

    public void setFplanprice(BigDecimal fplanprice) {
        this.fplanprice = fplanprice;
    }

    public Integer getFpohghprcmnytype() {
        return fpohghprcmnytype;
    }

    public void setFpohghprcmnytype(Integer fpohghprcmnytype) {
        this.fpohghprcmnytype = fpohghprcmnytype;
    }

    public BigDecimal getFpohighprice() {
        return fpohighprice;
    }

    public void setFpohighprice(BigDecimal fpohighprice) {
        this.fpohighprice = fpohighprice;
    }

    public Short getFpricedecimal() {
        return fpricedecimal;
    }

    public void setFpricedecimal(Short fpricedecimal) {
        this.fpricedecimal = fpricedecimal;
    }

    public BigDecimal getFprofitrate() {
        return fprofitrate;
    }

    public void setFprofitrate(BigDecimal fprofitrate) {
        this.fprofitrate = fprofitrate;
    }

    public Integer getFsaleacctid() {
        return fsaleacctid;
    }

    public void setFsaleacctid(Integer fsaleacctid) {
        this.fsaleacctid = fsaleacctid;
    }

    public BigDecimal getFsaleprice() {
        return fsaleprice;
    }

    public void setFsaleprice(BigDecimal fsaleprice) {
        this.fsaleprice = fsaleprice;
    }

    public Integer getFsaletaxacctid() {
        return fsaletaxacctid;
    }

    public void setFsaletaxacctid(Integer fsaletaxacctid) {
        this.fsaletaxacctid = fsaletaxacctid;
    }

    public BigDecimal getFsohighlimit() {
        return fsohighlimit;
    }

    public void setFsohighlimit(BigDecimal fsohighlimit) {
        this.fsohighlimit = fsohighlimit;
    }

    public BigDecimal getFsolowlimit() {
        return fsolowlimit;
    }

    public void setFsolowlimit(BigDecimal fsolowlimit) {
        this.fsolowlimit = fsolowlimit;
    }

    public BigDecimal getFsolowprc() {
        return fsolowprc;
    }

    public void setFsolowprc(BigDecimal fsolowprc) {
        this.fsolowprc = fsolowprc;
    }

    public Integer getFsolowprcmnytype() {
        return fsolowprcmnytype;
    }

    public void setFsolowprcmnytype(Integer fsolowprcmnytype) {
        this.fsolowprcmnytype = fsolowprcmnytype;
    }

    public BigDecimal getFstockprice() {
        return fstockprice;
    }

    public void setFstockprice(BigDecimal fstockprice) {
        this.fstockprice = fstockprice;
    }

    public Boolean getFstocktime() {
        return fstocktime;
    }

    public void setFstocktime(Boolean fstocktime) {
        this.fstocktime = fstocktime;
    }

    public Integer getFtaxrate() {
        return ftaxrate;
    }

    public void setFtaxrate(Integer ftaxrate) {
        this.ftaxrate = ftaxrate;
    }

    public Integer getFtrack() {
        return ftrack;
    }

    public void setFtrack(Integer ftrack) {
        this.ftrack = ftrack;
    }

    public BigDecimal getFwwhghprc() {
        return fwwhghprc;
    }

    public void setFwwhghprc(BigDecimal fwwhghprc) {
        this.fwwhghprc = fwwhghprc;
    }

    public Integer getFwwhghprcmnytype() {
        return fwwhghprcmnytype;
    }

    public void setFwwhghprcmnytype(Integer fwwhghprcmnytype) {
        this.fwwhghprcmnytype = fwwhghprcmnytype;
    }

    public Integer getFcbbmstandardid() {
        return fcbbmstandardid;
    }

    public void setFcbbmstandardid(Integer fcbbmstandardid) {
        this.fcbbmstandardid = fcbbmstandardid;
    }

    public BigDecimal getFbatchangeeconomy() {
        return fbatchangeeconomy;
    }

    public void setFbatchangeeconomy(BigDecimal fbatchangeeconomy) {
        this.fbatchangeeconomy = fbatchangeeconomy;
    }

    public BigDecimal getFbatchappendqty() {
        return fbatchappendqty;
    }

    public void setFbatchappendqty(BigDecimal fbatchappendqty) {
        this.fbatchappendqty = fbatchappendqty;
    }

    public BigDecimal getFbatfixeconomy() {
        return fbatfixeconomy;
    }

    public void setFbatfixeconomy(BigDecimal fbatfixeconomy) {
        this.fbatfixeconomy = fbatfixeconomy;
    }

    public Integer getFcuunitid() {
        return fcuunitid;
    }

    public void setFcuunitid(Integer fcuunitid) {
        this.fcuunitid = fcuunitid;
    }

    public BigDecimal getFdailyconsume() {
        return fdailyconsume;
    }

    public void setFdailyconsume(BigDecimal fdailyconsume) {
        this.fdailyconsume = fdailyconsume;
    }

    public Integer getFdefaultroutingid() {
        return fdefaultroutingid;
    }

    public void setFdefaultroutingid(Integer fdefaultroutingid) {
        this.fdefaultroutingid = fdefaultroutingid;
    }

    public Integer getFdefaultworktypeid() {
        return fdefaultworktypeid;
    }

    public void setFdefaultworktypeid(Integer fdefaultworktypeid) {
        this.fdefaultworktypeid = fdefaultworktypeid;
    }

    public Float getFfixleadtime() {
        return ffixleadtime;
    }

    public void setFfixleadtime(Float ffixleadtime) {
        this.ffixleadtime = ffixleadtime;
    }

    public BigDecimal getFinhighlimit() {
        return finhighlimit;
    }

    public void setFinhighlimit(BigDecimal finhighlimit) {
        this.finhighlimit = finhighlimit;
    }

    public BigDecimal getFinlowlimit() {
        return finlowlimit;
    }

    public void setFinlowlimit(BigDecimal finlowlimit) {
        this.finlowlimit = finlowlimit;
    }

    public Float getFleadtime() {
        return fleadtime;
    }

    public void setFleadtime(Float fleadtime) {
        this.fleadtime = fleadtime;
    }

    public Integer getFlowestbomcode() {
        return flowestbomcode;
    }

    public void setFlowestbomcode(Integer flowestbomcode) {
        this.flowestbomcode = flowestbomcode;
    }

    public Boolean getFmrpcon() {
        return fmrpcon;
    }

    public void setFmrpcon(Boolean fmrpcon) {
        this.fmrpcon = fmrpcon;
    }

    public Integer getForderinterval() {
        return forderinterval;
    }

    public void setForderinterval(Integer forderinterval) {
        this.forderinterval = forderinterval;
    }

    public BigDecimal getForderpoint() {
        return forderpoint;
    }

    public void setForderpoint(BigDecimal forderpoint) {
        this.forderpoint = forderpoint;
    }

    public Integer getFordertrategy() {
        return fordertrategy;
    }

    public void setFordertrategy(Integer fordertrategy) {
        this.fordertrategy = fordertrategy;
    }

    public Integer getFplanner() {
        return fplanner;
    }

    public void setFplanner(Integer fplanner) {
        this.fplanner = fplanner;
    }

    public Integer getFplanpoint() {
        return fplanpoint;
    }

    public void setFplanpoint(Integer fplanpoint) {
        this.fplanpoint = fplanpoint;
    }

    public Integer getFplantrategy() {
        return fplantrategy;
    }

    public void setFplantrategy(Integer fplantrategy) {
        this.fplantrategy = fplantrategy;
    }

    public Integer getFproductprincipal() {
        return fproductprincipal;
    }

    public void setFproductprincipal(Integer fproductprincipal) {
        this.fproductprincipal = fproductprincipal;
    }

    public Boolean getFputinteger() {
        return fputinteger;
    }

    public void setFputinteger(Boolean fputinteger) {
        this.fputinteger = fputinteger;
    }

    public BigDecimal getFqtymax() {
        return fqtymax;
    }

    public void setFqtymax(BigDecimal fqtymax) {
        this.fqtymax = fqtymax;
    }

    public BigDecimal getFqtymin() {
        return fqtymin;
    }

    public void setFqtymin(BigDecimal fqtymin) {
        this.fqtymin = fqtymin;
    }

    public Integer getFrequirepoint() {
        return frequirepoint;
    }

    public void setFrequirepoint(Integer frequirepoint) {
        this.frequirepoint = frequirepoint;
    }

    public Integer getFtotaltqq() {
        return ftotaltqq;
    }

    public void setFtotaltqq(Integer ftotaltqq) {
        this.ftotaltqq = ftotaltqq;
    }

    public Boolean getFmrporder() {
        return fmrporder;
    }

    public void setFmrporder(Boolean fmrporder) {
        this.fmrporder = fmrporder;
    }

    public Boolean getFbatchcreate() {
        return fbatchcreate;
    }

    public void setFbatchcreate(Boolean fbatchcreate) {
        this.fbatchcreate = fbatchcreate;
    }

    public String getFchartnumber() {
        return fchartnumber;
    }

    public void setFchartnumber(String fchartnumber) {
        this.fchartnumber = fchartnumber == null ? null : fchartnumber.trim();
    }

    public Integer getFcubicmeasure() {
        return fcubicmeasure;
    }

    public void setFcubicmeasure(Integer fcubicmeasure) {
        this.fcubicmeasure = fcubicmeasure;
    }

    public BigDecimal getFgrossweight() {
        return fgrossweight;
    }

    public void setFgrossweight(BigDecimal fgrossweight) {
        this.fgrossweight = fgrossweight;
    }

    public BigDecimal getFheight() {
        return fheight;
    }

    public void setFheight(BigDecimal fheight) {
        this.fheight = fheight;
    }

    public Boolean getFiskeyitem() {
        return fiskeyitem;
    }

    public void setFiskeyitem(Boolean fiskeyitem) {
        this.fiskeyitem = fiskeyitem;
    }

    public BigDecimal getFlength() {
        return flength;
    }

    public void setFlength(BigDecimal flength) {
        this.flength = flength;
    }

    public Integer getFmaund() {
        return fmaund;
    }

    public void setFmaund(Integer fmaund) {
        this.fmaund = fmaund;
    }

    public BigDecimal getFnetweight() {
        return fnetweight;
    }

    public void setFnetweight(BigDecimal fnetweight) {
        this.fnetweight = fnetweight;
    }

    public BigDecimal getFsize() {
        return fsize;
    }

    public void setFsize(BigDecimal fsize) {
        this.fsize = fsize;
    }

    public String getFversion() {
        return fversion;
    }

    public void setFversion(String fversion) {
        this.fversion = fversion == null ? null : fversion.trim();
    }

    public BigDecimal getFwidth() {
        return fwidth;
    }

    public void setFwidth(BigDecimal fwidth) {
        this.fwidth = fwidth;
    }

    public BigDecimal getFchgfeerate() {
        return fchgfeerate;
    }

    public void setFchgfeerate(BigDecimal fchgfeerate) {
        this.fchgfeerate = fchgfeerate;
    }

    public BigDecimal getFoutmachfee() {
        return foutmachfee;
    }

    public void setFoutmachfee(BigDecimal foutmachfee) {
        this.foutmachfee = foutmachfee;
    }

    public BigDecimal getFpiecerate() {
        return fpiecerate;
    }

    public void setFpiecerate(BigDecimal fpiecerate) {
        this.fpiecerate = fpiecerate;
    }

    public BigDecimal getFstandardcost() {
        return fstandardcost;
    }

    public void setFstandardcost(BigDecimal fstandardcost) {
        this.fstandardcost = fstandardcost;
    }

    public BigDecimal getFstandardmanhour() {
        return fstandardmanhour;
    }

    public void setFstandardmanhour(BigDecimal fstandardmanhour) {
        this.fstandardmanhour = fstandardmanhour;
    }

    public BigDecimal getFstdfixfeerate() {
        return fstdfixfeerate;
    }

    public void setFstdfixfeerate(BigDecimal fstdfixfeerate) {
        this.fstdfixfeerate = fstdfixfeerate;
    }

    public BigDecimal getFstdpayrate() {
        return fstdpayrate;
    }

    public void setFstdpayrate(BigDecimal fstdpayrate) {
        this.fstdpayrate = fstdpayrate;
    }

    public Integer getFidentifier() {
        return fidentifier;
    }

    public void setFidentifier(Integer fidentifier) {
        this.fidentifier = fidentifier;
    }

    public Integer getFinspectionlevel() {
        return finspectionlevel;
    }

    public void setFinspectionlevel(Integer finspectionlevel) {
        this.finspectionlevel = finspectionlevel;
    }

    public Integer getFinspectionproject() {
        return finspectionproject;
    }

    public void setFinspectionproject(Integer finspectionproject) {
        this.finspectionproject = finspectionproject;
    }

    public Integer getFislistcontrol() {
        return fislistcontrol;
    }

    public void setFislistcontrol(Integer fislistcontrol) {
        this.fislistcontrol = fislistcontrol;
    }

    public Integer getFotherchkmde() {
        return fotherchkmde;
    }

    public void setFotherchkmde(Integer fotherchkmde) {
        this.fotherchkmde = fotherchkmde;
    }

    public Integer getFprochkmde() {
        return fprochkmde;
    }

    public void setFprochkmde(Integer fprochkmde) {
        this.fprochkmde = fprochkmde;
    }

    public Integer getFsochkmde() {
        return fsochkmde;
    }

    public void setFsochkmde(Integer fsochkmde) {
        this.fsochkmde = fsochkmde;
    }

    public Integer getFstkchkalrm() {
        return fstkchkalrm;
    }

    public void setFstkchkalrm(Integer fstkchkalrm) {
        this.fstkchkalrm = fstkchkalrm;
    }

    public Integer getFstkchkmde() {
        return fstkchkmde;
    }

    public void setFstkchkmde(Integer fstkchkmde) {
        this.fstkchkmde = fstkchkmde;
    }

    public Integer getFstkchkprd() {
        return fstkchkprd;
    }

    public void setFstkchkprd(Integer fstkchkprd) {
        this.fstkchkprd = fstkchkprd;
    }

    public Integer getFwthdrwchkmde() {
        return fwthdrwchkmde;
    }

    public void setFwthdrwchkmde(Integer fwthdrwchkmde) {
        this.fwthdrwchkmde = fwthdrwchkmde;
    }

    public Integer getFwwchkmde() {
        return fwwchkmde;
    }

    public void setFwwchkmde(Integer fwwchkmde) {
        this.fwwchkmde = fwwchkmde;
    }

    public byte[] getFmodifytime() {
        return fmodifytime;
    }

    public void setFmodifytime(byte[] fmodifytime) {
        this.fmodifytime = fmodifytime;
    }
}