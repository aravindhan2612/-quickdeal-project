<%@ page language="java" contentType="text/html"%>
    <%@include file="Header.jsp"%>
    <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<form action="<c:url value="/UpdateProduct"/>" method="post">
<table align="center">
<tr>
		<td colspan="2"><center>Product Update</center></td>
	</tr>
<tr>
<td>ProductId:</td>
<td><input type="text" id="productId" name="productId" value="${product.productId}"/></td>
</tr>
<tr>
<td>ProductName:</td>
<td><input type="text" id="productName" name="productName" value="${product.productName}"/></td>
</tr>
<tr>
<td>ProductDesc:</td>
<td><input type="text" id="productDesc" name="productDesc" value="${product.productDesc}"/></td>
</tr>

<td>Price:</td>
<td><input type="text" id="price" name="price" value="${product.price}"/></td>
</tr>
<tr>
<td> Stock:</td>
<td><input type="text" id="stock" name="stock" value="${product.stock}"/></td>
</tr>
<tr>
 <td><center><input class="btn btn-success" type="submit" value="Update"/></center></td>
 </tr>
  </table> 
</form>