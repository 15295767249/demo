package cn.com.yhb.service.impl;

import cn.com.yhb.Utils.DateUtil;
import cn.com.yhb.config.SSHConnection;
import cn.com.yhb.dao.ERPDataDao;
import cn.com.yhb.ds2.mapper.*;
import cn.com.yhb.ds3.mapper.*;
import cn.com.yhb.entity.t_ICItem;
import cn.com.yhb.service.DataPushService;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class DataPushServiceImpl implements DataPushService {

    private SSHConnection conexionssh;

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
    t_ICItemBase2Mapper t_icItemBase2Mapper;
    @Autowired
    T_ICItemCore2Mapper t_icItemCore2Mapper;
    @Autowired
    T_ICItemCustom2Mapper t_icItemCustom2Mapper;
    @Autowired
    T_ICItemDesign2Mapper T_ICItemDesign2Mapper;
    @Autowired
    T_ICItemMaterial2Mapper t_icItemMaterial2Mapper;
    @Autowired
    T_ICItemPlan2Mapper t_icItemPlan2Mapper;
    @Autowired
    T_ICItemQuality2Mapper t_icItemQuality2Mapper;
    @Autowired
    T_ICItemStandard2Mapper t_icItemStandard2Mapper;


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
    T_ICItemBase3Mapper t_icItemBase3Mapper;
    @Autowired
    T_ICItemCore3Mapper t_icItemCore3Mapper;
    @Autowired
    T_ICItemCustom3Mapper t_icItemCustom3Mapper;
    @Autowired
    T_ICItemDesign3Mapper T_ICItemDesign3Mapper;
    @Autowired
    T_ICItemMaterial3Mapper t_icItemMaterial3Mapper;
    @Autowired
    T_ICItemPlan3Mapper t_icItemPlan3Mapper;
    @Autowired
    T_ICItemQuality3Mapper t_icItemQuality3Mapper;
    @Autowired
    T_ICItemStandard3Mapper t_icItemStandard3Mapper;

    @Autowired
    ERPDataDao erpDataDao;

    @Override
    public void weekDataTimer(String startTime) {
        conexionssh = new SSHConnection();
        Session session = conexionssh.SSHConnection();
        if (StringUtils.isEmpty(startTime)) {
            //上周开始时间（上周一）
            Date weekStartTime = DateUtil.lastMonday();
            startTime = DateUtil.utilString(weekStartTime);
            System.out.println(startTime);
        }
        System.out.println("获取商品资料======================");
        //获取erp商品资料列表
        erpDataDao.getEcs_erp_sys_prdts(startTime);

//        //商品类型
//        System.out.println("获取商品类别======================");
//        erpDataDao.getEcs_erp_sys_prdt_types(startTime);

        System.out.println("获取供应商资料======================");
        //获取erp供应商资料列表
        erpDataDao.getEcs_erp_sys_custs(startTime);

        System.out.println("获取仓库资料======================");
        //获取erp仓库资料
        erpDataDao.getEcs_erp_sys_whs(startTime);

        System.out.println("获取销售发货单======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_sal_outs(startTime);

        System.out.println("获取销售退货单======================");
        //获取erp销售订单确认退货表
        erpDataDao.getEcs_erp_afs_results(startTime);

        System.out.println("获取库存调拨======================");
        //获取erp库存调拨
        erpDataDao.getEcs_erp_stk_moves(startTime);

        System.out.println("获取采购入库单======================");
        //获取erp采购入库单
        erpDataDao.getEcs_erp_pur_ins(startTime);

        System.out.println("获取采购入库单退回单======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_pur_backs(startTime);

        System.out.println("获取客户资料表======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_sys_sites(startTime);

        conexionssh.closeSSH(session);
    }

    @Override
    public void monthDataTimer(String startTime) {
        conexionssh = new SSHConnection();
        Session session = conexionssh.SSHConnection();
        if (StringUtils.isEmpty(startTime)) {
            startTime = DateUtil.getUpMonthFirstTime();
            System.out.println(startTime);
        }
        System.out.println("获取商品资料======================");
        //获取erp商品资料列表
        erpDataDao.getEcs_erp_sys_prdts(startTime);

//        //商品类型
//        System.out.println("获取商品类别======================");
//        erpDataDao.getEcs_erp_sys_prdt_types(startTime);

        System.out.println("获取供应商资料======================");
        //获取erp供应商资料列表
        erpDataDao.getEcs_erp_sys_custs(startTime);

        System.out.println("获取仓库资料======================");
        //获取erp仓库资料
        erpDataDao.getEcs_erp_sys_whs(startTime);

        System.out.println("获取销售发货单======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_sal_outs(startTime);

        System.out.println("获取销售退货单======================");
        //获取erp销售订单确认退货表
        erpDataDao.getEcs_erp_afs_results(startTime);

        System.out.println("获取库存调拨======================");
        //获取erp库存调拨
        erpDataDao.getEcs_erp_stk_moves(startTime);

        System.out.println("获取采购入库单======================");
        //获取erp采购入库单
        erpDataDao.getEcs_erp_pur_ins(startTime);

        System.out.println("获取采购入库单退回单======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_pur_backs(startTime);

        System.out.println("获取客户资料表======================");
        //获取erp销售发货单
        erpDataDao.getEcs_erp_sys_sites(startTime);

        conexionssh.closeSSH(session);
    }
}
