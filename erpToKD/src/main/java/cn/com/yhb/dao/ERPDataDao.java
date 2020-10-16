package cn.com.yhb.dao;

import cn.com.yhb.config.SSHConnection;
import cn.com.yhb.entity.t_ICItem;
import org.springframework.stereotype.Component;

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
                t_icItem.setFitemid(Integer.parseInt(resultSet.getString("id")));
                t_icItem.setFname(resultSet.getString("prdt_name"));
                t_icItem.setFhelpcode("");
                t_icItem.setFdeleted(Short.parseShort(resultSet.getString("is_stop")));
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
                t_icItem.setForderprice(Double.valueOf(resultSet.getString("up_ret")));
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
                t_icItem.setFhighlimit(new BigDecimal(resultSet.getString("most_qty")));
                t_icItem.setFisequipment(false);
                t_icItem.setFissparepart(false);
                t_icItem.setFlowlimit(new BigDecimal(resultSet.getString("least_qty")));
                t_icItem.setForderunitid(0);
                t_icItem.setFpredeadline(null);
                t_icItem.setFproductunitid(0);
                t_icItem.setFqtydecimal(Short.parseShort("4"));
                t_icItem.setFsaleunitid(0);
                t_icItem.setFseccoefficient(new BigDecimal(0));
                t_icItem.setFsecunitdecimal(0);
                t_icItem.setFsecinv(new BigDecimal(resultSet.getString("qty_warn")));
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
        return null;
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
