package com.oracle.ssh.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")//表名
public class User {
	@Id
	@SequenceGenerator(name="generator",sequenceName="SEQ_USER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	private Integer id;//主键id
	@Column(name="USERNAME")
	private String username;//用户名
	@Column(name="PASSWORD")
	private String password;//密码
	@Column(name="SEX")
	private String sex;//性别
	@Column(name="BIRTHDAY")
	private Date birthday;//生日
	@Column(name="ID_CARD")
	private String idCard;//身份证号
	@Column(name="EMALL")
	private String email;//电子邮箱
	@Column(name="MOBILE")
	private String mobile;//手机
	@Column(name="ADDRESS")
	private String address;//地址
	
	//不带参数构造方法
	
	public User() {
		// TODO 自动生成的构造函数存根
	}
	
	
	
	//带参数构造方法
	public User(Integer id, String username, String password, String sex,
			Date birthday, String idCard, String email, String mobile,
			String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.idCard = idCard;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
