package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
      Product product=new Product();
      m.addAttribute(product);
      m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
      m.addAttribute("supplierList",this.getSupplierList(supplierDAO.getSupplier()));
      m.addAttribute("productList",productDAO.listProducts());
      return "Product";
		
}
	
	
	

	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String InsertProduct(@ModelAttribute("Product")Product product,@RequestParam("pimage")MultipartFile pimage,Model m)
	{
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc:"+product.getProductDesc());
		System.out.println("Category Name:"+product.getCategoryName());
		System.out.println("Supplier Name:"+product.getSupplierName());
		System.out.println("Price:"+product.getPrice());
		System.out.println("Stock:"+product.getStock());
		productDAO.addProduct(product);
     
		String path="D:\\project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\QuickDeal\\resources\\images\\";
		
		path=path+String.valueOf(product.getProductId())+".jpg";
		
		File imageFile=new File(path);
		
		if(!pimage.isEmpty())
		{
			try
			{
				byte[] buffer=pimage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception occured"+e);
				m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
			}
		}
		else
		{
			System.out.println("error occured");
			m.addAttribute("Error","Error Occured when the Image Uploaded");
		}
		
            	
		Product product0=new Product();
		m.addAttribute("product",product0);
	
		List<Product> listproducts=productDAO.listProducts();
		m.addAttribute("productList",listproducts);
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.getSupplier()));
		return "Product";	
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")

	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product productN=new Product();
		m.addAttribute("product",productN);
	
		List<Product> listproducts=productDAO.listProducts();
		m.addAttribute("productList",listproducts);
	
		return "Product";
	}
	@RequestMapping(value="/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product1 = productDAO.getProduct(productId);
		m.addAttribute("product",product1);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList",listProducts);
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.getSupplier()));
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String Updateproduct(@RequestParam("productId")int productId,@RequestParam("productDesc")String productDesc,@RequestParam("productName")String productName,@RequestParam("stock")int stock,@RequestParam("price")int price
	,Model m)
	{
		Product product = productDAO.getProduct(productId);
		m.addAttribute("product",product);
		
		product.setProductName(productName);
		product.setStock(stock);
		product.setProductDesc(productDesc);
		product.setPrice(price);
		productDAO.updateProduct(product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
        return "Product";
	}
	
	
	
	

	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		
		LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
		for(Category category:categoryList)
		{
			listCategory.put(category.getCategoryId(),category.getCategoryName());
		}
		return listCategory;
	}
	

	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> supplierList)
	{
		
		LinkedHashMap<Integer,String> listSupplier=new LinkedHashMap<Integer,String>();
		for(Supplier supplier:supplierList)
		{
			listSupplier.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return listSupplier;
	}
	

	@RequestMapping(value="/productDisplay")
	   public String ProductDispaly(Model l)
	   {
		List<Product> listProducts=productDAO.listProducts();
		l.addAttribute("productList",listProducts);
		
		return "ProductDisplay";
	   }
	@RequestMapping("/totalProductDisplay/{productId}")
	public String showTotalProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		m.addAttribute(product1);
		return "TotalProductDisplay";
	}
	

}