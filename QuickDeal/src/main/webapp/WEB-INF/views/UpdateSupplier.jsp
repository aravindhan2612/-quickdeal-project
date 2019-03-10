<%@ page language="java" contentType="text/html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>SupplierUpdation</title>

<form class="form-horizontal" action="<c:url value="/UpdateSupplier"/>" method="post">
<table align="center">
   <tr>
		<td colspan="2"><center>Supplier update</center></td>
	</tr>
	<tr>
<td>Supplier ID</td>
<td><input type="text" class="form-control" readonly id="supplierId" name="supplierId" value="${supplierInfo.supplierId}"/></td>
</tr>
<tr>
<td> Supplier Name</td>
<td><input type="text" class="form-control" id="supplierName" name="supplierName" value="${supplierInfo.supplierName}"/></td>
</tr>
<tr>
<td>supplier Desc</td>
<td> <input type="text" class="form-control" id="supplierDesc" name="supplierDesc" value="${supplierInfo.supplierDesc}"/></td>
</tr>
 <tr>
 <td colspan="1"><center><button type="submit" class="btn btn-default">update</button></center></td>
     <td colspan="1"><center> <button type="submit" class="btn btn-default">Reset</button></center></td>
     </tr> 
      </table>
     
      <table align="center" border="1">
	   <tr>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation</td>
       </tr>
	<c:forEach items="${supplierList}" var="supplier">
		<tr>
			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierDesc}</td>
			<td><a href="<c:url value="/updateSupplier/${supplier.supplierId}"/>">Update</a>/
				<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</form>