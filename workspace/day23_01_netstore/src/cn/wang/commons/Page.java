package cn.wang.commons;

import java.util.List;

import cn.wang.domain.Book;

public class Page {
	private List<Book> records;
	private int pageNum;
	private int totalPageNum;
	private int prePageNum;
	private int nextPageNum;

	private int pageSize = 3;
	private int totalRecordsNum;

	private int startIndex;

	private String url;

	public Page(int pageNum, int totalRecordsNum) {
		this.pageNum = pageNum;
		this.totalRecordsNum = totalRecordsNum;

		// 计算总页码
		totalPageNum = totalRecordsNum % pageSize == 0 ? totalRecordsNum
				/ pageSize : (totalRecordsNum / pageSize) + 1;
		// 计算开始记录的索引
		startIndex = (pageNum - 1) * pageSize;
	}

	public List<Book> getRecords() {
		return records;
	}

	public void setRecords(List<Book> records) {
		this.records = records;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPrePageNum() {
		prePageNum = pageNum - 1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		nextPageNum = pageNum + 1;
		if (nextPageNum > totalPageNum) {
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}

	public void setTotalRecordsNum(int totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
