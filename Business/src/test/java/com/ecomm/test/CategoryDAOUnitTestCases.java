package com.ecomm.test;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;



public class CategoryDAOUnitTestCases {
static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
   
	@Test
	public void addCategoryUnitTest()
	{
		Category category=new Category();
		category.setCategoryName("XiaomiMobile");
		category.setCategoryDesc("All Xiaomi Smart Phone Mobile");
		
		assertTrue("Problem in adding the Category",categoryDAO.addCategory(category));
	}
	
	@Test
	public void updateCategoryUnitTest()
	{
		Category category=categoryDAO.getCategory(44);
		category.setCategoryName("honor");
		category.setCategoryDesc("all variety of honor mobile are available");
		
		assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	
	@Test
	public void deleteCategoryUnitTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category:",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesUnitTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing Category:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+"\t");
			System.out.print(category.getCategoryName()+"\t");
			System.out.println(category.getCategoryDesc());
		}
	}

}
