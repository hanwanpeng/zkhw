package com.zkhw.common.vo;

import java.util.List;

/**
 * 封装需要分页返回的数据
 *
 */
public class PageData<T> {
	private long pageSize; //每页容量
	private long recordCount; //记录总数
	private long pageCount; //总页数
	private long pageNo; //当前页码
	private List<T> list; //当前页面数据
	
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
