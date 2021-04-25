package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;
@Controller
public class CartController {
	
	@Autowired
	UserDetailDAO userDetailDAO;
	@Autowired
	CartItemDAO cartItemDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/cartItem")
	public String viewcart(Model m,HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		return "CartItem";
	
	}
	
	

	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session, Model m)
		{
			CartItem cartItem=new CartItem();
			Product product=productDAO.getProduct(productId);
			
			String username=(String)session.getAttribute("username");
			cartItem.setProductId(productId);
			cartItem.setProductName(product.getProductName());
			cartItem.setQuantity(quantity);
			cartItem.setUsername(username);
			cartItem.setStatus("NP");
			cartItem.setPrice(product.getPrice());
		
			cartItemDAO.addCartItem(cartItem);
			List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
			m.addAttribute("listCartItem",listCartItems);
			m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
			return "CartItem";
	}
	
	@RequestMapping(value="/updateCartItem/{cartId}")
	public String updateCartItem(@PathVariable("cartId")int cartId,Model l,HttpSession session,@RequestParam("quantity")int quantity)
	{
		String username=(String)session.getAttribute("username");
		CartItem cart=cartItemDAO.getCartItem(cartId);
		cart.setQuantity(quantity);
		cartItemDAO.updateCartItem(cart);
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		l.addAttribute("listCartItem",listCartItems);
		l.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		
		return "CartItem";
		
	}
	
	
	
	@RequestMapping("/deleteCartItem/{cartId}")
	public String deleteCartItem(@PathVariable("cartId")int cartId,HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		CartItem cart=cartItemDAO.getCartItem(cartId);
		cartItemDAO.deleteCartItem(cart);
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		
		return "CartItem";
		
	}
	
	@RequestMapping("/orderConfirm")
	public String orderConfirmation(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		
		UserDetail user=userDetailDAO.getUser(username);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("addr",user.getAddr());
		return "orderConfirm";
	}
	
	@RequestMapping(value="/checkout")
	public String Checkout(Model l,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		
		l.addAttribute("listCartItem",listCartItems);
		l.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		
		return "OrderConfirm";
	}
	
	
	
	@RequestMapping("/updateAddress/{userId}")
	public String updateAddress(@PathVariable("userId")int UserId,@RequestParam("address") String addr,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		
		UserDetail user=userDetailDAO.getUser(username);
		user.setAddr(addr);
		userDetailDAO.updateUser(user);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
	
		return "orderConfirm";
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
		System.out.print("test"+grandTotal);
		System.out.print("checking merge");
		return grandTotal;
	}
		
}
