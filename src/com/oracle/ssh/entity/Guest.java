package com.oracle.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 *���԰���
 *
 */

@Entity
@Table(name="T_GUEST")//����
public class Guest {
	@Id
	@SequenceGenerator(name="generator",sequenceName="SEQ_GUEST_BOOK",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	private Integer id;
	
	@Column(name="NAME")
	private String name;//�û���
	
	@Column(name="GUESTTIME")
	private Date guestTime;//����ʱ��
	
	@Column(name="TITLE")
	private String title;//���Ա���
	
	@Column(name="MESSAGE")
	private String message;//��������

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

	public Date getGuestTime() {
		return guestTime;
	}

	public void setGuestTime(Date guestTime) {
		this.guestTime = guestTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
