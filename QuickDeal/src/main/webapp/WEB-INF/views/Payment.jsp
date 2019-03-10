<%@ page language="java" contentType="text/html"%>
<%@ include file="UserHome.jsp" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<table>
<td colspan="5"><center> Payment Page </center></td>
<tr>
<td>Image</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
<td>Operation</td>
</tr>
<c:forEach items="${listCartItem }" var="cartItem">
<tr>
<td><img  src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width=50 height=50/></td>
<td>${ cartItem.productName}</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.price}</td>
<td>${cartItem.quantity*cartItem.price}</td>
</tr>

</c:forEach>


<tr>
<td> Total Amount</td>
<td>${grandTotal}/-</td>
</tr>
</table>

<table align="center">
<tr bgcolor="white">
<td><a class="btn btn-info" href="<c:url value="/cartItem"/>">EditCart</a></td>
</tr>
</table>

<form action="<c:url value="/receipt"/>" method="post"> 
<table class="table-bordered" align="center">
<tr bgcolor="pink">
<td>PaymentDetail</td>
<td>
  <input type="radio" name="pmode" value="COD"/>Cash On Delivery
  <input type="radio" name="pmode" value="CC"/>CreditCard
  </td>
</tr>

<tr bgcolor="pink"   class="varing">
<td>CreditCard</td>
<td><input type="text" name="cardno"/></td>
</tr>

<tr bgcolor="pink" class="varing"> 
<td>CVV<input type="text" name="cvv"/></td>
<td>ValidUpto<input type="text" name="valid"/></td>
</tr>
<tr  bgcolor="pink" class="success">
<td>Name</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td><input type="submit" class="btn btn-info" value="PlaceOrder"></td>
</tr> 
</table>
</form>




