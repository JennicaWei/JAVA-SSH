package com.oracle.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCT")//����
public class Product {
	@Id
	private Integer id;
	@Column(name="NAME")
	private String name;//����
	@Column(name="DESCRIBE")
	private String describe;//����
	@Column(name="PRICE")
	private Double price;//�۸�
	@Column(name="STOCK")
	private Integer stock;//���
	
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")//���������
	private Category category;//�������
	
	@Column(name="IMG_PATH")
	private String imgPath;//ͼƬ��ַ

	public Product() {
		// TODO �Զ����ɵĹ��캯�����
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
