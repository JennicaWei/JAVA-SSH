package com.oracle.ssh.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.CartService;
import com.oracle.ssh.service.ProductService;




@Scope(value="prototype")//����������Ϊprototype,ÿ�ζ����µ�ʵ��
@Component
@ParentPackage("custom-default")
@InterceptorRefs({@InterceptorRef("myStack")})//����������
public class CartAction extends ActionSupport{
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	private List<Cart> cartList;//���ﳵ�б�
	
	//��Ʒ��ӵ����ﳵ
	
	@Action(value="addCart",results={@Result(name="success",location="listCart",type="redirect")})
	public String add(){
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		User loginUser=(User)session.get("loginUser");//��ȡ��ǰ��½�û�
		
		HttpServletRequest request=ServletActionContext.getRequest();//��ȡrequest
		Integer productId=Integer.parseInt(request.getParameter("productId"));//��ȡ������Ʒid
		Product product=productService.getById(productId);
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));//��ȡ������Ʒ����
		
		//����Ʒid���û�id������Ʒ
		Cart cart=cartService.getByProductIdAndUserId(productId, loginUser.getId());
		//���cart����null��˵�����ﳵû����Ӵ˲�Ʒ
		if(cart==null){
			cart=new Cart();
			cart.setUser(loginUser);//����û�
			cart.setProduct(product);//�����Ʒ�����ﳵ
			cart.setQuantity(quantity);
			cart.setPrice(product.getPrice());
			cartService.create(cart);//�ѹ��ﳵ���浽���ݿ�
			System.out.println("���"+product.getName()+"�����ﳵ�ɹ�");
		}else{
			cart.setQuantity(cart.getQuantity()+quantity);//
			cartService.update(cart);//���¹��ﳵ
			System.out.println("����"+product.getName()+"�����ﳵ�ɹ�");
			
		}
		
		return "success";
	}
	
	//�鿴���ﳵ�б�
	@Action(value="listCart",results={@Result(name="success",location="cart.jsp")})
	public String list(){
		System.out.println("11111");
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		User loginUser=(User)session.get("loginUser");//��ȡ��ǰ��½�û�
		
		cartList=cartService.getByUserId(loginUser.getId());//��ȡ��ǰ��½�û��Ĺ��ﳵ�б�
		System.out.println("22222");
		return "success";
	}
	
	@Action(value="deleteCart",results={@Result(name="success",location="listCart",type="redirect")})
	public String delete(){
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		User loginUser=(User)session.get("loginUser");//��ȡ��ǰ��½�û�
		
		HttpServletRequest request=ServletActionContext.getRequest();//��ȡrequest
		Integer cartId=Integer.parseInt(request.getParameter("id"));//��ȡҪɾ���Ĺ��ﳵ���id
		Cart cart=cartService.getByIdAndUserId(cartId, loginUser.getId());//��ȡ��ǰ�û��Ĺ��ﳵ��
		cartService.delete(cart);//ɾ�����ﳵ��
		System.out.println("ɾ�����ﳵ"+cart.getProduct().getName()+"�ɹ�");
		
		return "success";
		
	}

	public List<Cart> getCartList() {
		return cartList;
	}

}
