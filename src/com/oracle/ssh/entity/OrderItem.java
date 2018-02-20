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

/**
 * 
 * 订单项类
 *
 */
@Entity
@Table(name="T_ORDER_ITEM")//表名
public class OrderItem {
	@Id
	
	@SequenceGenerator(name="generator",sequenceName="SEQ_ORDER_ITEM",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	
	private Integer id;
	
	//@Column(name="ORDER_ID")
	//private Integer orderId;//订单id
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")//配置外键列
	private Order order;//商品
	
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")//配置外键列
	private Product product;//商品
	
	@Column(name="QUANTITY")
	private Integer quantity;//数量
	@Column(name="PRICE")
	private Double price;//单价
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

	

}
