package com.rise.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum=10;
	private Criteria cri;
	
	public PageMaker() {
		
	}
	public int getTotalcount() {
		return totalCount;
	}
	public void setTotalcount(int totalcount) {
		this.totalCount = totalcount;
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	private void calcData() {
		endPage = 
		   (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage-(displayPageNum-1);
		
		int tempEndPage = 
			(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
	
		if (endPage > tempEndPage) {
			endPage = tempEndPage;			
		}
		prev = (startPage==1) ? false : true;
		next = (endPage * cri.getPerPageNum() > totalCount) ? false: true;
	}
	
	public String makeQuery(int page) {		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uri.toUriString();
	}
	
	public String makeSearch(int page) {
		SearchCriteria scri = (SearchCriteria) cri;
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", scri.getSearchType())
				.queryParam("keyword", scri.getKeyword())
				.build();
		
		return uri.toUriString();
	}
	private String encoding(String keyword) {
		if(keyword==null || keyword.trim().length()==0) {
			return "";
		}try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch(UnsupportedEncodingException e) {
			return "";
		}

	}
}

