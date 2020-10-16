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
    ERPDataDao erpDataDao;

    @Override
    public void weekDataTimer(String startTime) {
        conexionssh = new SSHConnection();
        Session session = conexionssh.SSHConnection();
        if (StringUtils.isEmpty(startTime)) {
            //上周开始时间（上周一）
            Date weekStartTime = DateUtil.lastMonday();
            startTime = DateUtil.utilString(weekStartTime);
        }

        System.out.println("获取商品资料======================");
        //获取erp商品资料列表
        erpDataDao.getEcs_erp_sys_prdts(startTime);

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


        System.out.println("周定时器执行中======================");
        System.out.println("查询ds2=====================");
        List<t_ICItem> icItems_2 = t_ICItem2Mapper.findAll();
        System.out.println("查询ds3=====================");
        List<t_ICItem> icItems_3 = t_ICItem3Mapper.findAll();
        System.out.println("周定时器执行完毕=======================");

        conexionssh.closeSSH(session);
    }

    @Override
    public void monthDataTimer() {

    }
}
