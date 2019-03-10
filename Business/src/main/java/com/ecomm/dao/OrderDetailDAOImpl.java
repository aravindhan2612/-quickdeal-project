package com.ecomm.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.OrderDetail;
@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {
	
	@Autowired
	  SessionFactory sessionFactory;
	  

	public boolean saveorOrder(OrderDetail orderDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		return false;
	}
	}

	public boolean updateCartItem(String username, int orderId) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session. createQuery("update CartItem set status='p',orderId=:order");
			query.setParameter("username",username);
			query.setParameter("orderId",orderId);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
		return false;
	}

	
	
}
}