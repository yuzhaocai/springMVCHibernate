package com.class8.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.test.annotation.Timed;

@Entity
@Table(name="person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7426497430330376553L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firset_name",nullable=false,length=16)
	private String firstName;
	
	@Column(name="second_name",nullable=false,length=16)
	private String secondName;
	
	@Column(name="age",nullable=false)
	private Integer age;
	
	@Column(name="email",nullable=true,length=128)
	private String email;
	
	@Column(name="birthday",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="create_time",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	/**
	 * TemporalType.TIMESTAMP：默认映射数据库中的datatime数据类型，通过columnDefinition让其映射为timestatmp类型，并且自动更新
	 */
	@Column(name="lastmodified",nullable=false,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastmodified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
}
