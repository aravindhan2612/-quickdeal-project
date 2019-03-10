<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ include file="AdminHome.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body class="main" background="<c:url value="/resources/images/design2.jpg"/>">
<h2 align="center">Product Page</h2>
<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">

<table align="center">
  <tr >
<td colspan="2"><center>Product Form</center></td></tr>
<tr>
 <td>ProductName</td>
 <td><form:input type="text" path="productName"/></td>
 </tr>
 
 <tr>
 <td>ProductDesc</td>
 <td><form:input  type="text" path="productDesc"/></td>
 </tr>
 <tr>
 <td>Price</td>
 <td><form:input type="text" path="price"/></td>
 </tr>
<tr>
 <td>Stock</td>
 <td><form:input type="text"  path="stock"/></td>
 </tr>
 <tr>
 <td>CategoryName</td>
 <td>
 <form:select  type="text"  path="categoryName">
     <form:option value="0" label="---select--"/>
     <form:options items="${categoryList}"/>
     </form:select>
</td>     
 </tr>
 <tr>
 <td>SupplierName</td>
 <td>
 <form:select  type="text"  path="supplierName">
     <form:option value="0" label="---select--"/>
     <form:options items="${supplierList}"/>
     </form:select>
</td>     
 </tr>
 <tr>
		<td> Product Image </td>
		<td><form:input type="file" path="pimage"/></td>
	</tr>
 <tr>
		<td colspan="2"><center><input type="submit" value="Insert Product"/></center></td>
	</tr>
	</table>
</form:form>	
	<table align="center" border="1">
	<tr>
	<td>Image</td>
	<td>ProductID</td>
	<td>ProductName</td>
	<td>ProductDesc</td>
	<td>Price</td>
	<td>Stock</td>
	<td>CategoryName</td>
	<td>SupplierName</td>
	<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
	    <td><img  src="<c:url value="/resources/images/${product.productId}.jpg"/>" width=50 height=50/></td>
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>${product.categoryName}</td>
		<td>${product.supplierName}</td>
		<td>
			<a href="<c:url value="/updateProduct/${product.productId}"/>">Edit</a>
			<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
