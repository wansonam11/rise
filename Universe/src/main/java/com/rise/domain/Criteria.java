package com.rise.domain;

public class Criteria {

	private int page;
	private int perPageNum;

public Criteria() {
	page = 1;
	perPageNum = 10;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getPerPageNum() {
	return perPageNum;
}

public void setPerPageNum(int perPageNum) {
	this.perPageNum = perPageNum;
}

public int getPageStart() {
	return (page - 1)* perPageNum;

}

@Override
public String toString() {
	return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
}


}
