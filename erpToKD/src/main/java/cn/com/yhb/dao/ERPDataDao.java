package cn.com.yhb.dao;

import cn.com.yhb.Utils.DateUtil;
import cn.com.yhb.Utils.StringUtil;
import cn.com.yhb.config.SSHConnection;
import cn.com.yhb.ds2.mapper.*;
import cn.com.yhb.ds3.mapper.*;
import cn.com.yhb.entity.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ERPDataDao {

    private SSHConnection sshConnection;

    private Connection connection;

    private Statement st;

    private static String sql = "";

    private ResultSet resultSet;

    @Autowired
    cn_account2Mapper cn_account2Mapper;
    @Autowired
    icstockbill2Mapper icstockbill2Mapper;
    @Autowired
    t_ICItem2Mapper t_ICItem2Mapper;
    @Autowired
    t_ItemClass2Mapper t_ItemClass2Mapper;
    @Autowired
    t_MeasureUnit2Mapper t_MeasureUnit2Mapper;
    @Autowired
    t_Organization2Mapper t_Organization2Mapper;
    @Autowired
    t_Stock2Mapper t_stock2Mapper;
    @Autowired
    t_Supplier2Mapper t_Supplier2Mapper;

    @Autowired
    cn_account3Mapper cn_account3Mapper;
    @Autowired
    icstockbill3Mapper icstockbill3Mapper;
    @Autowired
    t_ICItem3Mapper t_ICItem3Mapper;
    @Autowired
    t_ItemClass3Mapper t_ItemClass3Mapper;
    @Autowired
    t_MeasureUnit3Mapper t_MeasureUnit3Mapper;
    @Autowired
    t_Organization3Mapper t_Organization3Mapper;
    @Autowired
    t_Stock3Mapper t_stock3Mapper;
    @Autowired
    t_Supplier3Mapper t_Supplier3Mapper;

    @Autowired
    T_Item2Mapper t_item2Mapper;
    @Autowired
    t_ICItemBase2Mapper t_icItemBase2Mapper;
    @Autowired
    T_ICItemCore2Mapper t_icItemCore2Mapper;
    @Autowired
    T_ICItemCustom2Mapper t_icItemCustom2Mapper;
    @Autowired
    T_ICItemDesign2Mapper t_iCItemDesign2Mapper;
    @Autowired
    T_ICItemMaterial2Mapper t_icItemMaterial2Mapper;
    @Autowired
    T_ICItemPlan2Mapper t_icItemPlan2Mapper;
    @Autowired
    T_ICItemQuality2Mapper t_icItemQuality2Mapper;
    @Autowired
    T_ICItemStandard2Mapper t_icItemStandard2Mapper;

    @Autowired
    T_Item3Mapper t_item3Mapper;
    @Autowired
    T_ICItemBase3Mapper t_icItemBase3Mapper;
    @Autowired
    T_ICItemCore3Mapper t_icItemCore3Mapper;
    @Autowired
    T_ICItemCustom3Mapper t_icItemCustom3Mapper;
    @Autowired
    T_ICItemDesign3Mapper t_iCItemDesign3Mapper;
    @Autowired
    T_ICItemMaterial3Mapper t_icItemMaterial3Mapper;
    @Autowired
    T_ICItemPlan3Mapper t_icItemPlan3Mapper;
    @Autowired
    T_ICItemQuality3Mapper t_icItemQuality3Mapper;
    @Autowired
    T_ICItemStandard3Mapper t_icItemStandard3Mapper;

    /**
     * 获取商品类别
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sys_prdt_types(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_prdt_type t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            for (int i = 0; i < metaData.getColumnCount(); i++) {
//                // resultSet数据下标从1开始
//                int type = metaData.getColumnType(i + 1);
//                if (Types.INTEGER == type) {
//                    // int
//                } else if (Types.VARCHAR == type) {
//                    // String
//                }
//            }
            while (resultSet.next()) {
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_item.setFitemclassid(4);
                t_item.setFexternid(-1);
                t_item.setFnumber(StringUtil.getStr(resultSet.getString("prdt_type")));
                t_item.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))));
                t_item.setFlevel(Short.parseShort("1"));
                t_item.setFdetail(false);
                t_item.setFname(StringUtil.getStr(resultSet.getString("prdt_type_name")));
                t_item.setFunused(Integer.parseInt(StringUtil.strToNum(resultSet.getString("is_stop"))) == 0 ? true : false);
                t_item.setFbrno("0");
                t_item.setFfullnumber(StringUtil.getStr(resultSet.getString("prdt_type_full")));
                t_item.setFdiff(false);
                t_item.setFdeleted((short) 0);
                t_item.setFshortnumber(StringUtil.getStr(resultSet.getString("prdt_type")));
                t_item.setFfullname(StringUtil.getStr(resultSet.getString("prdt_type_name_full")));
                t_item.setUuid(UUID.randomUUID().toString());
                t_item.setFgrcommonid(-1);
                t_item.setFsystemtype(1);
                t_item.setFusesign(0);
                t_item.setFchkuserid(null);
                t_item.setFgrcontrol(-1);
                t_item.setFrightuserid(null);
                t_item.setFonsale(0);
                t_item2Mapper.insert(t_item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取商品资料
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sys_prdts(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_prdt t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                t_ICItemCore t_icItemCore = new t_ICItemCore();
                t_icItemCore.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemCore.setFmodel(StringUtil.getStr(resultSet.getString("spc")));
                t_icItemCore.setFname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_icItemCore.setFhelpcode("");
                t_icItemCore.setFdeleted(Short.parseShort(StringUtil.strToNum(resultSet.getString("is_stop"))));
                t_icItemCore.setFshortnumber(StringUtil.getStr(resultSet.getString("prdt_code")));
                t_icItemCore.setFnumber(StringUtil.getStr(resultSet.getString("prdt_code")));
                t_icItemCore.setFmodifytime(resultSet.getString("modified").getBytes());
                t_icItemCore.setFparentid(0);
                t_icItemCore.setFbrno("0");
                t_icItemCore.setFtopid(0);
                t_icItemCore.setFrp(null);
                t_icItemCore.setFomortize(null);
                t_icItemCore.setFomortizescale(null);
                t_icItemCore.setFforsale(false);
                t_icItemCore.setFstacost(null);
                t_icItemCore.setForderprice(Double.valueOf(StringUtil.strToNum(resultSet.getString("up_ret"))));
                t_icItemCore.setFordermethod(null);
                t_icItemCore.setFpricefixingtype(0);
                t_icItemCore.setFsalepricefixingtype(0);
                t_icItemCore.setFperwastage(0.0);
                t_icItemCore.setFaracctid(null);
                t_icItemCore.setFplanpricemethod(null);
                t_icItemCore.setFplanclass(null);
                t_icItemCore.setFitemdescription(null);
                t_icItemCore2Mapper.insert(t_icItemCore);

                t_ICItemBase t_icItemBase = new t_ICItemBase();
                t_icItemBase.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemBase.setFerpclsid(1);
                t_icItemBase.setFunitid(0);
                t_icItemBase.setFunitgroupid(0);
                t_icItemBase.setFdefaultloc(0);
                t_icItemBase.setFspid(0);
                t_icItemBase.setFsource(0);
                t_icItemBase.setFqtydecimal(Short.parseShort("4"));
                t_icItemBase.setFlowlimit(new BigDecimal(StringUtil.strToNum(resultSet.getString("least_qty"))));
                t_icItemBase.setFhighlimit(new BigDecimal(StringUtil.strToNum(resultSet.getString("most_qty"))));
                t_icItemBase.setFsecinv(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_warn"))));
                t_icItemBase.setFusestate(341);
                t_icItemBase.setFisequipment(false);
                t_icItemBase.setFequipmentnum(null);
                t_icItemBase.setFissparepart(false);
                t_icItemBase.setFfullname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_icItemBase.setFseccoefficient(new BigDecimal(0));
                t_icItemBase.setFsecunitdecimal(0);
                t_icItemBase.setFalias(null);
                t_icItemBase.setForderunitid(0);
                t_icItemBase.setFsaleunitid(0);
                t_icItemBase.setFproductunitid(0);
                t_icItemBase.setFapproveno(null);
                t_icItemBase.setFauxclassid(0);
                t_icItemBase.setFtypeid(null);
                t_icItemBase.setFpredeadline(null);
                t_icItemBase.setFserialclassid(0);
                t_icItemBase2Mapper.insert(t_icItemBase);

                t_ICItemMaterial t_iCItemMaterial = new t_ICItemMaterial();
                t_iCItemMaterial.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_iCItemMaterial.setForderrector(0);
                t_iCItemMaterial.setFpohghprcmnytype(1);
                t_iCItemMaterial.setFpohighprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_pur"))));
                t_iCItemMaterial.setFwwhghprc(new BigDecimal(0));
                t_iCItemMaterial.setFwwhghprcmnytype(1);
                t_iCItemMaterial.setFsolowprc(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_min"))));
                t_iCItemMaterial.setFsolowprcmnytype(1);
                t_iCItemMaterial.setFissale(false);
                t_iCItemMaterial.setFprofitrate(new BigDecimal(0));
                t_iCItemMaterial.setFsaleprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_ret"))));
                t_iCItemMaterial.setFbatchmanager(false);
                t_iCItemMaterial.setFiskfperiod(false);
                t_iCItemMaterial.setFtrack(76);
                t_iCItemMaterial.setFplanprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("declare_value"))));
                t_iCItemMaterial.setFpricedecimal(Short.parseShort("2"));
                t_iCItemMaterial.setFacctid(1024);
                t_iCItemMaterial.setFsaleacctid(null);
                t_iCItemMaterial.setFcostacctid(0);
                t_iCItemMaterial.setFapacctid(null);
                t_iCItemMaterial.setFgoodspec(0);
                t_iCItemMaterial.setFcostproject(0);
                t_iCItemMaterial.setFissnmanage(null);
                t_iCItemMaterial.setFstocktime(false);
                t_iCItemMaterial.setFbookplan(null);
                t_iCItemMaterial.setFbeforeexpire(null);
                t_iCItemMaterial.setFtaxrate(13);
                t_iCItemMaterial.setFadminacctid(0);
                t_iCItemMaterial.setFnote(null);
                t_iCItemMaterial.setFisspecialtax(null);
                t_iCItemMaterial.setFsohighlimit(new BigDecimal(100));
                t_iCItemMaterial.setFsolowlimit(new BigDecimal(100));
                t_iCItemMaterial.setFoihighlimit(new BigDecimal(100));
                t_iCItemMaterial.setFoilowlimit(new BigDecimal(100));
                t_iCItemMaterial.setFdaysper(null);
                t_iCItemMaterial.setFlastcheckdate(null);
                t_iCItemMaterial.setFcheckcycle(null);
                t_iCItemMaterial.setFcheckcycunit(null);
                t_iCItemMaterial.setFstockprice(new BigDecimal(0));
                t_iCItemMaterial.setFabccls(null);
                t_iCItemMaterial.setFbatchqty(null);
                t_iCItemMaterial.setFclass(false);
                t_iCItemMaterial.setFcostdiffrate(null);
                t_iCItemMaterial.setFdepartment(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                t_iCItemMaterial.setFsaletaxacctid(null);
                t_iCItemMaterial.setFcbbmstandardid(0);
                t_iCItemMaterial.setFbatchcreate(false);
                t_icItemMaterial2Mapper.insert(t_iCItemMaterial);

                t_ICItemPlan t_icItemPlan = new t_ICItemPlan();
                t_icItemPlan.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemPlan.setFplantrategy(321);
                t_icItemPlan.setFordertrategy(331);
                t_icItemPlan.setFleadtime(0f);
                t_icItemPlan.setFfixleadtime(0f);
                t_icItemPlan.setFtotaltqq(1);
                t_icItemPlan.setFqtymin(new BigDecimal(1));
                t_icItemPlan.setFqtymax(new BigDecimal(10000));
                t_icItemPlan.setFcuunitid(0);
                t_icItemPlan.setForderinterval(1);
                t_icItemPlan.setFbatchappendqty(null);
                t_icItemPlan.setForderpoint(new BigDecimal(1));
                t_icItemPlan.setFbatfixeconomy(new BigDecimal(1));
                t_icItemPlan.setFbatchangeeconomy(new BigDecimal(1));
                t_icItemPlan.setFrequirepoint(1);
                t_icItemPlan.setFplanpoint(1);
                t_icItemPlan.setFdefaultworktypeid(0);
                t_icItemPlan.setFproductprincipal(0);
                t_icItemPlan.setFdailyconsume(null);
                t_icItemPlan.setFmrpcon(true);
                t_icItemPlan.setFplanner(null);
                t_icItemPlan.setFputinteger(false);
                t_icItemPlan.setFinhighlimit(new BigDecimal(0));
                t_icItemPlan.setFinlowlimit(new BigDecimal(0));
                t_icItemPlan.setFlowestbomcode(null);
                t_icItemPlan.setFmrporder(false);
                t_icItemPlan2Mapper.insert(t_icItemPlan);

                t_ICItemDesign t_icItemDesign = new t_ICItemDesign();
                t_icItemDesign.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemDesign.setFchartnumber(null);
                t_icItemDesign.setFiskeyitem(false);
                t_icItemDesign.setFmaund(0);
                t_icItemDesign.setFgrossweight(new BigDecimal(StringUtil.strToNum(resultSet.getString("fac_weight"))));
                t_icItemDesign.setFnetweight(new BigDecimal(StringUtil.strToNum(resultSet.getString("weight"))));
                t_icItemDesign.setFcubicmeasure(0);
                t_icItemDesign.setFlength(new BigDecimal(StringUtil.strToNum(resultSet.getString("length"))));
                t_icItemDesign.setFwidth(new BigDecimal(StringUtil.strToNum(resultSet.getString("width"))));
                t_icItemDesign.setFheight(new BigDecimal(StringUtil.strToNum(resultSet.getString("height"))));
                t_icItemDesign.setFsize(new BigDecimal(StringUtil.strToNum(resultSet.getString("volume"))));
                t_icItemDesign.setFversion(null);
                t_iCItemDesign2Mapper.insert(t_icItemDesign);

                t_ICItemStandard t_icItemStandard = new t_ICItemStandard();
                t_icItemStandard.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemStandard.setFstandardcost(new BigDecimal(0));
                t_icItemStandard.setFstandardmanhour(new BigDecimal(0));
                t_icItemStandard.setFstdpayrate(new BigDecimal(0));
                t_icItemStandard.setFchgfeerate(new BigDecimal(0));
                t_icItemStandard.setFstdfixfeerate(new BigDecimal(0));
                t_icItemStandard.setFoutmachfee(new BigDecimal(0));
                t_icItemStandard.setFpiecerate(new BigDecimal(0));
                t_icItemStandard2Mapper.insert(t_icItemStandard);

                t_ICItemQuality t_icItemQuality = new t_ICItemQuality();
                t_icItemQuality.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemQuality.setFinspectionlevel(352);
                t_icItemQuality.setFinspectionproject(0);
                t_icItemQuality.setFislistcontrol(null);
                t_icItemQuality.setFprochkmde(null);
                t_icItemQuality.setFwwchkmde(null);
                t_icItemQuality.setFsochkmde(null);
                t_icItemQuality.setFwthdrwchkmde(null);
                t_icItemQuality.setFstkchkmde(null);
                t_icItemQuality.setFotherchkmde(null);
                t_icItemQuality.setFstkchkprd(9999);
                t_icItemQuality.setFstkchkalrm(0);
                t_icItemQuality.setFidentifier(0);
                t_icItemQuality2Mapper.insert(t_icItemQuality);

                t_ICItemCustom t_icItemCustom = new t_ICItemCustom();
                t_icItemCustom.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItemCustom.setFbatchcreate(false);
                t_icItemCustom2Mapper.insert(t_icItemCustom);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取供应商资料
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sys_custs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_cust t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                t_Supplier t_supplier = new t_Supplier();
                t_supplier.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_supplier.setFaddress(StringUtil.getStr(resultSet.getString("addrs")));
                t_supplier.setFcity("");
                t_supplier.setFprovince(StringUtil.getStr(resultSet.getString("state")));
                t_supplier.setFcountry("");
                t_supplier.setFpostalcode(StringUtil.getStr(resultSet.getString("zip_code")));
                t_supplier.setFphone(StringUtil.getStr(resultSet.getString("phone")));
                t_supplier.setFfax(StringUtil.getStr(resultSet.getString("fax")));
                t_supplier.setFemail(StringUtil.getStr(resultSet.getString("email")));
                t_supplier.setFhomepage("");
                t_supplier.setFcreditlimit(StringUtil.getStr(resultSet.getString("amtn_credit")));
                t_supplier.setFtaxid(StringUtil.getStr(resultSet.getString("tax_code")));
                t_supplier.setFbank(StringUtil.getStr(resultSet.getString("bank_code")));
                t_supplier.setFaccount(StringUtil.getStr(resultSet.getString("bank_user")));
                t_supplier.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                t_supplier.setFboundattr(null);
                t_supplier.setFerpclsid(null);
                t_supplier.setFshortname(StringUtil.getStr(resultSet.getString("snm")));
                t_supplier.setFpriorityid(null);
                t_supplier.setFpogroupid(null);
                t_supplier.setFstatus(1072);
                t_supplier.setFlanguageid(null);
                t_supplier.setFregionid(null);
                t_supplier.setFtrade(null);
                t_supplier.setFminpovalue(0.0);
                t_supplier.setFmaxdebitdate(0.0);
                t_supplier.setFlegalperson("");
                t_supplier.setFcontact(StringUtil.getStr(resultSet.getString("cnt_name")));
                t_supplier.setFcontactacct("");
                t_supplier.setFphoneacct(StringUtil.getStr(resultSet.getString("phone")));
                t_supplier.setFfaxacct("");
                t_supplier.setFzipacct("");
                t_supplier.setFemailacct("");
                t_supplier.setFaddracct("");
                t_supplier.setFtax(0f);
                t_supplier.setFcyid(0);
                t_supplier.setFsetid(0);
                t_supplier.setFsetdlineid(null);
                t_supplier.setFtaxnum(StringUtil.getStr(resultSet.getString("tax_code")));
                t_supplier.setFpriceclsid(null);
                t_supplier.setFoperid(null);
                t_supplier.setFciqnumber("");
                t_supplier.setFdeleted(Short.parseShort(StringUtil.strToNum(resultSet.getString("is_stop"))));
                t_supplier.setFsalemode((short)0);
                t_supplier.setFname(StringUtil.getStr(resultSet.getString("cust_name")));
                t_supplier.setFnumber(StringUtil.getStr(resultSet.getString("id")));
                t_supplier.setFparentid(0);
                t_supplier.setFshortnumber("");
                t_supplier.setFaraccountid(0);
                t_supplier.setFapaccountid(0);
                t_supplier.setFpreacctid(0);
                t_supplier.setFlasttradeamount(new BigDecimal(0));
                t_supplier.setFlastrpamount(new BigDecimal(0));
                t_supplier.setFfavorpolicy("");
                t_supplier.setFdepartment(Integer.parseInt(StringUtil.strToNum(resultSet.getString("brh_id"))));
                t_supplier.setFemployee(Integer.parseInt(StringUtil.strToNum(resultSet.getString("salm_id"))));
                t_supplier.setFcorperate(StringUtil.getStr(resultSet.getString("boss_name")));
                t_supplier.setFbegintradedate(null);
                t_supplier.setFendtradedate(null);
                t_supplier.setFlasttradedate(null);
                t_supplier.setFcashdiscount("");
                t_supplier.setFcurrencyid(0);
                t_supplier.setFmaxdealamount(0.0);
                t_supplier.setFminforereceiverate(0.0);
                t_supplier.setFminreserverate(0.0);
                t_supplier.setFmaxforepayamount(0.0);
                t_supplier.setFmaxforepayrate(0.0);
                t_supplier.setFdebtlevel(1);
                t_supplier.setFcreditdays(1);
                t_supplier.setFvalueaddrate(new BigDecimal(StringUtil.strToNum(resultSet.getString("tax_rto"))));
                t_supplier.setFpaytaxacctid(0);
                t_supplier.setFdiscount(new BigDecimal(0));
                t_supplier.setFtypeid(0);
                t_supplier.setFcreditamount(new BigDecimal(0));
                t_supplier.setFcreditlevel("");
                t_supplier.setFstockidassignee(0);
                t_supplier.setFbr(0);
                t_supplier.setFregmark("");
                t_supplier.setFlicandpermit(false);
                t_supplier.setFlicence("");
                t_supplier.setFpaperperiod(null);
                t_supplier.setFalarmperiod(null);
                t_supplier.setFotheraracctid(0);
                t_supplier.setFotherapacctid(0);
                t_supplier.setFprearacctid(0);
                t_supplier.setFhelpcode("");
                t_supplier.setFmodifytime(null);
                t_supplier.setFcreditdegree(0);
                t_supplier.setFrightuserid("");
                t_supplier.setFpaymenttime(0);
                t_supplier.setFsmsphonenumber("");
                t_supplier.setFfullname("");
                t_supplier.setFacctid(null);
                t_Supplier2Mapper.insert(t_supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取仓库资料
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sys_whs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_wh t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                t_Stock t_stock = new t_Stock();
                t_stock.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_stock.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                t_stock.setFhelpcode("");
                t_stock.setFempid(0);
                t_stock.setFaddress(StringUtil.getStr(resultSet.getString("shipping_id")));
                t_stock.setFphone("");
                t_stock.setFproperty(Short.parseShort(resultSet.getString("wh_property").equals("1") ? "12" : "10"));
                t_stock.setFbworkshop(0);
                t_stock.setFname(StringUtil.getStr(resultSet.getString("wh_name")));
                t_stock.setFnumber(StringUtil.getStr(resultSet.getString("thd_code")));
                t_stock.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))));
                t_stock.setFdeleted(Short.parseShort(StringUtil.getStr(resultSet.getString("is_stop"))));
                t_stock.setFshortnumber(StringUtil.getStr(resultSet.getString("thd_code")));
                t_stock.setFtypeid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_type"))));
                t_stock.setFisstockmgr(false);
                t_stock.setFspgroupid(0);
                t_stock.setFmrpavail(false);
                t_stock.setFgroupid(0);
                t_stock.setFstockgroupid(0);
                t_stock.setFmodifytime(null);
                t_stock.setFcalccostorder(0);
                t_stock.setFplanarea(0);
                t_stock.setFrightuserid("");
                t_stock.setFsmsphonenumber("");
                t_stock2Mapper.insert(t_stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取销售发货单
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sal_outs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sal_out t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno(StringUtil.getStr(resultSet.getString("brh_id")));
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                icstockbill.setFtrantype(Short.parseShort(resultSet.getString("bil_type")));
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_type")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_id"))));
                icstockbill.setFscstockid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_id"))));
                icstockbill.setFdeptid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                icstockbill.setFempid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("salm_id"))));
                icstockbill.setFsupplyid(null);
                icstockbill.setFposterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cls_user_id"))));
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_id"))));
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("user_id"))));
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted(Short.parseShort(StringUtils.isEmpty(resultSet.getString("cls_user_id")) ? "0" : "1"));
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(0);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus(Short.parseShort(resultSet.getString("bil_status")));
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(0);
                icstockbill.setFbilltypeid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("bil_type"))));
                icstockbill.setFpostyle(null);
                icstockbill.setFmultichecklevel1(null);
                icstockbill.setFmultichecklevel2(null);
                icstockbill.setFmultichecklevel3(null);
                icstockbill.setFmultichecklevel4(null);
                icstockbill.setFmultichecklevel5(null);
                icstockbill.setFmultichecklevel6(null);
                icstockbill.setFmulticheckdate1(null);
                icstockbill.setFmulticheckdate2(null);
                icstockbill.setFmulticheckdate3(null);
                icstockbill.setFmulticheckdate4(null);
                icstockbill.setFmulticheckdate5(null);
                icstockbill.setFmulticheckdate6(null);
                icstockbill.setFcurchecklevel(null);
                icstockbill.setFtaskid(null);
                icstockbill.setFresourceid(null);
                icstockbill.setFbackflushed(false);
                icstockbill.setFwbinterid(0);
                icstockbill.setFtranstatus(0);
                icstockbill.setFzpbillinterid(null);
                icstockbill.setFrelatebrid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("brh_id"))));
                icstockbill.setFpurposeid(0);
                icstockbill.setFuuid(UUID.randomUUID().toString());
                icstockbill.setFrelateinvoiceid(0);
                icstockbill.setFoperdate(null);
                icstockbill.setFimport(1);
                icstockbill.setFsystemtype(1);
                icstockbill.setFmarketingstyle(0);
                icstockbill.setFpaybillid(0);
                icstockbill.setFcheckdate(DateUtil.StringToDate1(resultSet.getString("chk_date")));
                icstockbill.setFexplanation("");
                icstockbill.setFfetchadd("");
                icstockbill.setFfetchdate(null);
                icstockbill.setFmanagerid(0);
                icstockbill.setFreftype(0);
                icstockbill.setFseltrantype(0);
                icstockbill.setFchildren(0);
                icstockbill.setFhookstatus((short) 0);
                icstockbill.setFactpricevchtplid(0);
                icstockbill.setFplanpricevchtplid(0);
                icstockbill.setFprocid(0);
                icstockbill.setFactualvchtplid(0);
                icstockbill.setFplanvchtplid(0);
                icstockbill.setFbrid(null);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(null);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(null);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("");
                icstockbill2Mapper.insert(icstockbill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取销售退货单
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_afs_results(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_afs_result t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                icstockbill.setFtrantype((short) 0);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("created")));
                icstockbill.setFbillno("");
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo")));
                icstockbill.setFdcstockid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("back_wh"))));
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(null);
                icstockbill.setFposterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("operator"))));
                icstockbill.setFcheckerid(0);
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(0);
                icstockbill.setFreturnbillinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("regist_id"))));
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(0);
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(0);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 0);
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(0);
                icstockbill.setFbilltypeid(0);
                icstockbill.setFpostyle(null);
                icstockbill.setFmultichecklevel1(null);
                icstockbill.setFmultichecklevel2(null);
                icstockbill.setFmultichecklevel3(null);
                icstockbill.setFmultichecklevel4(null);
                icstockbill.setFmultichecklevel5(null);
                icstockbill.setFmultichecklevel6(null);
                icstockbill.setFmulticheckdate1(null);
                icstockbill.setFmulticheckdate2(null);
                icstockbill.setFmulticheckdate3(null);
                icstockbill.setFmulticheckdate4(null);
                icstockbill.setFmulticheckdate5(null);
                icstockbill.setFmulticheckdate6(null);
                icstockbill.setFcurchecklevel(null);
                icstockbill.setFtaskid(null);
                icstockbill.setFresourceid(null);
                icstockbill.setFbackflushed(false);
                icstockbill.setFwbinterid(0);
                icstockbill.setFtranstatus(0);
                icstockbill.setFzpbillinterid(null);
                icstockbill.setFrelatebrid(0);
                icstockbill.setFpurposeid(0);
                icstockbill.setFuuid(UUID.randomUUID().toString());
                icstockbill.setFrelateinvoiceid(0);
                icstockbill.setFoperdate(null);
                icstockbill.setFimport(1);
                icstockbill.setFsystemtype(1);
                icstockbill.setFmarketingstyle(0);
                icstockbill.setFpaybillid(0);
                icstockbill.setFcheckdate(null);
                icstockbill.setFexplanation("");
                icstockbill.setFfetchadd("");
                icstockbill.setFfetchdate(null);
                icstockbill.setFmanagerid(0);
                icstockbill.setFreftype(0);
                icstockbill.setFseltrantype(0);
                icstockbill.setFchildren(0);
                icstockbill.setFhookstatus((short) 0);
                icstockbill.setFactpricevchtplid(0);
                icstockbill.setFplanpricevchtplid(0);
                icstockbill.setFprocid(0);
                icstockbill.setFactualvchtplid(0);
                icstockbill.setFplanvchtplid(0);
                icstockbill.setFbrid(null);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(null);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(null);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("");
                icstockbill2Mapper.insert(icstockbill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取库存调拨
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_stk_moves(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_stk_move t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                icstockbill.setFtrantype((short) 0);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(0);
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(null);
                icstockbill.setFposterid(0);
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_in"))));
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("user_id"))));
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(0);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus(Short.parseShort(resultSet.getString("bil_status")));
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(0);
                icstockbill.setFbilltypeid(0);
                icstockbill.setFpostyle(null);
                icstockbill.setFmultichecklevel1(null);
                icstockbill.setFmultichecklevel2(null);
                icstockbill.setFmultichecklevel3(null);
                icstockbill.setFmultichecklevel4(null);
                icstockbill.setFmultichecklevel5(null);
                icstockbill.setFmultichecklevel6(null);
                icstockbill.setFmulticheckdate1(null);
                icstockbill.setFmulticheckdate2(null);
                icstockbill.setFmulticheckdate3(null);
                icstockbill.setFmulticheckdate4(null);
                icstockbill.setFmulticheckdate5(null);
                icstockbill.setFmulticheckdate6(null);
                icstockbill.setFcurchecklevel(null);
                icstockbill.setFtaskid(null);
                icstockbill.setFresourceid(null);
                icstockbill.setFbackflushed(false);
                icstockbill.setFwbinterid(0);
                icstockbill.setFtranstatus(0);
                icstockbill.setFzpbillinterid(null);
                icstockbill.setFrelatebrid(0);
                icstockbill.setFpurposeid(0);
                icstockbill.setFuuid(UUID.randomUUID().toString());
                icstockbill.setFrelateinvoiceid(0);
                icstockbill.setFoperdate(null);
                icstockbill.setFimport(1);
                icstockbill.setFsystemtype(1);
                icstockbill.setFmarketingstyle(0);
                icstockbill.setFpaybillid(0);
                icstockbill.setFcheckdate(null);
                icstockbill.setFexplanation("");
                icstockbill.setFfetchadd("");
                icstockbill.setFfetchdate(null);
                icstockbill.setFmanagerid(0);
                icstockbill.setFreftype(0);
                icstockbill.setFseltrantype(0);
                icstockbill.setFchildren(0);
                icstockbill.setFhookstatus((short) 0);
                icstockbill.setFactpricevchtplid(0);
                icstockbill.setFplanpricevchtplid(0);
                icstockbill.setFprocid(0);
                icstockbill.setFactualvchtplid(0);
                icstockbill.setFplanvchtplid(0);
                icstockbill.setFbrid(null);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(null);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(null);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("");
                icstockbill2Mapper.insert(icstockbill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取采购入库单
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_pur_ins(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_pur_in t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                icstockbill.setFtrantype((short) 0);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_id"))));
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                icstockbill.setFempid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("salm_id"))));
                icstockbill.setFsupplyid(0);
                icstockbill.setFposterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cls_user_id"))));
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_id"))));
                icstockbill.setFfmanagerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("qc_user_id"))));
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("user_id"))));
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("branch_id"))));
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus(Short.parseShort(resultSet.getString("bil_status")));
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(0);
                icstockbill.setFbilltypeid(0);
                icstockbill.setFpostyle(null);
                icstockbill.setFmultichecklevel1(null);
                icstockbill.setFmultichecklevel2(null);
                icstockbill.setFmultichecklevel3(null);
                icstockbill.setFmultichecklevel4(null);
                icstockbill.setFmultichecklevel5(null);
                icstockbill.setFmultichecklevel6(null);
                icstockbill.setFmulticheckdate1(null);
                icstockbill.setFmulticheckdate2(null);
                icstockbill.setFmulticheckdate3(null);
                icstockbill.setFmulticheckdate4(null);
                icstockbill.setFmulticheckdate5(null);
                icstockbill.setFmulticheckdate6(null);
                icstockbill.setFcurchecklevel(null);
                icstockbill.setFtaskid(null);
                icstockbill.setFresourceid(null);
                icstockbill.setFbackflushed(false);
                icstockbill.setFwbinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("plan_no"))));
                icstockbill.setFtranstatus(0);
                icstockbill.setFzpbillinterid(null);
                icstockbill.setFrelatebrid(0);
                icstockbill.setFpurposeid(0);
                icstockbill.setFuuid(UUID.randomUUID().toString());
                icstockbill.setFrelateinvoiceid(0);
                icstockbill.setFoperdate(null);
                icstockbill.setFimport(1);
                icstockbill.setFsystemtype(1);
                icstockbill.setFmarketingstyle(0);
                icstockbill.setFpaybillid(0);
                icstockbill.setFcheckdate(DateUtil.StringToDate1(resultSet.getString("chk_date")));
                icstockbill.setFexplanation("");
                icstockbill.setFfetchadd("");
                icstockbill.setFfetchdate(null);
                icstockbill.setFmanagerid(0);
                icstockbill.setFreftype(0);
                icstockbill.setFseltrantype(0);
                icstockbill.setFchildren(0);
                icstockbill.setFhookstatus((short) 0);
                icstockbill.setFactpricevchtplid(0);
                icstockbill.setFplanpricevchtplid(0);
                icstockbill.setFprocid(0);
                icstockbill.setFactualvchtplid(0);
                icstockbill.setFplanvchtplid(0);
                icstockbill.setFbrid(null);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(null);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(null);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("");
                icstockbill2Mapper.insert(icstockbill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取采购入库单退回单
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_pur_backs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_pur_back t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                icstockbill.setFtrantype((short) 0);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_id"))));
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                icstockbill.setFempid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("salm_id"))));
                icstockbill.setFsupplyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cust_id"))));
                icstockbill.setFposterid(0);
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_id"))));
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("user_id"))));
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(0);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus(Short.parseShort(resultSet.getString("bil_status")));
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("src_no"))));
                icstockbill.setFbilltypeid(0);
                icstockbill.setFpostyle(null);
                icstockbill.setFmultichecklevel1(null);
                icstockbill.setFmultichecklevel2(null);
                icstockbill.setFmultichecklevel3(null);
                icstockbill.setFmultichecklevel4(null);
                icstockbill.setFmultichecklevel5(null);
                icstockbill.setFmultichecklevel6(null);
                icstockbill.setFmulticheckdate1(null);
                icstockbill.setFmulticheckdate2(null);
                icstockbill.setFmulticheckdate3(null);
                icstockbill.setFmulticheckdate4(null);
                icstockbill.setFmulticheckdate5(null);
                icstockbill.setFmulticheckdate6(null);
                icstockbill.setFcurchecklevel(null);
                icstockbill.setFtaskid(null);
                icstockbill.setFresourceid(null);
                icstockbill.setFbackflushed(false);
                icstockbill.setFwbinterid(0);
                icstockbill.setFtranstatus(0);
                icstockbill.setFzpbillinterid(null);
                icstockbill.setFrelatebrid(0);
                icstockbill.setFpurposeid(0);
                icstockbill.setFuuid(UUID.randomUUID().toString());
                icstockbill.setFrelateinvoiceid(0);
                icstockbill.setFoperdate(null);
                icstockbill.setFimport(1);
                icstockbill.setFsystemtype(1);
                icstockbill.setFmarketingstyle(0);
                icstockbill.setFpaybillid(0);
                icstockbill.setFcheckdate(DateUtil.StringToDate1(resultSet.getString("chk_date")));
                icstockbill.setFexplanation("");
                icstockbill.setFfetchadd("");
                icstockbill.setFfetchdate(null);
                icstockbill.setFmanagerid(0);
                icstockbill.setFreftype(0);
                icstockbill.setFseltrantype(0);
                icstockbill.setFchildren(0);
                icstockbill.setFhookstatus((short) 0);
                icstockbill.setFactpricevchtplid(0);
                icstockbill.setFplanpricevchtplid(0);
                icstockbill.setFprocid(0);
                icstockbill.setFactualvchtplid(0);
                icstockbill.setFplanvchtplid(0);
                icstockbill.setFbrid(null);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(null);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(null);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("");
                icstockbill2Mapper.insert(icstockbill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }

    /**
     * 获取客户资料表
     * @param startTime
     * @return
     */
    public boolean getEcs_erp_sys_sites(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_site t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                t_Organization t_organization = new t_Organization();
                t_organization.setFaccount(StringUtil.getStr(resultSet.getString("bank_id")));
                t_organization.setFaddracct("");
                t_organization.setFaddress(StringUtil.getStr(resultSet.getString("site_area")));
                t_organization.setFapaccountid(0);
                t_organization.setFaraccountid(0);
                t_organization.setFbank("");
                t_organization.setFbanknumber("");
                t_organization.setFbegintradedate(null);
                t_organization.setFboundattr(null);
                t_organization.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                t_organization.setFcarryingaos(0);
                t_organization.setFcashdiscount("");
                t_organization.setFciqnumber("");
                t_organization.setFcity("");
                t_organization.setFcontact("");
                t_organization.setFcontactacct("");
                t_organization.setFcorperate("");
                t_organization.setFcountry("");
                t_organization.setFcreditlevel(0);
                t_organization.setFcreditlimit("");
                t_organization.setFcreditperiod(0);
                t_organization.setFcurrencyid(0);
                t_organization.setFcyid(null);
                t_organization.setFdebtlevel(0);
                t_organization.setFdeleted(Short.parseShort(StringUtil.strToNum(resultSet.getString("is_stop"))));
                t_organization.setFdepartment(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                t_organization.setFemail("");
                t_organization.setFemailacct("");
                t_organization.setFemployee(Integer.parseInt(StringUtil.strToNum(resultSet.getString("salm_id"))));
                t_organization.setFendtradedate(null);
                t_organization.setFerpclsid(null);
                t_organization.setFfavorpolicy("");
                t_organization.setFfax("");
                t_organization.setFfaxacct("");
                t_organization.setFhomepage("");
                t_organization.setFiscreditmgr(false);
                t_organization.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_organization.setFlanguageid(null);
                t_organization.setFlastreceivedate(null);
                t_organization.setFlastrpamount(new BigDecimal(0));
                t_organization.setFlasttradeamount(new BigDecimal(0));
                t_organization.setFlasttradedate(null);
                t_organization.setFlegalperson("");
                t_organization.setFmaxdealamount(0.0);
                t_organization.setFmaxdebitdate(0.0);
                t_organization.setFminforereceiverate(0.0);
                t_organization.setFminpovalue(0.0);
                t_organization.setFminreserverate(0.0);
                t_organization.setFmodifytime(null);
                t_organization.setFname("");
                t_organization.setFnumber(StringUtil.getStr(resultSet.getString("merchand_id")));
                t_organization.setFoperid(null);
                t_organization.setFparentid(0);
                t_organization.setFpaytaxacctid(0);
                t_organization.setFphone("");
                t_organization.setFphoneacct("");
                t_organization.setFpogroupid(null);
                t_organization.setFpostalcode("");
                t_organization.setFpreacctid(0);
                t_organization.setFpriceclsid(null);
                t_organization.setFpriorityid(null);
                t_organization.setFprovince("");
                t_organization.setFregionid(null);
                t_organization.setFsalemode(0);
                t_organization.setFsetdlineid(null);
                t_organization.setFsetid(null);
                t_organization.setFshortname("");
                t_organization.setFshortnumber("");
                t_organization.setFstatus(null);
                t_organization.setFtax(0f);
                t_organization.setFtaxid("");
                t_organization.setFtaxnum("");
                t_organization.setFtrade(null);
                t_organization.setFvalueaddrate(new BigDecimal(0));
                t_organization.setFzipacct("");
                t_organization.setFtypeid(0);
                t_organization.setFstockidassign(0);
                t_organization.setFstockidinst(0);
                t_organization.setFlicandpermit(false);
                t_organization.setFotheraracctid(0);
                t_organization.setFotherapacctid(0);
                t_organization.setFpreapacctid(0);
                t_organization.setFcreditdegree(0);
                t_organization.setFpaymenttime(0);
                t_organization.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                t_organization.setFmatchsupplyid(0);
                t_organization.setFwdhsecurity("");
                t_organization.setFlogoid("");
                t_organization.setFismbdata(false);
                t_organization.setFintent(false);
                t_organization.setFmark(false);
                t_Organization2Mapper.insert(t_organization);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return true;
    }
}
