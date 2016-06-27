package com.wang.ssm.po;

public class Score {
	private String kch;

	private Integer cj;

	private String kcm;

	private Integer xf;

	public String getKch() {
		return kch;
	}

	public void setKch(String kch) {
		this.kch = kch == null ? null : kch.trim();
	}

	public Integer getCj() {
		return cj;
	}

	public void setCj(Integer cj) {
		this.cj = cj;
	}

	public String getKcm() {
		return kcm;
	}

	public void setKcm(String kcm) {
		this.kcm = kcm == null ? null : kcm.trim();
	}

	public Integer getXf() {
		return xf;
	}

	public void setXf(Integer xf) {
		this.xf = xf;
	}

}
