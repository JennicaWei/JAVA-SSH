package com.oracle.ssh.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * ������
 *
 */
@Entity
@Table(name="T_ORDER")//����
public class Order {
	@Id
	@SequenceGenerator(name="generator",sequenceName="SEQ_ORDER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	private Integer id;
	

	@ManyToOne
	@JoinColumn(name="USER_ID")//���������
	private User user;//�û�
	
	@Column(name="USERNAME")
	private String username;//�û���
	@Column(name="USER_ADDRESS")
	private String userAddress;//�û���ַ
	@Column(name="CREATE_TIME")
	private Date createTime;//����ʱ��
	@Column(name="TOTAL")
	private Double total;//�ܼ�
	@Column(name="STATUS")
	private Integer status;//״̬
	
	//һ�Զ��һ��һ��������
	@OneToMany (mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<OrderItem>orderItems=new HashSet<OrderItem>();//�������
	
	public Order() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
}
