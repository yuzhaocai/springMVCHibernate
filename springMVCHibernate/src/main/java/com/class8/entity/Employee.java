package com.class8.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083373042113922153L;
	
	private Integer id;
	private String name;
	private String role;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
