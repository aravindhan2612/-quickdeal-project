package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartItemDAO;

import com.ecomm.model.CartItem;


public class CartItemDAOUnitTestCases {
	static CartItemDAO cartItemDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		cartItemDAO=(CartItemDAO)context.getBean("cartItemDAO");
	}
		
		@Test
		public void addCartItemTest()
		{
			CartItem cartItem=new CartItem();
			cartItem.setCartId(2);
			cartItem.setProductId(200);
			cartItem.setProductName("xiaomiredmi note5");
			cartItem.setUsername("aravnd26");
			cartItem.setQuantity(1);
			cartItem.setStatus("NP");
			cartItem.setPrice(10000);
			System.out.println("creating add test" );
			assertTrue("Problem in CartItem Insertion",cartItemDAO.addCartItem(cartItem));
		}
		
		
		
		@Ignore
		@Test
		public void deleteCartItemTest()
		{
			CartItem cartItem=cartItemDAO.getCartItem(2);
			assertTrue("Problem in Deletion:",cartItemDAO.deleteCartItem(cartItem));
		}
	    @Ignore
		@Test
		public void updateCartItemTest()
		{
			CartItem cartItem=cartItemDAO.getCartItem(1);
			cartItem.setQuantity(2);
			assertTrue("Problem in Updation",cartItemDAO.updateCartItem(cartItem));
		}

		@Ignore
		@Test
		public void listCartItemUnitTest()
		{
			List<CartItem> listCartItem=cartItemDAO.listCartItem("name" );
			
			assertTrue("Problem in Listing CartItem:",listCartItem.size()>0);
			
			for(CartItem cartItem:listCartItem)
			{
				System.out.print(cartItem.getCartId()+"\t");
				System.out.print(cartItem.getProductId()+"\t");
				System.out.print(cartItem.getProductName()+"\t");
				System.out.print(cartItem.getUsername()+"\t");
				System.out.print(cartItem.getQuantity()+"\t");
				System.out.print(cartItem.getStatus()+"\t");
				System.out.println(cartItem.getPrice());
			}
		}
		
		@Ignore
		@Test
		public void getCartItemTest()
		{
			assertNotNull("Problem in get CartItem",cartItemDAO.getCartItem(2));
		}
		
}
