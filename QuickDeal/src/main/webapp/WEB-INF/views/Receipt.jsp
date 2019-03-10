<%@ page language="java" contentType="text/html"%>
<%@ include file="UserHome.jsp" %>

<table class="table table-bordered" width="50%" align="center">
<tr bgcolor="orange">
<td>Order ID</td>
<td>${orderDetail.orderId}</td>
<td> Date</td>
<td> <%=new java.util.Date() %>
</td>
</tr>
<tr> 
   <td>Customer</td>
   <td>${orderDetail.username}</td>
   <th>Payment Mode</th>
   <td>${orderDetail.pmode}</td>
</tr>
<tr>
  <th>Address</th>
  <td colspan="3">${orderDetail.addr}</td>
</tr>
</table>

<table width="50%" align="center">
<tr>
<td colspan="5"><center>Your Ordered Items</center></td>
</tr>
<tr>
<tr bgcolor="orange">
		<td>Image</td>
		<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
</tr>
<c:forEach items="${listCartItem }" var="cartItem">
<form action="<c:url value="/updateCartItem/${cartItem.cartId}"/>" method="get">
<tr>
<td><img  src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width=50 height=50/></td>
<td>${ cartItem.productName}</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.price}</td>
<td>${cartItem.quantity*cartItem.price}</td>

</tr>
</form>
</c:forEach>
<tr bgcolor="pink">
<td colspan="4">Grand Total Price</td>
<td colspan="2">${grandTotal}/-</td>
</tr>
<tr>
