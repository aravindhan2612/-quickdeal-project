package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class OrderController {
	@Autowired
	UserDetailDAO userDetailDAO;
	@Autowired
	CartItemDAO cartItemDAO;
@Autowired
OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("/payment")
	public String showPaymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		return "Payment";
		
	}

	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String showReceipt(@RequestParam("pmode")String pmode,HttpSession session,Model m )
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		
		OrderDetail order=new OrderDetail();
		order.setUsername(username);
		order.setOrderDate(new java.util.Date());
	
		order.setPmode(pmode);
		order.setTotalAmount(this.calcGrandTotalPrice(listCartItems));
		orderDetailDAO.saveorOrder(order);
		
		orderDetailDAO.updateCartItem(username, order.getOrderId());
		
		
	
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("listCartItem",cartItemDAO.listCartItem(username));
		m.addAttribute("orderDetail",order);
		
	 
		

		return "Receipt";
	}

	
	public int calcGrandTotalPrice(List<CartItem> listCartItem)
	{
		int grandTotal=0;
		int count=0;
		while(count<listCartItem.size())
		{
			CartItem cartItem=listCartItem.get(count);
			grandTotal=grandTotal+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
			
		}
		return grandTotal;
	}
	
}



