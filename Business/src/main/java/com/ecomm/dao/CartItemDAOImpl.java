package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {
  @Autowired
  SessionFactory sessionFactory;
  
    
	public boolean addCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
		
	}

	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public List<CartItem> listCartItem(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where username=:username and Status='NP'");
		query.setParameter("username",username);
		List<CartItem> listCartItem=query.list();
		return listCartItem;
	}

	public CartItem getCartItem(int cartId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartId);
		session.close();
		return cartItem;
		
		
	}
	
	

}
