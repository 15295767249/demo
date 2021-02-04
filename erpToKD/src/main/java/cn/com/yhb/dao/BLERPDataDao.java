package cn.com.yhb.dao;

import cn.com.yhb.Utils.DateUtil;
import cn.com.yhb.Utils.StringUtil;
import cn.com.yhb.config.SSHConnection;
import cn.com.yhb.ds2.mapper.*;
import cn.com.yhb.ds3.mapper.*;
import cn.com.yhb.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.UUID;

@Component
public class BLERPDataDao {

    private SSHConnection sshConnection;

    private Connection connection;

    private Statement st;

    private static String sql = "";

    private ResultSet resultSet;

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
    ICStockBillEntry2Mapper icStockBillEntry2Mapper;

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
            while (resultSet.next()) {
                String id = "500" + StringUtil.strToNum(resultSet.getString("id"));
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(id));
                t_item.setFitemclassid(4);
                t_item.setFexternid(-1);
//                t_item.setFnumber(StringUtil.getStr(resultSet.getString("prdt_type")));
                t_item.setFnumber(StringUtil.getStr(resultSet.getString("prdt_type_full")));
                t_item.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))) == 0 ? 0 : Integer.parseInt("500" + StringUtil.strToNum(resultSet.getString("parent_id"))));
                Integer level = StringUtil.getStrNum(StringUtil.getStr(resultSet.getString("prdt_type_full")), "\\.") + 1;
                t_item.setFlevel(Short.parseShort(String.valueOf(level)));
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
                String id1 = "600" + StringUtil.strToNum(resultSet.getString("id"));
                t_item.setFitemid(Integer.parseInt(id1));
                t_item.setFitemclassid(2001);
                t_item.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))) == 0 ? 0 : Integer.parseInt("600" + StringUtil.strToNum(resultSet.getString("parent_id"))));
                t_item.setUuid(UUID.randomUUID().toString());
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
    public boolean getEcs_erp_sys_prdts(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select t.*,t1.prdt_type_full,t1.parent_id,t1.prdt_type from ecs_erp_sys_prdt t LEFT JOIN ecs_erp_sys_prdt_type t1 ON t.prdt_type_id = t1.id where t.created >= '" + startTime + "' ";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                String id = "400" + StringUtil.strToNum(resultSet.getString("id"));
                //先添加物料数据主表
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(id));
                t_item.setFitemclassid(4);
                t_item.setFexternid(-1);
                String number = StringUtil.getStr(resultSet.getString("prdt_code"));
                //根据prdt_type_id查询商品类型，并将编码拼接
                String prdt_type_full = resultSet.getString("prdt_type_full");
                if (!StringUtils.isEmpty(prdt_type_full)) {
                    number = prdt_type_full + "." + number;
                }
                t_item.setFnumber(number);
                t_item.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))) == 0 ? 0 : Integer.parseInt("500" + StringUtil.strToNum(resultSet.getString("parent_id"))));
                Integer level = StringUtil.getStrNum(StringUtil.getStr(resultSet.getString("prdt_type_full")), "\\.") + 2;
                t_item.setFlevel(Short.parseShort(String.valueOf(level)));
                t_item.setFdetail(true);
                t_item.setFname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_item.setFunused(false);
                t_item.setFbrno("0");
                t_item.setFfullnumber(number);
                t_item.setFdiff(false);
                t_item.setFdeleted((short) 0);
                t_item.setFshortnumber(StringUtil.getStr(resultSet.getString("prdt_code")));
                t_item.setFfullname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_item.setUuid(UUID.randomUUID().toString());
                t_item.setFgrcommonid(-1);
                t_item.setFsystemtype(1);
                t_item.setFusesign(0);
                t_item.setFchkuserid((short) 0);
                t_item.setFgrcontrol(-1);
                t_item.setFrightuserid(null);
                t_item.setFonsale(0);
                t_item2Mapper.insert(t_item);

                t_ICItemCore t_icItemCore = new t_ICItemCore();
                t_icItemCore.setFitemid(Integer.parseInt(id));
                String f_model = "";
                if (!StringUtils.isEmpty(StringUtil.getStr(resultSet.getString("spc")))) {
                    f_model = StringUtil.getStr(resultSet.getString("spc"));
                }
                if (!StringUtils.isEmpty(StringUtil.getStr(resultSet.getString("spc"))) && !StringUtils.isEmpty(StringUtil.getStr(resultSet.getString("properties_name")))) {
                    f_model += "_";
                }
                if (!StringUtils.isEmpty(StringUtil.getStr(resultSet.getString("properties_name")))) {
                    f_model += StringUtil.getStr(resultSet.getString("properties_name"));
                }
                t_icItemCore.setFmodel(f_model);
                t_icItemCore.setFname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_icItemCore.setFhelpcode("");
                t_icItemCore.setFdeleted(Short.parseShort(StringUtil.strToNum(resultSet.getString("is_stop"))));
                t_icItemCore.setFnumber(number);
                t_icItemCore.setFshortnumber(StringUtil.getStr(resultSet.getString("prdt_code")));
                t_icItemCore.setFmodifytime(resultSet.getString("modified").getBytes());
                t_icItemCore.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))) == 0 ? 0 : Integer.parseInt("500" + StringUtil.strToNum(resultSet.getString("parent_id"))));
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
                t_icItemBase.setFitemid(Integer.parseInt(id));
                t_icItemBase.setFerpclsid(1);
                t_icItemBase.setFunitid(276);
                t_icItemBase.setFunitgroupid(275);
                t_icItemBase.setFdefaultloc(274);
                t_icItemBase.setFspid(0);
                t_icItemBase.setFsource(0);
                t_icItemBase.setFqtydecimal(Short.parseShort("4"));
                t_icItemBase.setFlowlimit(new BigDecimal(StringUtil.strToNum(resultSet.getString("least_qty"))));
                t_icItemBase.setFhighlimit(new BigDecimal(1000));
                t_icItemBase.setFsecinv(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_warn"))));
                t_icItemBase.setFusestate(341);
                t_icItemBase.setFisequipment(false);
                t_icItemBase.setFequipmentnum(null);
                t_icItemBase.setFissparepart(false);
                t_icItemBase.setFfullname(StringUtil.getStr(resultSet.getString("prdt_name")));
                t_icItemBase.setFsecunitid(0);
                t_icItemBase.setFseccoefficient(new BigDecimal(0));
                t_icItemBase.setFsecunitdecimal(0);
                t_icItemBase.setFalias(null);
                t_icItemBase.setForderunitid(276);
                t_icItemBase.setFsaleunitid(276);
                t_icItemBase.setFstoreunitid(276);
                t_icItemBase.setFproductunitid(276);
                t_icItemBase.setFapproveno(null);
                t_icItemBase.setFauxclassid(0);
                t_icItemBase.setFtypeid(null);
                t_icItemBase.setFpredeadline(null);
                t_icItemBase.setFserialclassid(0);
                t_icItemBase2Mapper.insert(t_icItemBase);

                t_ICItemMaterial t_iCItemMaterial = new t_ICItemMaterial();
                t_iCItemMaterial.setFitemid(Integer.parseInt(id));
                t_iCItemMaterial.setForderrector(0);
                t_iCItemMaterial.setFpohghprcmnytype(1);
                t_iCItemMaterial.setFpohighprice(new BigDecimal(0));
                t_iCItemMaterial.setFwwhghprc(new BigDecimal(0));
                t_iCItemMaterial.setFwwhghprcmnytype(1);
                t_iCItemMaterial.setFsolowprc(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_min"))));
                t_iCItemMaterial.setFsolowprcmnytype(1);
                t_iCItemMaterial.setFissale(false);
                t_iCItemMaterial.setFprofitrate(new BigDecimal(0));
                t_iCItemMaterial.setFsaleprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_ret"))));
                t_iCItemMaterial.setFbatchmanager(false);
                t_iCItemMaterial.setFiskfperiod(false);
                t_iCItemMaterial.setFkfperiod(new BigDecimal(0));
                t_iCItemMaterial.setFtrack(76);
                t_iCItemMaterial.setFplanprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("declare_value"))));
                t_iCItemMaterial.setFpricedecimal(Short.parseShort("2"));
                t_iCItemMaterial.setFacctid(1029);
                t_iCItemMaterial.setFsaleacctid(1193);
                t_iCItemMaterial.setFcostacctid(1152);
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
                t_icItemPlan.setFitemid(Integer.parseInt(id));
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
                t_icItemPlan.setFdefaultroutingid(1);
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
                t_icItemDesign.setFitemid(Integer.parseInt(id));
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
                t_icItemStandard.setFitemid(Integer.parseInt(id));
                t_icItemStandard.setFstandardcost(new BigDecimal(0));
                t_icItemStandard.setFstandardmanhour(new BigDecimal(0));
                t_icItemStandard.setFstdpayrate(new BigDecimal(0));
                t_icItemStandard.setFchgfeerate(new BigDecimal(0));
                t_icItemStandard.setFstdfixfeerate(new BigDecimal(0));
                t_icItemStandard.setFoutmachfee(new BigDecimal(0));
                t_icItemStandard.setFpiecerate(new BigDecimal(0));
                t_icItemStandard2Mapper.insert(t_icItemStandard);

                t_ICItemQuality t_icItemQuality = new t_ICItemQuality();
                t_icItemQuality.setFitemid(Integer.parseInt(id));
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
                t_icItemCustom.setFitemid(Integer.parseInt(id));
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
    public boolean getEcs_erp_sys_custs(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_cust t where t.created >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                String id = "100" + StringUtil.strToNum(resultSet.getString("id"));
                //先添加物料数据主表
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(id));
                t_item.setFitemclassid(8);
                t_item.setFexternid(-1);
                t_item.setFnumber(StringUtil.strToNum(id));
                t_item.setFparentid(0);
                t_item.setFlevel(Short.parseShort("1"));
                t_item.setFdetail(true);
                t_item.setFname(StringUtil.getStr(resultSet.getString("cust_name")));
                t_item.setFunused(false);
                t_item.setFbrno("0");
                t_item.setFfullnumber(StringUtil.getStr(id));
                t_item.setFdiff(false);
                t_item.setFdeleted((short) 0);
                t_item.setFshortnumber(StringUtil.getStr(id));
                t_item.setFfullname(StringUtil.getStr(resultSet.getString("cust_name")));
                t_item.setUuid(UUID.randomUUID().toString());
                t_item.setFgrcommonid(-1);
                t_item.setFsystemtype(1);
                t_item.setFusesign(0);
                t_item.setFchkuserid((short) 0);
                t_item.setFgrcontrol(-1);
                t_item.setFrightuserid(null);
                t_item.setFonsale(0);
                t_item2Mapper.insert(t_item);

                t_Supplier t_supplier = new t_Supplier();
                t_supplier.setFitemid(Integer.parseInt(id));
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
                t_supplier.setFregionid(0);
                t_supplier.setFtrade(0);
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
                t_supplier.setFsalemode((short)1057);
                t_supplier.setFname(StringUtil.getStr(resultSet.getString("cust_name")));
                t_supplier.setFnumber(StringUtil.getStr(id));
                t_supplier.setFparentid(0);
                t_supplier.setFshortnumber(StringUtil.getStr(id));
                t_supplier.setFaraccountid(0);
                t_supplier.setFapaccountid(0);
                t_supplier.setFpreacctid(0);
                t_supplier.setFlasttradeamount(new BigDecimal(0));
                t_supplier.setFlastrpamount(new BigDecimal(0));
                t_supplier.setFfavorpolicy("");
                t_supplier.setFdepartment(Integer.parseInt(StringUtil.strToNum(resultSet.getString("brh_id"))));
                t_supplier.setFemployee(0);
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
                t_supplier.setFdebtlevel(0);
                t_supplier.setFcreditdays(0);
                t_supplier.setFvalueaddrate(new BigDecimal(StringUtil.strToNum(resultSet.getString("tax_rto"))));
                t_supplier.setFpaytaxacctid(0);
                t_supplier.setFdiscount(new BigDecimal(0));
                t_supplier.setFtypeid(0);
                t_supplier.setFcreditamount(new BigDecimal(0));
                t_supplier.setFcreditlevel("");
                t_supplier.setFstockidassignee(0);
                t_supplier.setFbr(0);
                t_supplier.setFregmark("");
                t_supplier.setFlicandpermit(true);
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
                t_supplier.setFfullname(StringUtil.getStr(resultSet.getString("cust_name")));
                t_supplier.setFacctid(0);
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
    public boolean getEcs_erp_sys_whs(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_wh t where t.created >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                String id = "300" + StringUtil.strToNum(resultSet.getString("id"));
                //先添加物料数据主表
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(id));
                t_item.setFitemclassid(5);
                t_item.setFexternid(-1);
                t_item.setFnumber(StringUtil.strToNum(id));
                t_item.setFparentid(0);
                t_item.setFlevel(Short.parseShort("1"));
                t_item.setFdetail(true);
                t_item.setFname(StringUtil.getStr(resultSet.getString("wh_name")));
                t_item.setFunused(false);
                t_item.setFbrno("0");
                t_item.setFfullnumber(StringUtil.getStr(id));
                t_item.setFdiff(false);
                t_item.setFdeleted((short) 0);
                t_item.setFshortnumber(StringUtil.getStr(id));
                t_item.setFfullname(StringUtil.getStr(resultSet.getString("wh_name")));
                t_item.setUuid(UUID.randomUUID().toString());
                t_item.setFgrcommonid(-1);
                t_item.setFsystemtype(1);
                t_item.setFusesign(0);
                t_item.setFchkuserid((short) 0);
                t_item.setFgrcontrol(-1);
                t_item.setFrightuserid(null);
                t_item.setFonsale(0);
                t_item2Mapper.insert(t_item);

                t_Stock t_stock = new t_Stock();
                t_stock.setFitemid(Integer.parseInt(id));
                t_stock.setFbrno(StringUtil.getStr(resultSet.getString("branch_id")));
                t_stock.setFhelpcode("");
                t_stock.setFempid(0);
                t_stock.setFaddress(StringUtil.getStr(resultSet.getString("shipping_id")));
                t_stock.setFphone("");
                t_stock.setFproperty(Short.parseShort(resultSet.getString("wh_property").equals("1") ? "12" : "10"));
                t_stock.setFbworkshop(0);
                t_stock.setFname(StringUtil.getStr(resultSet.getString("wh_name")));
                t_stock.setFnumber(StringUtil.getStr(resultSet.getString("wh_code")));
                t_stock.setFparentid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("parent_id"))));
                t_stock.setFdeleted(Short.parseShort(StringUtil.getStr(resultSet.getString("is_stop"))));
                t_stock.setFshortnumber(StringUtil.getStr(resultSet.getString("wh_code")));
                t_stock.setFtypeid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("wh_type"))));
                t_stock.setFisstockmgr(false);
                t_stock.setFspgroupid(0);
                t_stock.setFmrpavail(true);
                t_stock.setFgroupid(270);
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
    public boolean getEcs_erp_sal_outs(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select b.id as FInterID,b.prdt_id,b.qty,b.up_cst,b.memo_info,t.* from ecs_erp_stk_dec t ";
            sql += "left join ecs_erp_stk_dec_details b on t.id = b.parent_id ";
            sql += "where t.bil_status = 4 and t.branch_id = 2 and t.chk_date >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.chk_date <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                ICStockBillEntry icStockBillEntry = new ICStockBillEntry();
                icStockBillEntry.setFbrno("0");
                icStockBillEntry.setFinterid(Integer.parseInt("700" + StringUtil.strToNum(resultSet.getString("FInterID"))));
                icStockBillEntry.setFentryid(1);
                icStockBillEntry.setFitemid(Integer.parseInt(StringUtil.strToNum("400" + StringUtil.getStr(resultSet.getString("prdt_id")))));
                icStockBillEntry.setFqtymust(new BigDecimal(0));
                icStockBillEntry.setFqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFprice(new BigDecimal(0));
                icStockBillEntry.setFbatchno("");
                icStockBillEntry.setFamount(new BigDecimal(0));
                icStockBillEntry.setFnote("");
                icStockBillEntry.setFscbillinterid(null);
                icStockBillEntry.setFscbillno(null);
                icStockBillEntry.setFunitid(276);
                icStockBillEntry.setFauxprice(new BigDecimal(0));
                icStockBillEntry.setFauxqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFauxqtymust(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFqtyactual(new BigDecimal(0));
                icStockBillEntry.setFauxqtyactual(new BigDecimal(0));
                icStockBillEntry.setFplanprice(new BigDecimal(0));
                icStockBillEntry.setFauxplanprice(new BigDecimal(0));
                icStockBillEntry.setFsourceentryid(0);
                icStockBillEntry.setFcommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxcommitqty(new BigDecimal(0));
                icStockBillEntry.setFkfdate(null);
                icStockBillEntry.setFkfperiod(0);
                icStockBillEntry.setFdcspid(0);
                icStockBillEntry.setFscspid(null);
                icStockBillEntry.setFconsignprice(new BigDecimal(0));
                icStockBillEntry.setFconsignamount(new BigDecimal(0));
                icStockBillEntry.setFprocesscost(new BigDecimal(0));
                icStockBillEntry.setFmaterialcost(new BigDecimal(0));
                icStockBillEntry.setFtaxamount(new BigDecimal(0));
                icStockBillEntry.setFmapnumber("");
                icStockBillEntry.setFmapname("");
                icStockBillEntry.setForgbillentryid(0);
                icStockBillEntry.setFoperid(0);
                icStockBillEntry.setFplanamount(new BigDecimal(0));
                icStockBillEntry.setFprocessprice(new BigDecimal(0));
                icStockBillEntry.setFtaxrate(new BigDecimal(0));
                icStockBillEntry.setFsnlistid(0);
                icStockBillEntry.setFamtref(new BigDecimal(0));
                icStockBillEntry.setFauxpropid(0);
                icStockBillEntry.setFcost(new BigDecimal(0));
                icStockBillEntry.setFpriceref(new BigDecimal(0));
                icStockBillEntry.setFauxpriceref(new BigDecimal(0));
                icStockBillEntry.setFfetchdate(null);
                icStockBillEntry.setFqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFqtyinvoicebase(new BigDecimal(0));
                icStockBillEntry.setFunitcost(new BigDecimal(0));
                icStockBillEntry.setFseccoefficient(new BigDecimal(0));
                icStockBillEntry.setFsecqty(new BigDecimal(0));
                icStockBillEntry.setFseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFsourcetrantype(0);
                icStockBillEntry.setFsourceinterid(0);
                icStockBillEntry.setFsourcebillno("");
                icStockBillEntry.setFcontractinterid(0);
                icStockBillEntry.setFcontractentryid(0);
                icStockBillEntry.setFcontractbillno("");
                icStockBillEntry.setFicmobillno("");
                icStockBillEntry.setFicmointerid(0);
                icStockBillEntry.setFppbomentryid(0);
                icStockBillEntry.setForderinterid(0);
                icStockBillEntry.setForderentryid(0);
                icStockBillEntry.setForderbillno("");
                icStockBillEntry.setFallhookqty(new BigDecimal(0));
                icStockBillEntry.setFallhookamount(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookqty(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFstdallhookamount(new BigDecimal(0));
                icStockBillEntry.setFstdcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFscstockid(0);
                icStockBillEntry.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icStockBillEntry.setFperioddate(null);
                icStockBillEntry.setFcostobjgroupid(0);
                icStockBillEntry.setFcostobjid(0);
                icStockBillEntry.setFdetailid(null);
                icStockBillEntry.setFmaterialcostprice(new BigDecimal(0));
                icStockBillEntry.setFreproducetype(0);
                icStockBillEntry.setFbominterid(0);
                icStockBillEntry.setFdiscountrate(new BigDecimal(0));
                icStockBillEntry.setFdiscountamount(new BigDecimal(0));
                icStockBillEntry.setFsepcialsaleid(0);
                icStockBillEntry.setFoutcommitqty(new BigDecimal(0));
                icStockBillEntry.setFoutseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbcommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFopersn(0);
                icStockBillEntry.setFcheckstatus((short) 0);
                icStockBillEntry.setFsplitsecqty(null);
                icStockBillEntry.setFdvstockid(0);
                icStockBillEntry.setFhookinterid(null);
                icStockBillEntry.setFhookstatus(null);
                icStockBillEntry.setFafbillno(null);
                icStockBillEntry.setFmointerid(0);
                icStockBillEntry.setFmoentryid(0);
                icStockBillEntry.setFmobillno("");
                icStockBillEntry.setFcustitemno("");
                icStockBillEntry.setFcustitemname("");
                icStockBillEntry.setFindex(1);
                icStockBillEntry2Mapper.insert(icStockBillEntry);

                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("0");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum("700" + resultSet.getString("FInterID"))));
                icstockbill.setFtrantype((short) 21);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("created")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFscstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(209);//销售：对应客户
                icstockbill.setFposterid(0);
                icstockbill.setFcheckerid(16394);
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(16394);//生产同步前应查询相关表（t_User）
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(0);
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(null);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 1);
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
                icstockbill.setFmarketingstyle(12530);
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
                icstockbill.setFbrid(0);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(0);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(0);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("120");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("0");
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
    public boolean getEcs_erp_afs_results(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select b.id as FInterID,b.prdt_id,b.qty_actual,b.amt_actual,t.*,r.site_id from ecs_erp_afs_result t ";
            sql += "left join ecs_erp_afs_back_prdt b on t.regist_id = b.regist_id ";
            sql += "left join ecs_erp_afs_regist r on t.regist_id = r.id ";
            sql += "where t.created >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                ICStockBillEntry icStockBillEntry = new ICStockBillEntry();
                icStockBillEntry.setFbrno("0");
                icStockBillEntry.setFinterid(Integer.parseInt(StringUtil.strToNum("701" + resultSet.getString("FInterID"))));
                icStockBillEntry.setFentryid(1);
                icStockBillEntry.setFitemid(Integer.parseInt(StringUtil.strToNum("400" + resultSet.getString("prdt_id"))));
                icStockBillEntry.setFqtymust(new BigDecimal(0));
                icStockBillEntry.setFqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_actual"))));
                icStockBillEntry.setFprice(new BigDecimal(0));
                icStockBillEntry.setFbatchno("");
                icStockBillEntry.setFamount(new BigDecimal(0));
                icStockBillEntry.setFnote("");
                icStockBillEntry.setFscbillinterid(null);
                icStockBillEntry.setFscbillno(null);
                icStockBillEntry.setFunitid(276);
                icStockBillEntry.setFauxprice(new BigDecimal(0));
                icStockBillEntry.setFauxqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_actual"))));
                icStockBillEntry.setFauxqtymust(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_actual"))));
                icStockBillEntry.setFqtyactual(new BigDecimal(0));
                icStockBillEntry.setFauxqtyactual(new BigDecimal(0));
                icStockBillEntry.setFplanprice(new BigDecimal(0));
                icStockBillEntry.setFauxplanprice(new BigDecimal(0));
                icStockBillEntry.setFsourceentryid(0);
                icStockBillEntry.setFcommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxcommitqty(new BigDecimal(0));
                icStockBillEntry.setFkfdate(null);
                icStockBillEntry.setFkfperiod(0);
                icStockBillEntry.setFdcspid(0);
                icStockBillEntry.setFscspid(null);
                icStockBillEntry.setFconsignprice(new BigDecimal(0));
                icStockBillEntry.setFconsignamount(new BigDecimal(0));
                icStockBillEntry.setFprocesscost(new BigDecimal(0));
                icStockBillEntry.setFmaterialcost(new BigDecimal(0));
                icStockBillEntry.setFtaxamount(new BigDecimal(0));
                icStockBillEntry.setFmapnumber("");
                icStockBillEntry.setFmapname("");
                icStockBillEntry.setForgbillentryid(0);
                icStockBillEntry.setFoperid(0);
                icStockBillEntry.setFplanamount(new BigDecimal(0));
                icStockBillEntry.setFprocessprice(new BigDecimal(0));
                icStockBillEntry.setFtaxrate(new BigDecimal(0));
                icStockBillEntry.setFsnlistid(0);
                icStockBillEntry.setFamtref(new BigDecimal(0));
                icStockBillEntry.setFauxpropid(0);
                icStockBillEntry.setFcost(new BigDecimal(0));
                icStockBillEntry.setFpriceref(new BigDecimal(0));
                icStockBillEntry.setFauxpriceref(new BigDecimal(0));
                icStockBillEntry.setFfetchdate(null);
                icStockBillEntry.setFqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFqtyinvoicebase(new BigDecimal(0));
                icStockBillEntry.setFunitcost(new BigDecimal(0));
                icStockBillEntry.setFseccoefficient(new BigDecimal(0));
                icStockBillEntry.setFsecqty(new BigDecimal(0));
                icStockBillEntry.setFseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFsourcetrantype(0);
                icStockBillEntry.setFsourceinterid(0);
                icStockBillEntry.setFsourcebillno("");
                icStockBillEntry.setFcontractinterid(0);
                icStockBillEntry.setFcontractentryid(0);
                icStockBillEntry.setFcontractbillno("");
                icStockBillEntry.setFicmobillno("");
                icStockBillEntry.setFicmointerid(0);
                icStockBillEntry.setFppbomentryid(0);
                icStockBillEntry.setForderinterid(0);
                icStockBillEntry.setForderentryid(0);
                icStockBillEntry.setForderbillno("");
                icStockBillEntry.setFallhookqty(new BigDecimal(0));
                icStockBillEntry.setFallhookamount(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookqty(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFstdallhookamount(new BigDecimal(0));
                icStockBillEntry.setFstdcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFscstockid(0);
                icStockBillEntry.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icStockBillEntry.setFperioddate(null);
                icStockBillEntry.setFcostobjgroupid(0);
                icStockBillEntry.setFcostobjid(0);
                icStockBillEntry.setFdetailid(null);
                icStockBillEntry.setFmaterialcostprice(new BigDecimal(0));
                icStockBillEntry.setFreproducetype(0);
                icStockBillEntry.setFbominterid(0);
                icStockBillEntry.setFdiscountrate(new BigDecimal(0));
                icStockBillEntry.setFdiscountamount(new BigDecimal(0));
                icStockBillEntry.setFsepcialsaleid(0);
                icStockBillEntry.setFoutcommitqty(new BigDecimal(0));
                icStockBillEntry.setFoutseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbcommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFopersn(0);
                icStockBillEntry.setFcheckstatus((short) 0);
                icStockBillEntry.setFsplitsecqty(null);
                icStockBillEntry.setFdvstockid(0);
                icStockBillEntry.setFhookinterid(null);
                icStockBillEntry.setFhookstatus(null);
                icStockBillEntry.setFafbillno(null);
                icStockBillEntry.setFmointerid(0);
                icStockBillEntry.setFmoentryid(0);
                icStockBillEntry.setFmobillno("");
                icStockBillEntry.setFcustitemno("");
                icStockBillEntry.setFcustitemname("");
                icStockBillEntry.setFindex(1);
                icStockBillEntry2Mapper.insert(icStockBillEntry);

                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("0");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum("701" + resultSet.getString("FInterID"))));
                icstockbill.setFtrantype((short) 21);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("created")));
                icstockbill.setFbillno("");
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo")));
                icstockbill.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(209);//销售：对应客户
                icstockbill.setFposterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("operator"))));
                icstockbill.setFcheckerid(16394);
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(16394);//生产同步前应查询相关表（t_User）
                icstockbill.setFreturnbillinterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("regist_id"))));
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(0);
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(null);
                icstockbill.setFrob((short) -1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 1);
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
                icstockbill.setFmarketingstyle(12530);
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
                icstockbill.setFbrid(0);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(0);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(0);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("120");
                icstockbill.setFrejected(0);
                icstockbill.setFrejectednote("");
                icstockbill.setFrejectedtime(null);
                icstockbill.setFwlnumber("");
                icstockbill.setFwlcompany("0");
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
    public boolean getEcs_erp_stk_moves(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select b.id as FInterID,b.prdt_id,b.qty_in,t.* from ecs_erp_stk_move t ";
            sql += "left join ecs_erp_stk_move_details b on t.id = b.parent_id ";
            sql += "where t.created >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                ICStockBillEntry icStockBillEntry = new ICStockBillEntry();
                icStockBillEntry.setFbrno("0");
                icStockBillEntry.setFinterid(Integer.parseInt(StringUtil.strToNum("702" + resultSet.getString("FInterID"))));
                icStockBillEntry.setFentryid(1);
                icStockBillEntry.setFitemid(Integer.parseInt(StringUtil.strToNum("400" + resultSet.getString("prdt_id"))));
                icStockBillEntry.setFqtymust(new BigDecimal(0));
                icStockBillEntry.setFqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_in"))));
                icStockBillEntry.setFprice(new BigDecimal(0));
                icStockBillEntry.setFbatchno("");
                icStockBillEntry.setFamount(new BigDecimal(0));
                icStockBillEntry.setFnote("");
                icStockBillEntry.setFscbillinterid(null);
                icStockBillEntry.setFscbillno(null);
                icStockBillEntry.setFunitid(276);
                icStockBillEntry.setFauxprice(new BigDecimal(0));
                icStockBillEntry.setFauxqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_in"))));
                icStockBillEntry.setFauxqtymust(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_in"))));
                icStockBillEntry.setFqtyactual(new BigDecimal(0));
                icStockBillEntry.setFauxqtyactual(new BigDecimal(0));
                icStockBillEntry.setFplanprice(new BigDecimal(0));
                icStockBillEntry.setFauxplanprice(new BigDecimal(0));
                icStockBillEntry.setFsourceentryid(0);
                icStockBillEntry.setFcommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxcommitqty(new BigDecimal(0));
                icStockBillEntry.setFkfdate(null);
                icStockBillEntry.setFkfperiod(0);
                icStockBillEntry.setFdcspid(0);
                icStockBillEntry.setFscspid(null);
                icStockBillEntry.setFconsignprice(new BigDecimal(0));
                icStockBillEntry.setFconsignamount(new BigDecimal(0));
                icStockBillEntry.setFprocesscost(new BigDecimal(0));
                icStockBillEntry.setFmaterialcost(new BigDecimal(0));
                icStockBillEntry.setFtaxamount(new BigDecimal(0));
                icStockBillEntry.setFmapnumber("");
                icStockBillEntry.setFmapname("");
                icStockBillEntry.setForgbillentryid(0);
                icStockBillEntry.setFoperid(0);
                icStockBillEntry.setFplanamount(new BigDecimal(0));
                icStockBillEntry.setFprocessprice(new BigDecimal(0));
                icStockBillEntry.setFtaxrate(new BigDecimal(0));
                icStockBillEntry.setFsnlistid(0);
                icStockBillEntry.setFamtref(new BigDecimal(0));
                icStockBillEntry.setFauxpropid(0);
                icStockBillEntry.setFcost(new BigDecimal(0));
                icStockBillEntry.setFpriceref(new BigDecimal(0));
                icStockBillEntry.setFauxpriceref(new BigDecimal(0));
                icStockBillEntry.setFfetchdate(null);
                icStockBillEntry.setFqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFqtyinvoicebase(new BigDecimal(0));
                icStockBillEntry.setFunitcost(new BigDecimal(0));
                icStockBillEntry.setFseccoefficient(new BigDecimal(0));
                icStockBillEntry.setFsecqty(new BigDecimal(0));
                icStockBillEntry.setFseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFsourcetrantype(0);
                icStockBillEntry.setFsourceinterid(0);
                icStockBillEntry.setFsourcebillno("");
                icStockBillEntry.setFcontractinterid(0);
                icStockBillEntry.setFcontractentryid(0);
                icStockBillEntry.setFcontractbillno("");
                icStockBillEntry.setFicmobillno("");
                icStockBillEntry.setFicmointerid(0);
                icStockBillEntry.setFppbomentryid(0);
                icStockBillEntry.setForderinterid(0);
                icStockBillEntry.setForderentryid(0);
                icStockBillEntry.setForderbillno("");
                icStockBillEntry.setFallhookqty(new BigDecimal(0));
                icStockBillEntry.setFallhookamount(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookqty(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFstdallhookamount(new BigDecimal(0));
                icStockBillEntry.setFstdcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFscstockid(0);
                icStockBillEntry.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icStockBillEntry.setFperioddate(null);
                icStockBillEntry.setFcostobjgroupid(0);
                icStockBillEntry.setFcostobjid(0);
                icStockBillEntry.setFdetailid(null);
                icStockBillEntry.setFmaterialcostprice(new BigDecimal(0));
                icStockBillEntry.setFreproducetype(0);
                icStockBillEntry.setFbominterid(0);
                icStockBillEntry.setFdiscountrate(new BigDecimal(0));
                icStockBillEntry.setFdiscountamount(new BigDecimal(0));
                icStockBillEntry.setFsepcialsaleid(0);
                icStockBillEntry.setFoutcommitqty(new BigDecimal(0));
                icStockBillEntry.setFoutseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbcommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFopersn(0);
                icStockBillEntry.setFcheckstatus((short) 0);
                icStockBillEntry.setFsplitsecqty(null);
                icStockBillEntry.setFdvstockid(0);
                icStockBillEntry.setFhookinterid(null);
                icStockBillEntry.setFhookstatus(null);
                icStockBillEntry.setFafbillno(null);
                icStockBillEntry.setFmointerid(0);
                icStockBillEntry.setFmoentryid(0);
                icStockBillEntry.setFmobillno("");
                icStockBillEntry.setFcustitemno("");
                icStockBillEntry.setFcustitemname("");
                icStockBillEntry.setFindex(1);
                icStockBillEntry2Mapper.insert(icStockBillEntry);

                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("0");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum("702" + resultSet.getString("FInterID"))));
                icstockbill.setFtrantype((short) 1);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFscstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(209);
                icstockbill.setFposterid(0);
                icstockbill.setFcheckerid(16394);
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(16394);//生产同步前应查询相关表（t_User）
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(null);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 1);
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
                icstockbill.setFmarketingstyle(20303);
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
                icstockbill.setFbrid(0);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(0);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(0);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("120");
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
    public boolean getEcs_erp_pur_ins(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select b.id as FInterID,b.prdt_id,b.qty,b.amt_tax,t.* from ecs_erp_pur_in t ";
            sql += "left join ecs_erp_pur_in_details b on t.id = b.parent_id ";
            sql += "where t.bil_status = 4 and t.branch_id = 2 and t.chk_date >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.chk_date <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                ICStockBillEntry icStockBillEntry = new ICStockBillEntry();
                icStockBillEntry.setFbrno("0");
                icStockBillEntry.setFinterid(Integer.parseInt(StringUtil.strToNum("703" + resultSet.getString("FInterID"))));
                icStockBillEntry.setFentryid(1);
                icStockBillEntry.setFitemid(Integer.parseInt(StringUtil.strToNum("400" + resultSet.getString("prdt_id"))));
                icStockBillEntry.setFqtymust(new BigDecimal(0));
                icStockBillEntry.setFqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFprice(new BigDecimal(0));
                icStockBillEntry.setFbatchno("");
                icStockBillEntry.setFamount(new BigDecimal(0));
                icStockBillEntry.setFnote("");
                icStockBillEntry.setFscbillinterid(null);
                icStockBillEntry.setFscbillno(null);
                icStockBillEntry.setFunitid(276);
                icStockBillEntry.setFauxprice(new BigDecimal(0));
                icStockBillEntry.setFauxqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFauxqtymust(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFqtyactual(new BigDecimal(0));
                icStockBillEntry.setFauxqtyactual(new BigDecimal(0));
                icStockBillEntry.setFplanprice(new BigDecimal(0));
                icStockBillEntry.setFauxplanprice(new BigDecimal(0));
                icStockBillEntry.setFsourceentryid(0);
                icStockBillEntry.setFcommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxcommitqty(new BigDecimal(0));
                icStockBillEntry.setFkfdate(null);
                icStockBillEntry.setFkfperiod(0);
                icStockBillEntry.setFdcspid(0);
                icStockBillEntry.setFscspid(null);
                icStockBillEntry.setFconsignprice(new BigDecimal(0));
                icStockBillEntry.setFconsignamount(new BigDecimal(0));
                icStockBillEntry.setFprocesscost(new BigDecimal(0));
                icStockBillEntry.setFmaterialcost(new BigDecimal(0));
                icStockBillEntry.setFtaxamount(new BigDecimal(0));
                icStockBillEntry.setFmapnumber("");
                icStockBillEntry.setFmapname("");
                icStockBillEntry.setForgbillentryid(0);
                icStockBillEntry.setFoperid(0);
                icStockBillEntry.setFplanamount(new BigDecimal(0));
                icStockBillEntry.setFprocessprice(new BigDecimal(0));
                icStockBillEntry.setFtaxrate(new BigDecimal(0));
                icStockBillEntry.setFsnlistid(0);
                icStockBillEntry.setFamtref(new BigDecimal(0));
                icStockBillEntry.setFauxpropid(0);
                icStockBillEntry.setFcost(new BigDecimal(0));
                icStockBillEntry.setFpriceref(new BigDecimal(0));
                icStockBillEntry.setFauxpriceref(new BigDecimal(0));
                icStockBillEntry.setFfetchdate(null);
                icStockBillEntry.setFqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFqtyinvoicebase(new BigDecimal(0));
                icStockBillEntry.setFunitcost(new BigDecimal(0));
                icStockBillEntry.setFseccoefficient(new BigDecimal(0));
                icStockBillEntry.setFsecqty(new BigDecimal(0));
                icStockBillEntry.setFseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFsourcetrantype(0);
                icStockBillEntry.setFsourceinterid(0);
                icStockBillEntry.setFsourcebillno("");
                icStockBillEntry.setFcontractinterid(0);
                icStockBillEntry.setFcontractentryid(0);
                icStockBillEntry.setFcontractbillno("");
                icStockBillEntry.setFicmobillno("");
                icStockBillEntry.setFicmointerid(0);
                icStockBillEntry.setFppbomentryid(0);
                icStockBillEntry.setForderinterid(0);
                icStockBillEntry.setForderentryid(0);
                icStockBillEntry.setForderbillno("");
                icStockBillEntry.setFallhookqty(new BigDecimal(0));
                icStockBillEntry.setFallhookamount(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookqty(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFstdallhookamount(new BigDecimal(0));
                icStockBillEntry.setFstdcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFscstockid(0);
                icStockBillEntry.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icStockBillEntry.setFperioddate(null);
                icStockBillEntry.setFcostobjgroupid(0);
                icStockBillEntry.setFcostobjid(0);
                icStockBillEntry.setFdetailid(null);
                icStockBillEntry.setFmaterialcostprice(new BigDecimal(0));
                icStockBillEntry.setFreproducetype(0);
                icStockBillEntry.setFbominterid(0);
                icStockBillEntry.setFdiscountrate(new BigDecimal(0));
                icStockBillEntry.setFdiscountamount(new BigDecimal(0));
                icStockBillEntry.setFsepcialsaleid(0);
                icStockBillEntry.setFoutcommitqty(new BigDecimal(0));
                icStockBillEntry.setFoutseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbcommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFopersn(0);
                icStockBillEntry.setFcheckstatus((short) 0);
                icStockBillEntry.setFsplitsecqty(null);
                icStockBillEntry.setFdvstockid(0);
                icStockBillEntry.setFhookinterid(null);
                icStockBillEntry.setFhookstatus(null);
                icStockBillEntry.setFafbillno(null);
                icStockBillEntry.setFmointerid(0);
                icStockBillEntry.setFmoentryid(0);
                icStockBillEntry.setFmobillno("");
                icStockBillEntry.setFcustitemno("");
                icStockBillEntry.setFcustitemname("");
                icStockBillEntry.setFindex(1);
                icStockBillEntry2Mapper.insert(icStockBillEntry);

                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("0");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum("703" + resultSet.getString("FInterID"))));
                icstockbill.setFtrantype((short) 1);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(Integer.parseInt("100" + StringUtil.strToNum(resultSet.getString("cust_id"))));//采购：对应供应商
                icstockbill.setFposterid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cls_user_id"))));
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_id"))));
                icstockbill.setFfmanagerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("qc_user_id"))));
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(16394);//生产同步前应查询相关表（t_User）
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(null);
                icstockbill.setFrob((short) 1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 1);
                icstockbill.setFupstockwhensave(false);
                icstockbill.setFcancellation(false);
                icstockbill.setForgbillinterid(0);
                icstockbill.setFbilltypeid(0);
                icstockbill.setFpostyle(252);
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
                icstockbill.setFmarketingstyle(12510);
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
                icstockbill.setFbrid(0);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(0);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(0);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("120");
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
    public boolean getEcs_erp_pur_backs(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select b.id as FInterID,b.prdt_id,b.qty,b.amt_tax,t.* from ecs_erp_pur_back t ";
            sql += "left join ecs_erp_pur_back_details b on t.id = b.parent_id ";
            sql += "where t.bil_status = 4 and t.branch_id = 2 and t.chk_date >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.chk_date <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                ICStockBillEntry icStockBillEntry = new ICStockBillEntry();
                icStockBillEntry.setFbrno("0");
                icStockBillEntry.setFinterid(Integer.parseInt(StringUtil.strToNum("704" + resultSet.getString("FInterID"))));
                icStockBillEntry.setFentryid(1);
                icStockBillEntry.setFitemid(Integer.parseInt(StringUtil.strToNum("400" + resultSet.getString("prdt_id"))));
                icStockBillEntry.setFqtymust(new BigDecimal(0));
                icStockBillEntry.setFqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFprice(new BigDecimal(0));
                icStockBillEntry.setFbatchno("");
                icStockBillEntry.setFamount(new BigDecimal(0));
                icStockBillEntry.setFnote("");
                icStockBillEntry.setFscbillinterid(null);
                icStockBillEntry.setFscbillno(null);
                icStockBillEntry.setFunitid(276);
                icStockBillEntry.setFauxprice(new BigDecimal(0));
                icStockBillEntry.setFauxqty(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFauxqtymust(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty"))));
                icStockBillEntry.setFqtyactual(new BigDecimal(0));
                icStockBillEntry.setFauxqtyactual(new BigDecimal(0));
                icStockBillEntry.setFplanprice(new BigDecimal(0));
                icStockBillEntry.setFauxplanprice(new BigDecimal(0));
                icStockBillEntry.setFsourceentryid(0);
                icStockBillEntry.setFcommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxcommitqty(new BigDecimal(0));
                icStockBillEntry.setFkfdate(null);
                icStockBillEntry.setFkfperiod(0);
                icStockBillEntry.setFdcspid(0);
                icStockBillEntry.setFscspid(null);
                icStockBillEntry.setFconsignprice(new BigDecimal(0));
                icStockBillEntry.setFconsignamount(new BigDecimal(0));
                icStockBillEntry.setFprocesscost(new BigDecimal(0));
                icStockBillEntry.setFmaterialcost(new BigDecimal(0));
                icStockBillEntry.setFtaxamount(new BigDecimal(0));
                icStockBillEntry.setFmapnumber("");
                icStockBillEntry.setFmapname("");
                icStockBillEntry.setForgbillentryid(0);
                icStockBillEntry.setFoperid(0);
                icStockBillEntry.setFplanamount(new BigDecimal(0));
                icStockBillEntry.setFprocessprice(new BigDecimal(0));
                icStockBillEntry.setFtaxrate(new BigDecimal(0));
                icStockBillEntry.setFsnlistid(0);
                icStockBillEntry.setFamtref(new BigDecimal(0));
                icStockBillEntry.setFauxpropid(0);
                icStockBillEntry.setFcost(new BigDecimal(0));
                icStockBillEntry.setFpriceref(new BigDecimal(0));
                icStockBillEntry.setFauxpriceref(new BigDecimal(0));
                icStockBillEntry.setFfetchdate(null);
                icStockBillEntry.setFqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFqtyinvoicebase(new BigDecimal(0));
                icStockBillEntry.setFunitcost(new BigDecimal(0));
                icStockBillEntry.setFseccoefficient(new BigDecimal(0));
                icStockBillEntry.setFsecqty(new BigDecimal(0));
                icStockBillEntry.setFseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFsourcetrantype(0);
                icStockBillEntry.setFsourceinterid(0);
                icStockBillEntry.setFsourcebillno("");
                icStockBillEntry.setFcontractinterid(0);
                icStockBillEntry.setFcontractentryid(0);
                icStockBillEntry.setFcontractbillno("");
                icStockBillEntry.setFicmobillno("");
                icStockBillEntry.setFicmointerid(0);
                icStockBillEntry.setFppbomentryid(0);
                icStockBillEntry.setForderinterid(0);
                icStockBillEntry.setForderentryid(0);
                icStockBillEntry.setForderbillno("");
                icStockBillEntry.setFallhookqty(new BigDecimal(0));
                icStockBillEntry.setFallhookamount(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookqty(new BigDecimal(0));
                icStockBillEntry.setFcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFstdallhookamount(new BigDecimal(0));
                icStockBillEntry.setFstdcurrenthookamount(new BigDecimal(0));
                icStockBillEntry.setFscstockid(0);
                icStockBillEntry.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icStockBillEntry.setFperioddate(null);
                icStockBillEntry.setFcostobjgroupid(0);
                icStockBillEntry.setFcostobjid(0);
                icStockBillEntry.setFdetailid(null);
                icStockBillEntry.setFmaterialcostprice(new BigDecimal(0));
                icStockBillEntry.setFreproducetype(0);
                icStockBillEntry.setFbominterid(0);
                icStockBillEntry.setFdiscountrate(new BigDecimal(0));
                icStockBillEntry.setFdiscountamount(new BigDecimal(0));
                icStockBillEntry.setFsepcialsaleid(0);
                icStockBillEntry.setFoutcommitqty(new BigDecimal(0));
                icStockBillEntry.setFoutseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbcommitqty(new BigDecimal(0));
                icStockBillEntry.setFdbseccommitqty(new BigDecimal(0));
                icStockBillEntry.setFauxqtyinvoice(new BigDecimal(0));
                icStockBillEntry.setFopersn(0);
                icStockBillEntry.setFcheckstatus((short) 0);
                icStockBillEntry.setFsplitsecqty(null);
                icStockBillEntry.setFdvstockid(0);
                icStockBillEntry.setFhookinterid(null);
                icStockBillEntry.setFhookstatus(null);
                icStockBillEntry.setFafbillno(null);
                icStockBillEntry.setFmointerid(0);
                icStockBillEntry.setFmoentryid(0);
                icStockBillEntry.setFmobillno("");
                icStockBillEntry.setFcustitemno("");
                icStockBillEntry.setFcustitemname("");
                icStockBillEntry.setFindex(1);
                icStockBillEntry2Mapper.insert(icStockBillEntry);

                icstockbill icstockbill = new icstockbill();
                icstockbill.setFbrno("0");
                icstockbill.setFinterid(Integer.parseInt(StringUtil.strToNum("704" + resultSet.getString("FInterID"))));
                icstockbill.setFtrantype((short) 1);
                icstockbill.setFdate(DateUtil.StringToDate1(resultSet.getString("bil_date")));
                icstockbill.setFbillno(StringUtil.getStr(resultSet.getString("bil_no")));
                icstockbill.setFuse("");
                icstockbill.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                icstockbill.setFdcstockid(274);//后期需修改为生产环境的仓库（贝利：内销仓，咿童：外销仓）
                icstockbill.setFscstockid(0);
                icstockbill.setFdeptid(0);
                icstockbill.setFempid(0);
                icstockbill.setFsupplyid(Integer.parseInt("100" + StringUtil.strToNum(resultSet.getString("cust_id"))));//采购：对应供应商
                icstockbill.setFposterid(0);
                icstockbill.setFcheckerid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("chk_user_id"))));
                icstockbill.setFfmanagerid(0);
                icstockbill.setFsmanagerid(0);
                icstockbill.setFbillerid(16394);//生产同步前应查询相关表（t_User）
                icstockbill.setFreturnbillinterid(0);
                icstockbill.setFscbillno("");
                icstockbill.setFhookinterid(0);
                icstockbill.setFvchinterid(0);
                icstockbill.setFposted((short) 0);
                icstockbill.setFcheckselect((short) 0);
                icstockbill.setFcurrencyid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("cur_id"))));
                icstockbill.setFsalestyle(0);
                icstockbill.setFacctid(null);
                icstockbill.setFrob((short) -1);
                icstockbill.setFrscbillno("");
                icstockbill.setFstatus((short) 1);
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
                icstockbill.setFmarketingstyle(12510);
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
                icstockbill.setFbrid(0);
                icstockbill.setFvipcardid(0);
                icstockbill.setFvipscore(new BigDecimal(0));
                icstockbill.setFholisticdiscountrate(new BigDecimal(0));
                icstockbill.setFposname("");
                icstockbill.setFworkshiftid(0);
                icstockbill.setFcussentacctid(0);
                icstockbill.setFzangucount(false);
                icstockbill.setFcustid(null);
                icstockbill.setFmoitemid(0);
                icstockbill.setFmounitid(null);
                icstockbill.setFmoauxqty(new BigDecimal(0));
                icstockbill.setFmobaseunitid(0);
                icstockbill.setFmoqty(new BigDecimal(0));
                icstockbill.setFbatchno("");
                icstockbill.setFmcustitemno("");
                icstockbill.setFmcustitemname("");
                icstockbill.setFreceiveaddr("");
                icstockbill.setFbillsource("120");
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
    public boolean getEcs_erp_sys_sites(String startTime, String endTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_site t where t.is_stop != 1 and t.created >= '" + startTime + "'";
            if (!StringUtils.isEmpty(endTime)) {
                sql += "and t.created <= '" + endTime + "' ";
            }
            resultSet = sshConnection.runSql(sql, st);
            while (resultSet.next()) {
                String id = "200" + StringUtil.strToNum(resultSet.getString("id"));
                //先添加物料数据主表
                t_Item t_item = new t_Item();
                t_item.setFitemid(Integer.parseInt(id));
                t_item.setFitemclassid(1);
                t_item.setFexternid(-1);
                t_item.setFnumber("HW." + StringUtil.strToNum(id));
                t_item.setFparentid(183);
                t_item.setFlevel(Short.parseShort("2"));
                t_item.setFdetail(true);
                t_item.setFname(StringUtil.getStr(resultSet.getString("site_name")));
                t_item.setFunused(false);
                t_item.setFbrno("0");
                t_item.setFfullnumber("HW." + StringUtil.getStr(id));
                t_item.setFdiff(false);
                t_item.setFdeleted((short) 0);
                t_item.setFshortnumber(StringUtil.getStr(id));
                t_item.setFfullname("海外_" + StringUtil.getStr(resultSet.getString("site_name")));
                t_item.setUuid(UUID.randomUUID().toString());
                t_item.setFgrcommonid(-1);
                t_item.setFsystemtype(1);
                t_item.setFusesign(0);
                t_item.setFchkuserid((short) 0);
                t_item.setFgrcontrol(-1);
                t_item.setFrightuserid(null);
                t_item.setFonsale(0);
                t_item2Mapper.insert(t_item);

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
                t_organization.setFitemid(Integer.parseInt(id));
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
                t_organization.setFname(StringUtil.getStr(resultSet.getString("site_name")));
                t_organization.setFnumber("HW." + StringUtil.getStr(resultSet.getString("merchand_id")));
                t_organization.setFoperid(null);
                t_organization.setFparentid(183);
                t_organization.setFpaytaxacctid(0);
                t_organization.setFphone("");
                t_organization.setFphoneacct("");
                t_organization.setFpogroupid(null);
                t_organization.setFpostalcode("");
                t_organization.setFpreacctid(0);
                t_organization.setFpriceclsid(null);
                t_organization.setFpriorityid(null);
                t_organization.setFprovince("");
                t_organization.setFregionid(0);
                t_organization.setFsalemode(1057);
                t_organization.setFsetdlineid(null);
                t_organization.setFsetid(null);
                t_organization.setFshortname(StringUtil.getStr(resultSet.getString("site_name")));
                t_organization.setFfullname("海外_" + StringUtil.getStr(resultSet.getString("site_name")));
                t_organization.setFshortnumber(StringUtil.getStr(resultSet.getString("merchand_id")));
                t_organization.setFstatus(1072);
                t_organization.setFtax(0f);
                t_organization.setFtaxid("");
                t_organization.setFtaxnum("");
                t_organization.setFtrade(0);
                t_organization.setFvalueaddrate(new BigDecimal(0));
                t_organization.setFzipacct("");
                t_organization.setFtypeid(0);
                t_organization.setFstockidassign(0);
                t_organization.setFstockidinst(0);
                t_organization.setFlicandpermit(true);
                t_organization.setFotheraracctid(0);
                t_organization.setFotherapacctid(0);
                t_organization.setFpreapacctid(0);
                t_organization.setFcreditdegree(0);
                t_organization.setFpaymenttime(0);
                t_organization.setFnote(StringUtil.getStr(resultSet.getString("memo_info")));
                t_organization.setFmatchsupplyid(0);
                t_organization.setFwdhsecurity("1");
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
