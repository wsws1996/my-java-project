package com.wang.ssm.po;

public class Kcb {
    private String kch;

    private String kcm;

    private Integer kkxq;

    private Integer xs;

    private Integer xf;

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch == null ? null : kch.trim();
    }

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm == null ? null : kcm.trim();
    }

    public Integer getKkxq() {
        return kkxq;
    }

    public void setKkxq(Integer kkxq) {
        this.kkxq = kkxq;
    }

    public Integer getXs() {
        return xs;
    }

    public void setXs(Integer xs) {
        this.xs = xs;
    }

    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }
}