package com.zkhw.common.vo;

import java.util.List;

public class PageInfos<T> {

	private long pageSize; //每页容量
	private long total; //记录总数
	private long pageCount; //总页数
	private long page; //当前页码
	private List<T> rows; //当前页面数据
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}	
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
