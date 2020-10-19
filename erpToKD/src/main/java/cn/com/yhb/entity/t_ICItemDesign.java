package cn.com.yhb.entity;

import java.math.BigDecimal;

public class t_ICItemDesign {
    private Integer fitemid;

    private String fchartnumber;

    private Boolean fiskeyitem;

    private Integer fmaund;

    private BigDecimal fgrossweight;

    private BigDecimal fnetweight;

    private Integer fcubicmeasure;

    private BigDecimal flength;

    private BigDecimal fwidth;

    private BigDecimal fheight;

    private BigDecimal fsize;

    private String fversion;

    public Integer getFitemid() {
        return fitemid;
    }

    public void setFitemid(Integer fitemid) {
        this.fitemid = fitemid;
    }

    public String getFchartnumber() {
        return fchartnumber;
    }

    public void setFchartnumber(String fchartnumber) {
        this.fchartnumber = fchartnumber == null ? null : fchartnumber.trim();
    }

    public Boolean getFiskeyitem() {
        return fiskeyitem;
    }

    public void setFiskeyitem(Boolean fiskeyitem) {
        this.fiskeyitem = fiskeyitem;
    }

    public Integer getFmaund() {
        return fmaund;
    }

    public void setFmaund(Integer fmaund) {
        this.fmaund = fmaund;
    }

    public BigDecimal getFgrossweight() {
        return fgrossweight;
    }

    public void setFgrossweight(BigDecimal fgrossweight) {
        this.fgrossweight = fgrossweight;
    }

    public BigDecimal getFnetweight() {
        return fnetweight;
    }

    public void setFnetweight(BigDecimal fnetweight) {
        this.fnetweight = fnetweight;
    }

    public Integer getFcubicmeasure() {
        return fcubicmeasure;
    }

    public void setFcubicmeasure(Integer fcubicmeasure) {
        this.fcubicmeasure = fcubicmeasure;
    }

    public BigDecimal getFlength() {
        return flength;
    }

    public void setFlength(BigDecimal flength) {
        this.flength = flength;
    }

    public BigDecimal getFwidth() {
        return fwidth;
    }

    public void setFwidth(BigDecimal fwidth) {
        this.fwidth = fwidth;
    }

    public BigDecimal getFheight() {
        return fheight;
    }

    public void setFheight(BigDecimal fheight) {
        this.fheight = fheight;
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
}