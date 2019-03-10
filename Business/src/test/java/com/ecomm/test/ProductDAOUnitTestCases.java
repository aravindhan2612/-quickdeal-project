package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOUnitTestCases {
	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(2);
		product.setCategoryName("xiaomi");
		product.setSupplierName("bluedart");
		product.setPrice(10000);
		product.setStock(100);
		product.setProductName(" xiaomiredmi note5 ");
		product.setProductDesc("with snapdragon 625 processor and full screen display ");
		assertTrue("Problem in Product Insertion",productDAO.addProduct(product));
	}
	
	
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(75));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(9);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(10);
		product.setPrice(5000);
		product.setStock(20);
		
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getCategoryName()+":::");
			System.out.print(product.getSupplierName()+":::");
			System.out.print(product.getStock()+":::");
			System.out.print(product.getPrice()+":::");
			System.out.print(product.getProductName()+":::");		
			System.out.println(product.getProductDesc());
		}
	}


}
