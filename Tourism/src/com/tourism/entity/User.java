package com.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_user")
public class User implements java.io.Serializable {
	@Id
	@GeneratedValue(generator="idGenerator")
	@GenericGenerator(name="idGenerator", strategy="assigned")
	@Column(length=32,name="userId")
	private Integer _id;
	
	@Column(length=32,unique=true,nullable=false,name="username")
	private String _username;

	@Column(length=32,unique=true,nullable=false,name="email")
	private String _email;
	
	@Column(length=4,name="age")
	private int _age;

	@Column(length=4,name="sex")
	private int _sex;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public int getSex() {
		return _sex;
	}

	public void setSex(int sex) {
		_sex = sex;
	}

}
