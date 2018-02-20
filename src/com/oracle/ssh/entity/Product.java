package com.oracle.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCT")//表名
public class Product {
	@Id
	private Integer id;
	@Column(name="NAME")
	private String name;//名称
	@Column(name="DESCRIBE")
	private String describe;//描述
	@Column(name="PRICE")
	private Double price;//价格
	@Column(name="STOCK")
	private Integer stock;//库存
	
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")//配置外键列
	private Category category;//分类对象
	
	@Column(name="IMG_PATH")
	private String imgPath;//图片地址

	public Product() {
		// TODO 自动生成的构造函数存根
	}

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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
}
