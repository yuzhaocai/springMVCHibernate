package com.class8.bean;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class Pageable implements Serializable {
	
	private static final long serialVersionUID = -5705750233282723792L;
	
	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_SIZE = 10;
	public static final String ASC = "ASC";
	public static final String DESC = "DESC";
	
	private int page = DEFAULT_PAGE;
	private int size = DEFAULT_SIZE;
	private String sort;
	private String order;
	
	public Pageable(){
	}
	
	public Pageable(int page, int size) {
		this(page, size, null);
	}
	
	public Pageable(int page, int size, String sort){
		this(page, size, sort, null);
	}
	
	public Pageable(int page, int size, String sort, String order){
		this.page = page < 0 ? DEFAULT_PAGE : page;
		this.size = size < 0 ? DEFAULT_SIZE : size;
		if(!StringUtils.isEmpty(sort)){
			this.sort = sort;
			if(StringUtils.isEmpty(order) || (!Pageable.ASC.equalsIgnoreCase(order) && !Pageable.DESC.equalsIgnoreCase(order))){
				this.order = Pageable.ASC;
			} else {
				this.order = order;
			}
		}
	}

	public int getPageSize() {
		return size;
	}

	public int getPageNumber() {
		return page;
	}
	
	public int getOffset() {
		return (page - 1) * size;
	}
	
	public String getSort(){
		return sort;
	}
	
	public String getOrder(){
		return order;
	}
	
}
