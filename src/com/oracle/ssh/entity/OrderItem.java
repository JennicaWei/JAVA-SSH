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
 * ��������
 *
 */
@Entity
@Table(name="T_ORDER_ITEM")//����
public class OrderItem {
	@Id
	
	@SequenceGenerator(name="generator",sequenceName="SEQ_ORDER_ITEM",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	
	private Integer id;
	
	//@Column(name="ORDER_ID")
	//private Integer orderId;//����id
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")//���������
	private Order order;//��Ʒ
	
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")//���������
	private Product product;//��Ʒ
	
	@Column(name="QUANTITY")
	private Integer quantity;//����
	@Column(name="PRICE")
	private Double price;//����
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
