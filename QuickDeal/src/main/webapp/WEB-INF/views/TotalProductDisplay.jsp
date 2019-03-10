<%@ page language="java" contentType="text/html"%>
<%@ include file="UserHome.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<h3>TotalProductDisplay</h3>

 <form action="<c:url value="/addToCart/${product.productId}"/>" method="get" >

    <table>
    <tr>
    <td rowspan="7">
    <img  src="<c:url value="/resources/images/${product.productId}.jpg"/>" width=150 height=150/>
    </td>
    <td> Product ID:${product.productId}</td>
    </tr>
    <tr>
    <td>Product Name:${product.productName }</td>
    </tr>  
    <tr>
    <td>Description:${product.productDesc }</td>
    </tr> 
    <tr>
    <td>Category:${product.categoryName }</td>
    </tr> 
    <tr>
    <td>Price:${product.price }</td>
    </tr>  
    <tr>
    <td>Stock:${product.stock }</td>
    </tr>  
      
    <tr>
    <td>Supplier:${product.supplierName }</td>
    </tr>  
    <tr>
    <td colspan="2">
    <input value="1" name="quantity">
     <input type="submit" value="Add to Cart"/></td>
    </tr>
    </table>

    </form>