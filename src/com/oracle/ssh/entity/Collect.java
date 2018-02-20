package com.oracle.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_COLLECT")
public class Collect {
	@Id
	@SequenceGenerator(name = "generator",sequenceName = "SEQ_COLLECT",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="generator")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;//做外键
	

	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;//做外键
	
	@Column(name="PRICE")
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
