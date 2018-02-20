package com.oracle.ssh.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * *
 * ��Ʒ����r
 *
 */

@Entity
@Table(name="T_PRODUCT_CATEGORY")//����
public class Category {
	@Id
	private Integer id;
	@Column(name="NAME")
	private String name;//����
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID")//���������
	private Category parent;//��������ID
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Category> categories=new HashSet<Category>();
	
	

public Category() {
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


public Category getParent() {
	return parent;
}
public void setParent(Category parent) {
	this.parent = parent;
}
public Set<Category> getCategories() {
	return categories;
}
public void setCategories(Set<Category> categories) {
	this.categories = categories;
}



	
}
