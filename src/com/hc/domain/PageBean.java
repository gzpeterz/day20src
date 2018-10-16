package com.hc.domain;

import java.util.List;

public class PageBean {
	private int pageNum;
	private int numPerPage;
	private int totalCount;
	private int totalPageNum;
	private List<Customer> customers;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", numPerPage=" + numPerPage + ", totalCount=" + totalCount
				+ ", totalPageNum=" + totalPageNum + ", customers=" + customers + "]";
	}
}
