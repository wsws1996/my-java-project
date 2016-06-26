package com.wang.ssm.po;

import java.util.Date;

public class Xsb {
    private String xh;

    private String xm;

    private Byte xb;

    private Date cssj;

    private String zy;

    private Integer zxf;

    private String bz;

    private byte[] zp;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Byte getXb() {
        return xb;
    }

    public void setXb(Byte xb) {
        this.xb = xb;
    }

    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    public Integer getZxf() {
        return zxf;
    }

    public void setZxf(Integer zxf) {
        this.zxf = zxf;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public byte[] getZp() {
        return zp;
    }

    public void setZp(byte[] zp) {
        this.zp = zp;
    }
}