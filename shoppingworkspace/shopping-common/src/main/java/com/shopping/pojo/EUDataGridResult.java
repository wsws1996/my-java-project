package com.shopping.pojo;

import java.util.List;

public class EUDataGridResult {

	public EUDataGridResult(long total, @SuppressWarnings("rawtypes") List rows) {
		this.total = total;
		this.rows = rows;
	}

	private long total;
	@SuppressWarnings("rawtypes")
	private List rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	public void setRows(@SuppressWarnings("rawtypes") List rows) {
		this.rows = rows;
	}

}
