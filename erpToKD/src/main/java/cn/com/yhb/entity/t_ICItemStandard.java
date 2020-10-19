package cn.com.yhb.entity;

import java.math.BigDecimal;

public class t_ICItemStandard {
    private Integer fitemid;

    private BigDecimal fstandardcost;

    private BigDecimal fstandardmanhour;

    private BigDecimal fstdpayrate;

    private BigDecimal fchgfeerate;

    private BigDecimal fstdfixfeerate;

    private BigDecimal foutmachfee;

    private BigDecimal fpiecerate;

    public Integer getFitemid() {
        return fitemid;
    }

    public void setFitemid(Integer fitemid) {
        this.fitemid = fitemid;
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

    public BigDecimal getFstdpayrate() {
        return fstdpayrate;
    }

    public void setFstdpayrate(BigDecimal fstdpayrate) {
        this.fstdpayrate = fstdpayrate;
    }

    public BigDecimal getFchgfeerate() {
        return fchgfeerate;
    }

    public void setFchgfeerate(BigDecimal fchgfeerate) {
        this.fchgfeerate = fchgfeerate;
    }

    public BigDecimal getFstdfixfeerate() {
        return fstdfixfeerate;
    }

    public void setFstdfixfeerate(BigDecimal fstdfixfeerate) {
        this.fstdfixfeerate = fstdfixfeerate;
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
}