<%@ page language="java" contentType="text/html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>CategoryUpdation</title>

<form class="form-horizontal" action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center">
   <tr>
		<td colspan="2"><center>Category update</center></td>
	</tr>
	<tr>
<td>Category ID</td>
<td><input type="text" class="form-control" readonly id="categoryId" name="categoryId" value="${category.categoryId}"/></td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" class="form-control" id="categoryName" name="categoryName" value="${category.categoryName}"/></td>
</tr>
<tr>
<td>Category Desc</td>
<td> <input type="text" class="form-control" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc}"/></td>
</tr>
 <tr>
 <td colspan="1"><center><button type="submit" class="btn btn-default">update</button></center></td>
     <td colspan="1"><center> <button type="submit" class="btn btn-default">Reset</button></center></td>
     </tr> 
      </table>
     
      <table align="center" border="1">
	   <tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
       </tr>
	<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDesc}</td>
			<td><a href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>/
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</form>