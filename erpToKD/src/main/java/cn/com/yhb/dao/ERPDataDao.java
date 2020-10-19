package cn.com.yhb.dao;

import cn.com.yhb.Utils.StringUtil;
import cn.com.yhb.config.SSHConnection;
import cn.com.yhb.entity.t_ICItem;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ERPDataDao {

    private SSHConnection sshConnection;

    private Connection connection;

    private Statement st;

    private static String sql = "";

    private ResultSet resultSet;

    /**
     * 获取商品资料
     * @param startTime
     * @return
     */
    public List<t_ICItem> getEcs_erp_sys_prdts(String startTime) {
        List<t_ICItem> icItems = new ArrayList<>();
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_prdt t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                t_ICItem t_icItem = new t_ICItem();
                t_icItem.setFitemid(Integer.parseInt(StringUtil.strToNum(resultSet.getString("id"))));
                t_icItem.setFname(resultSet.getString("prdt_name"));
                t_icItem.setFhelpcode("");
                t_icItem.setFdeleted(Short.parseShort(StringUtil.strToNum(resultSet.getString("is_stop"))));
                t_icItem.setFshortnumber(resultSet.getString("prdt_code"));
                t_icItem.setFnumber(resultSet.getString("prdt_code"));
                t_icItem.setFmodifytime(resultSet.getString("modified").getBytes());
                t_icItem.setFparentid(0);
                t_icItem.setFbrno("0");
                t_icItem.setFtopid(0);
                t_icItem.setFrp(null);
                t_icItem.setFomortize(null);
                t_icItem.setFomortizescale(null);
                t_icItem.setFforsale(false);
                t_icItem.setFstacost(null);
                t_icItem.setForderprice(Double.valueOf(StringUtil.strToNum(resultSet.getString("up_ret"))));
                t_icItem.setFordermethod(null);
                t_icItem.setFpricefixingtype(0);
                t_icItem.setFsalepricefixingtype(0);
                t_icItem.setFperwastage(0.0);
                t_icItem.setFaracctid(null);
                t_icItem.setFplanpricemethod(null);
                t_icItem.setFplanclass(null);
                t_icItem.setFmodel(resultSet.getString("spc"));
                t_icItem.setFitemdescription(null);
                t_icItem.setFalias(null);
                t_icItem.setFapproveno(null);
                t_icItem.setFauxclassid(0);
                t_icItem.setFdefaultloc(0);
                t_icItem.setFequipmentnum(null);
                t_icItem.setFerpclsid(1);
                t_icItem.setFfullname(resultSet.getString("prdt_name"));
                t_icItem.setFhighlimit(new BigDecimal(StringUtil.strToNum(resultSet.getString("most_qty"))));
                t_icItem.setFisequipment(false);
                t_icItem.setFissparepart(false);
                t_icItem.setFlowlimit(new BigDecimal(StringUtil.strToNum(resultSet.getString("least_qty"))));
                t_icItem.setForderunitid(0);
                t_icItem.setFpredeadline(null);
                t_icItem.setFproductunitid(0);
                t_icItem.setFqtydecimal(Short.parseShort("4"));
                t_icItem.setFsaleunitid(0);
                t_icItem.setFseccoefficient(new BigDecimal(0));
                t_icItem.setFsecunitdecimal(0);
                t_icItem.setFsecinv(new BigDecimal(StringUtil.strToNum(resultSet.getString("qty_warn"))));
                t_icItem.setFsecunitid(0);
                t_icItem.setFserialclassid(0);
                t_icItem.setFsource(0);
                t_icItem.setFspid(0);
                t_icItem.setFstoreunitid(0);
                t_icItem.setFtypeid(null);
                t_icItem.setFunitgroupid(0);
                t_icItem.setFunitid(0);
                t_icItem.setFusestate(341);
                t_icItem.setFabccls(null);
                t_icItem.setFacctid(1024);
                t_icItem.setFbatchmanager(false);
                t_icItem.setFbatchqty(null);
                t_icItem.setFbeforeexpire(null);
                t_icItem.setFbookplan(null);
                t_icItem.setFcheckcycle(null);
                t_icItem.setFcheckcycunit(null);
                t_icItem.setFclass(false);
                t_icItem.setFcostacctid(0);
                t_icItem.setFcostdiffrate(null);
                t_icItem.setFcostproject(0);
                t_icItem.setFdaysper(null);
                t_icItem.setFdepartment(Integer.parseInt(StringUtil.strToNum(resultSet.getString("dept_id"))));
                t_icItem.setFgoodspec(0);
                t_icItem.setFiskfperiod(false);
                t_icItem.setFissale(false);
                t_icItem.setFissnmanage(null);
                t_icItem.setFisspecialtax(null);
                t_icItem.setFkfperiod(new BigDecimal(0));
                t_icItem.setFlastcheckdate(null);
                t_icItem.setFnote(null);
                t_icItem.setFoihighlimit(new BigDecimal(100));
                t_icItem.setFoilowlimit(new BigDecimal(100));
                t_icItem.setForderrector(0);
                t_icItem.setFplanprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("declare_value"))));
                t_icItem.setFpohghprcmnytype(1);
                t_icItem.setFpohighprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_pur"))));
                t_icItem.setFprofitrate(new BigDecimal(0));
                t_icItem.setFsaleacctid(null);
                t_icItem.setFsaleprice(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_ret"))));
                t_icItem.setFsaletaxacctid(null);
                t_icItem.setFsohighlimit(new BigDecimal(100));
                t_icItem.setFsolowlimit(new BigDecimal(100));
                t_icItem.setFsolowprc(new BigDecimal(StringUtil.strToNum(resultSet.getString("up_min"))));
                t_icItem.setFsolowprcmnytype(1);
                t_icItem.setFstocktime(false);
                t_icItem.setFtaxrate(13);
                t_icItem.setFtrack(76);
                t_icItem.setFwwhghprc(new BigDecimal(0));
                t_icItem.setFwwhghprcmnytype(1);
                t_icItem.setFcbbmstandardid(0);
                t_icItem.setFbatchangeeconomy(new BigDecimal(1));
                t_icItem.setFbatchappendqty(null);
                t_icItem.setFbatfixeconomy(new BigDecimal(1));
                t_icItem.setFcuunitid(0);
                t_icItem.setFdailyconsume(null);
                t_icItem.setFdefaultroutingid(1);
                t_icItem.setFdefaultworktypeid(0);
                t_icItem.setFfixleadtime(0f);
                t_icItem.setFinhighlimit(new BigDecimal(0));
                t_icItem.setFinlowlimit(new BigDecimal(0));
                t_icItem.setFleadtime(0f);
                t_icItem.setFlowestbomcode(null);
                t_icItem.setFmrpcon(true);
                t_icItem.setForderinterval(1);
                t_icItem.setForderpoint(new BigDecimal(1));
                t_icItem.setFordertrategy(331);
                t_icItem.setFplanner(null);
                t_icItem.setFplanpoint(1);
                t_icItem.setFplantrategy(321);
                t_icItem.setFproductprincipal(0);
                t_icItem.setFputinteger(false);
                t_icItem.setFqtymax(new BigDecimal(10000));
                t_icItem.setFqtymin(new BigDecimal(1));
                t_icItem.setFrequirepoint(1);
                t_icItem.setFtotaltqq(1);
                t_icItem.setFmrporder(false);
                t_icItem.setFbatchcreate(false);
                t_icItem.setFchartnumber(null);
                t_icItem.setFcubicmeasure(0);
                t_icItem.setFgrossweight(new BigDecimal(StringUtil.strToNum(resultSet.getString("fac_weight"))));
                t_icItem.setFheight(new BigDecimal(StringUtil.strToNum(resultSet.getString("height"))));
                t_icItem.setFiskeyitem(false);
                t_icItem.setFlength(new BigDecimal(StringUtil.strToNum(resultSet.getString("length"))));
                t_icItem.setFmaund(0);
                t_icItem.setFnetweight(new BigDecimal(StringUtil.strToNum(resultSet.getString("weight"))));
                t_icItem.setFsize(new BigDecimal(StringUtil.strToNum(resultSet.getString("volume"))));
                t_icItem.setFversion(null);
                t_icItem.setFwidth(new BigDecimal(StringUtil.strToNum(resultSet.getString("width"))));
                t_icItem.setFchgfeerate(new BigDecimal(0));
                t_icItem.setFoutmachfee(new BigDecimal(0));
                t_icItem.setFpiecerate(new BigDecimal(0));
                t_icItem.setFstandardcost(new BigDecimal(0));
                t_icItem.setFstandardmanhour(new BigDecimal(0));
                t_icItem.setFstdfixfeerate(new BigDecimal(0));
                t_icItem.setFstdpayrate(new BigDecimal(0));
                t_icItem.setFidentifier(0);
                t_icItem.setFinspectionlevel(352);
                t_icItem.setFinspectionproject(0);
                t_icItem.setFislistcontrol(null);
                t_icItem.setFotherchkmde(null);
                t_icItem.setFprochkmde(null);
                t_icItem.setFsochkmde(null);
                t_icItem.setFstkchkalrm(0);
                t_icItem.setFstkchkmde(null);
                t_icItem.setFstkchkprd(9999);
                t_icItem.setFwthdrwchkmde(null);
                t_icItem.setFwwchkmde(null);
                icItems.add(t_icItem);
//                for (int i = 0; i < metaData.getColumnCount(); i++) {
//                    // resultSet数据下标从1开始
//                    System.out.print(resultSet.getString(i + 1) + "\t");
//                }
//                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return icItems;
    }

    /**
     * 获取供应商资料
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_sys_custs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_cust t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取仓库资料
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_sys_whs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_wh t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取销售发货单
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_sal_outs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sal_out t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取销售退货单
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_afs_results(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_afs_result t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取库存调拨
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_stk_moves(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_stk_move t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取采购入库单
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_pur_ins(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_pur_in t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取采购入库单退回单
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_pur_backs(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_pur_back t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }

    /**
     * 获取客户资料表
     * @param startTime
     * @return
     */
    public List<Map<String, Object>> getEcs_erp_sys_sites(String startTime) {
        sshConnection = new SSHConnection();
        connection = sshConnection.getConnection();
        try {
            st = connection.createStatement();
            sql = "select * from ecs_erp_sys_site t where t.created >= '" + startTime + "'";
            resultSet = sshConnection.runSql(sql, st);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                // resultSet数据下标从1开始
                String columnName = metaData.getColumnName(i + 1);
                int type = metaData.getColumnType(i + 1);
                if (Types.INTEGER == type) {
                    // int
                } else if (Types.VARCHAR == type) {
                    // String
                }
            }
            while (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    // resultSet数据下标从1开始
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sshConnection.closeConn(connection, st);
        }
        return null;
    }
}
